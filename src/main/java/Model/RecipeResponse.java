package Model;

import java.util.List;

public class RecipeResponse {


	private String q;
	private List<Diet> hits;
	
<<<<<<< HEAD:src/main/java/Model/RecipeResponse.java
	
	
	public RecipeResponse() {
		super();
	}
=======
	public RecipeResponse() {
		super();
	}
	public RecipeResponse(String q, List<Diet> hits) {
		super();
		this.q = q;
		this.hits = hits;
	}
>>>>>>> 731269096917551cb0cac4fcf4d3b340388daac0:src/main/java/Model/RecipeReponse.java
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public List<Diet> getHits() {
		return hits;
	}
	public void setHits(List<Diet> hits) {
		this.hits = hits;
	}
	@Override
	public String toString() {
		return "RecipeReponse [q=" + q + ", hits=" + hits + "]";
	}
	
	
}
