package Model;

public class Diet {

	private RecipeResponse recipe;

	public Diet() {
		super();
	}

	public RecipeResponse getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeResponse recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "Diet [recipe=" + recipe + "]";
	} 
	
	
	
}
