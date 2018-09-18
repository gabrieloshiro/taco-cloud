package tacos;

import java.util.List;

import lombok.Data;

@Data
public class Taco {
	
	private List<Ingredient> ingredients;

	private String name;
	
}
