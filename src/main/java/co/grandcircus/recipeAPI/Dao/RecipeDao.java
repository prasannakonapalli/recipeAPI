package co.grandcircus.recipeAPI.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Model.Recipe;
import co.grandcircus.recipeAPI.Entity.RecipeEntity;



public interface RecipeDao extends JpaRepository<RecipeEntity, String>{
	
	@Query("SELECT Distinct uri FROM RecipeEntity WHERE  isFavorite=true")
	List<String> findByIsFavorite();
	

	

}
