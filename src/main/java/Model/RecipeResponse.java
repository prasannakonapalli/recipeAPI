package Model;

import java.util.List;

public class RecipeResponse {


	private String q;
	private List<Diet> hits;
	
	
	
	public RecipeResponse() {
		super();
	}
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
