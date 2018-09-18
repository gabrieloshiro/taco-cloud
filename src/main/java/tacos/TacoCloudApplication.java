package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tacos.Ingredient.Type;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		
		//Ingredient ingredient = new Ingredient("ABC123 ID", "taco shell", Type.CHEESE);
		
		SpringApplication.run(TacoCloudApplication.class, args);
	}
}
