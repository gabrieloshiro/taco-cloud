package tacos;

import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Taco {

	@NonNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;

	@Size(min = 1, message = "You must choose at least 1 ingredient")
	private List<String> ingredients;

}
