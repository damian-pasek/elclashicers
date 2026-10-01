package pl.elclashicers.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import pl.elclashicers.TestcontainersConfiguration;
import pl.elclashicers.entity.User;
import pl.elclashicers.repository.UserRepository;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
@Transactional
class UserRepositoryIT {

	@Autowired
	private UserRepository userRepository;

	@Test
	@DisplayName("Should save and find by username")
	void shouldSaveAndFindByUsername() {
		User user = User.builder()
				.username("Alice")
				.passwordHash("$2a$10$abcdefghijklmnopqrstuv")
				.build();

		User savedUser = userRepository.saveAndFlush(user);
		User foundUser = userRepository.findByUsername("Alice").orElseThrow();

		assertThat(savedUser.getId()).isNotNull();
		assertThat(foundUser.getId()).isEqualTo(savedUser.getId());
		assertThat(foundUser.getUsername()).isEqualTo("Alice");
		assertThat(foundUser.getPasswordHash()).isEqualTo("$2a$10$abcdefghijklmnopqrstuv");
		assertThat(foundUser.getCreatedAt()).isNotNull();
	}

	@Test
	@DisplayName("Should find username without regard to case")
	void shouldFindUsernameWithoutRegardToCase() {
		User user = User.builder()
				.username("Alice")
				.passwordHash("$2a$10$abcdefghijklmnopqrstuv")
				.build();

		User savedUser = userRepository.saveAndFlush(user);
		User foundUser = userRepository.findByUsername("ALICE").orElseThrow();

		assertThat(foundUser.getId()).isEqualTo(savedUser.getId());
		assertThat(foundUser.getUsername()).isEqualTo("Alice");
	}
}
