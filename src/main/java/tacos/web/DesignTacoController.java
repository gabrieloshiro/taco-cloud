package tacos.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.Design;
import tacos.Ingredient;
import tacos.Taco;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

	final private List<Ingredient> ingredients = Arrays.asList(
			new Ingredient("FLTO", "Flower Tortilla", Ingredient.Type.WRAP),
			new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
			new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
			new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
			new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
			new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
			new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
			new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
			new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
			new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	@GetMapping
	public String showDesignForm(final Model model) {

		log.debug("GET /design");
		
		final Ingredient.Type[] types = Ingredient.Type.values();
		for (final Ingredient.Type type : types) {
			String ingredientsSetName = type.toString().toLowerCase();
			log.debug("Adding " + ingredientsSetName + ":");
			
			List<Ingredient> ingredients = filterByType(getIngredients(), type);
			for (Ingredient ingredient : ingredients) {
				log.debug(ingredient.getId() + " " + ingredient.getName());
			}
				
			model.addAttribute(ingredientsSetName, ingredients);
		}

		model.addAttribute("design", new Taco());

		return "design";
	}
	
	@PostMapping
	public String processDesign(Design design) {
		log.info("Processing design: " + design);
		
		return "redirect:/orders/current";
	}

	private List<Ingredient> filterByType(final List<Ingredient> ingredients, final Ingredient.Type type) {
		return ingredients.stream().filter(element -> element.getType().equals(type)).collect(Collectors.toList());
	}

}
