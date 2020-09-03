package co.grandcircus.recipeAPI.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.recipeAPI.Entity.RecipeEntity;



public interface RecipeDao extends JpaRepository<RecipeEntity, Long>{
	
	

	

}
