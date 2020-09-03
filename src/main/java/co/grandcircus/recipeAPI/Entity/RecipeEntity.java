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
	
	
	public RecipeEntity() {
		super();
		
	}
	
	
	
	public RecipeEntity(Long id, String uri, String label, String image, String url, List<String> dietLabels,
			Double calories) {
		super();
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "RecipeEntity [id=" + id + "]";
	}
	
	
}
