package Model;

import java.util.List;

public class RecipeReponse {


	private String q;
	private List<Diet> hits;
	
	
	
	public RecipeReponse() {
		super();
	}
	public RecipeReponse(String q, List<Diet> hits) {
		super();
		this.q = q;
		this.hits = hits;
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
