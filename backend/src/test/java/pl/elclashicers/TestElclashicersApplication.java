package pl.elclashicers;

import org.springframework.boot.SpringApplication;

public class TestElclashicersApplication {

	public static void main(String[] args) {
		SpringApplication.from(ElclashicersApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
