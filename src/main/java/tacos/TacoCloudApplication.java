package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(final String[] args) {

		// Ingredient ingredient = new Ingredient("ABC123 ID", "taco shell",
		// Type.CHEESE);

		SpringApplication.run(TacoCloudApplication.class, args);
	}
}
