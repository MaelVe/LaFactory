package projet.lafactory.origami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="origami_categorie")
public class Origami_categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	public int origami_id;	
	public int categories_id;
	public int id_categorie;
	public int id_origami;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrigami_id() {
		return origami_id;
	}
	public void setOrigami_id(int origami_id) {
		this.origami_id = origami_id;
	}
	public int getCategories_id() {
		return categories_id;
	}
	public void setCategories_id(int categories_id) {
		this.categories_id = categories_id;
	}
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	public int getId_origami() {
		return id_origami;
	}
	public void setId_origami(int id_origami) {
		this.id_origami = id_origami;
	}
}
