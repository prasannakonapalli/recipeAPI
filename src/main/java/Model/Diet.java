package Model;

import java.util.List;

public class Diet { 

	private Recipe recipe;  
	private List<Recipe> recipes;
	
	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}


	public Diet() {
		super();
	}


	@Override
	public String toString() {
		return "Diet [recipe=" + recipe + "]";
	} 

	
	
	
}
