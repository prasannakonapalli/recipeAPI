package Model;

import java.util.List;

public class Recipe {

	private String uri;
	private String label; 
	private String image; 
	private String url; 
	private String shareAs; 
	private List<String> dietLabels;
	private List<String> ingredientLines;
	
	private Double calories;
	
	
	
	public String getShareAs() {
		return shareAs;
	}
	public void setShareAs(String shareAs) {
		this.shareAs = shareAs;
	}
	public List<String> getIngredientLines() {
		return ingredientLines;
	}
	public void setIngredientLines(List<String> ingredientLines) {
		this.ingredientLines = ingredientLines;
	}
	
	
	
	
	public Recipe() {
		super();
	}
	public Recipe(String uri, String label, String image, String url, List<String> dietLabels, Double calories) {
		super();
		this.uri = uri;
		this.label = label;
		this.image = image;
		this.url = url;
		this.dietLabels = dietLabels;
		this.calories = calories;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getDietLabels() {
		return dietLabels;
	}
	public void setDietLabels(List<String> dietLabels) {
		this.dietLabels = dietLabels;
	}
	public Double getCalories() {
		return calories;
	}
	public void setCalories(Double calories) {
		this.calories = calories;
	}
	@Override
	public String toString() {
		return "Recipe [uri=" + uri + ", label=" + label + ", image=" + image + ", url=" + url + ", dietLabels="
				+ dietLabels + ", calories=" + calories + "]";
	}
	
	
	
}
