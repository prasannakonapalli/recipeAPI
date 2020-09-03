package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Favorite {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private boolean isFavorite;
private String uri;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
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
