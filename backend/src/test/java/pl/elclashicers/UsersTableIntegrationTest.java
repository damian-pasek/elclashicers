package pl.elclashicers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
@Transactional
class UsersTableIntegrationTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void shouldCreateUserRecord() {
		String username = "alice";
		String passwordHash = "$2a$10$abcdefghijklmnopqrstuv";

		jdbcTemplate.update(
				"INSERT INTO users (username, password_hash) VALUES (?, ?)",
				username,
				passwordHash
		);

		Map<String, Object> savedUser = jdbcTemplate.queryForMap(
				"SELECT id, username, password_hash, created_at FROM users WHERE username = ?",
				username
		);

		assertThat(savedUser.get("id")).isNotNull();
		assertThat(savedUser.get("username")).isEqualTo(username);
		assertThat(savedUser.get("password_hash")).isEqualTo(passwordHash);
		assertThat(savedUser.get("created_at")).isNotNull();
	}
}
