package projet.lafactory.origami;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public long id;

	@Column(name="nomCategorie", length=200, nullable=false)
	@NotEmpty
	public String nomCategorie;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="origami_sousCategorie_id")
	public List<Categorie> sousCategorie;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "Origami_Categorie",
			joinColumns = @JoinColumn(name = "id_categorie"),
			inverseJoinColumns = @JoinColumn(name = "id_origami")
			)
	public List<Origami> origamis;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public List<Categorie> getSousCategorie() {
		return sousCategorie;
	}

	public void setSousCategorie(List<Categorie> sousCategorie) {
		this.sousCategorie = sousCategorie;
	}

	public List<Origami> getOrigamis() {
		return origamis;
	}

	public void setOrigamis(List<Origami> origamis) {
		this.origamis = origamis;
	}
	
}
