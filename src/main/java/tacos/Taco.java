package tacos;

import java.util.List;

import lombok.Data;

@Data
public class Taco {
	
	private List<String> ingredients;

	private String name;
	
}
