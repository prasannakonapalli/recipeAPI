package Model;

import java.util.List;

public class Recipe {

	private String uri;
	private String label; 
	private String image; 
	private String url; 
	private List dietLabels;
	private Double calories;
	
	
	
	public Recipe() {
		super();
	}
	public Recipe(String uri, String label, String image, String url, List dietLabels, Double calories) {
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
	public List getDietLabels() {
		return dietLabels;
	}
	public void setDietLabels(List dietLabels) {
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