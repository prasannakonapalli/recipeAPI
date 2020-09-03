package co.grandcircus.recipeAPI;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Model.Diet;
import Model.Recipe;
import Model.RecipeResponse;
import Model.SearchRecipeParameter;

import co.grandcircus.recipeAPI.Dao.RecipeDao;
import co.grandcircus.recipeAPI.Entity.RecipeEntity;

@Controller
public class RecipeController {

	@Autowired
	ApiService apiServ;

	@Autowired
	RecipeDao recipeDao;
	

	@Autowired
	private HttpSession session;

	@RequestMapping("/")
	public String home() {
		return "redirect:/search-recipe";
	}

	@RequestMapping("/search-recipe")
	public String showInputForm() {
		return "search-recipe";
	}

	@PostMapping("/show-results")

	public String showResults(@RequestParam String searchText, @RequestParam(required = false) String cals,
			@RequestParam(required = false) String diet, Model model, @RequestParam String recordCount) {

		RecipeResponse response;

		response = apiServ.getRecipes(searchText, cals, diet, recordCount); 

		if (response != null && response.getHits() != null) {
			List<Diet> HitsData = response.getHits();
 
			List<Recipe> recipes = new ArrayList<Recipe>();
			HitsData.forEach(r -> recipes.add(r.getRecipe()));

			model.addAttribute("recipes", recipes);
			
			SearchRecipeParameter params=new SearchRecipeParameter();			
			params.setSearchText(searchText);
			params.setCals(cals);
			params.setDiet(diet);
			params.setRecordCount(recordCount);

			session.setAttribute("searchParameters", params);
			 

		}
		return "show-results";
	}

	

	@RequestMapping("/recipeById")
	public String showRecipeById(@RequestParam String recipeId, Model model) {
		// Recipe recipe[];
		Recipe recipe;
		recipe = apiServ.getRecipeById(recipeId).get(0);
		model.addAttribute("recipe", recipe);
		return "recipeDetailPage";

	}

	@RequestMapping("/addFavorite")
	public String addFavorite(@RequestParam String recipeId, Model model) {

		RecipeEntity recFav = new RecipeEntity();

		recFav.setFavorite(true);
		recFav.setUri(recipeId);
		recipeDao.save(recFav);
		return "redirect:/showExistingResults";
	}
	
	
	@RequestMapping("/showExistingResults")
	public String showRecipes( Model model) {
		// new object of RecipeResponse
		RecipeResponse response;

		SearchRecipeParameter params = (SearchRecipeParameter) session.getAttribute("searchParameters");
		response = apiServ.getRecipes(params.getSearchText(), params.getCals(), params.getDiet(),
				params.getRecordCount());

		if (response != null && response.getHits() != null) {
			List<Diet> HitsData = response.getHits();

			List<Recipe> recipes = new ArrayList<Recipe>();
			HitsData.forEach(r -> recipes.add(r.getRecipe()));
			model.addAttribute("recipes", recipes);

		}
		return "show-results";
	}
	
	
	@RequestMapping("/favoriteList")
	public String showfavoriteList( Model model) {
		// Recipe recipe[];
		List<String> urls =new ArrayList<String>();
		List<Recipe> recipes = new ArrayList<>();
		urls =  recipeDao.findByIsFavorite();		
		
		for (String url : urls) {
			
			recipes.add(apiServ.getRecipeById(url).get(0));			 
		}

		//recipe = apiServ.getRecipeById(recipeId);
		model.addAttribute("recipes", recipes);
		return "favorite-list";

	}
	
	@RequestMapping("/removeFavorite")
	public String removeFavorite(@RequestParam String recipeId, Model model) {

		RecipeEntity recFav = new RecipeEntity();

		recFav.setFavorite(false);
		recFav.setUri(recipeId);
		recipeDao.save(recFav);
		return "redirect:/favoriteList";
	}


	
//	private getRecipeData() {
//		RecipeResponse response;
//		response = apiServ.getRecipes(params.getSearchText(), params.getCals(), params.getDiet(),
//				params.getRecordCount());
//		if (response != null && response.getHits() != null) {
//			List<Diet> HitsData = response.getHits();
//
//			List<Recipe> recipes = new ArrayList<Recipe>();
//			HitsData.forEach(r -> recipes.add(r.getRecipe()));
//			model.addAttribute("recipes", recipes);
//
//		}
//	}

}
