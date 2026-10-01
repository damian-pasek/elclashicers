package pl.elclashicers.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.elclashicers.entity.User;

import java.time.OffsetDateTime;
import java.util.UUID;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {
    @Test
    @DisplayName("Should return correct user details")
    void shouldReturnCorrectUserDetails(){
        User user = User.builder()
                .id(UUID.randomUUID())
                .username("testuser")
                .passwordHash("hashed_password")
                .createdAt(OffsetDateTime.now())
                .build();

        assertThat(user.getId()).isNotNull();
        assertThat(user.getUsername()).isEqualTo("testuser");
        assertThat(user.getPasswordHash()).isEqualTo("hashed_password");
        assertThat(user.getCreatedAt()).isNotNull();
    }


}
