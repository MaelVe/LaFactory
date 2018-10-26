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
@Table(name="origami")
public class Origami {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="nom", length=200, nullable=false)
	@NotEmpty
	public String nom;
	
	@Column(name="tpsDeRea", nullable=false)
	public int tpsDeRea;	
	
	@Column(name="nbFeuille", nullable=false)
	public int nbFeuille;
	
	
	@Column(name="note", nullable=false)
	public int note;
	
	@Column(name="activate", nullable=false)
	public Boolean activate;
	
	@Column(name="nbVue", nullable=false)
	public int nbVue;
	
	@Column(name="difficulte", length=200, nullable=false)
	@NotEmpty
	public String difficulte;
	

	@ManyToMany(mappedBy="origamis", cascade = CascadeType.ALL)
	public List<Categorie> categories;
	
	@ManyToMany(mappedBy="origamis",cascade = CascadeType.ALL)
	public List<Etape> etapes;
	
	public String liaisonCatOrg;
	

	public String getLiaisonCatOrg() {
		return liaisonCatOrg;
	}

	public void setLiaisonCatOrg(String liaisonCatOrg) {
		this.liaisonCatOrg = liaisonCatOrg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getTpsDeRea() {
		return tpsDeRea;
	}

	public void setTpsDeRea(int tpsDeRea) {
		this.tpsDeRea = tpsDeRea;
	}

	public int getNbFeuille() {
		return nbFeuille;
	}

	public void setNbFeuille(int nbFeuille) {
		this.nbFeuille = nbFeuille;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Boolean getActivate() {
		return activate;
	}

	public void setActivate(Boolean activate) {
		this.activate = activate;
	}

	public int getNbVue() {
		return nbVue;
	}

	public void setNbVue(int nbVue) {
		this.nbVue = nbVue;
	}

	public String getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(String difficulte) {
		this.difficulte = difficulte;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public List<Etape> getEtapes() {
		return etapes;
	}

	public void setEtapes(List<Etape> etapes) {
		this.etapes = etapes;
	}
}
