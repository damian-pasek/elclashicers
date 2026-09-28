package pl.elclashicers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import pl.elclashicers.config.TestcontainersConfiguration;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ElclashicersApplicationTests {

	@Test
	void contextLoads() {
	}

}
