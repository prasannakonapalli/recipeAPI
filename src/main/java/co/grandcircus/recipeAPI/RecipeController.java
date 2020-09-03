package co.grandcircus.recipeAPI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Model.Diet;
import Model.Recipe;
import Model.RecipeResponse;

@Controller
public class RecipeController {

	@Autowired
	ApiService apiServ;

	@RequestMapping("/")
	public String home() {
		return "redirect:/search-recipe";
	}

	@RequestMapping("/search-recipe")
	public String showInputForm() {
		return "search-recipe";
	}
 
	@PostMapping("/show-results")

	public String showResults(@RequestParam String text, 
			@RequestParam(required=false) String cals, 
			@RequestParam(required=false) String diet,
			Model model,@RequestParam String recordCount) {

		RecipeResponse response;

		response = apiServ.getRecipes(text, cals, diet,recordCount);
		//response = apiServ.getRecipes(text, cals, diet);
		

		if (response != null && response.getHits() != null) {
			List<Diet> HitsData = response.getHits();
			
			//System.out.println( "data:" + data.size());
			List<Recipe> recipes=new ArrayList<Recipe>();
			HitsData.forEach(r-> recipes.add(r.getRecipe()));
			
			
			
			String searchText = text;

			model.addAttribute("recipes", recipes);
			

			model.addAttribute("searchText", searchText);

		}
		return "show-results";
	}
	
	@RequestMapping("/recipeById")
	public String showRecipeById(@RequestParam String recipeId,Model model) {
		//Recipe recipe[];
		Recipe recipe; 
		recipe = apiServ.getRecipeById(recipeId).get(0);
		model.addAttribute("recipe", recipe);
		return "recipeDetailPage";
	
		
	}

}
