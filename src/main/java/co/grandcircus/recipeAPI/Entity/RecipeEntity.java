package co.grandcircus.recipeAPI.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fav_recipe")
public class RecipeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String uri;
	private String label; 
	private String image; 
	private String url; 
	private List<String> dietLabels;
	private Double calories;
	
	
	
	
	public RecipeEntity() {
		super();
		
	}
	
	
	
	public RecipeEntity(Long id, String uri, String label, String image, String url, List<String> dietLabels,
			Double calories) {
		super();
		this.id = id;
		this.uri = uri;
		this.label = label;
		this.image = image;
		this.url = url;
		this.dietLabels = dietLabels;
		this.calories = calories;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		return "RecipeEntity [id=" + id + ", uri=" + uri + ", label=" + label + ", image=" + image + ", url=" + url
				+ ", dietLabels=" + dietLabels + ", calories=" + calories + "]";
	}
	
	
}
