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
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private Long id;
	private boolean isFavorite;
	@Id
	private String uri;
	
	
	public RecipeEntity() {
		super();
		
	}
	
	
	
	public RecipeEntity(Long id, String uri, String label, String image, String url, List<String> dietLabels,
			Double calories) {
		super();
	}



	public boolean isFavorite() {
		return isFavorite;
	}



	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}



	public String getUri() {
		return uri;
	}



	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
