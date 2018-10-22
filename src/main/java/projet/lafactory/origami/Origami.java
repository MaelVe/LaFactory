package projet.lafactory.origami;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

//@Entity
//@Table(name="origami")
public class Origami {

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id")
	private int id;
	
//	@Column(name="nom", length=200, nullable=false)
//	@NotEmpty
	private String nom;
	
//	@Column(name="tpsrea", nullable=false)
//	@NotEmpty
	private float tpsDeRea;
	
	
	
//	@Column(name="tpsrea", nullable=false)
//	@NotEmpty
	private int nbFeuille;
	
	
//	@Column(name="tpsrea", nullable=false)
//	@NotEmpty
	private int note;
	
//	@Column(name="tpsrea", nullable=false)
//	@NotEmpty
	private Boolean activate;
	
//	@Column(name="tpsrea", nullable=false)
//	@NotEmpty
	private int nbVue;
	
	private Difficulte difficulte;
	private ArrayList<Categorie> categories;
	private ArrayList<Etape> etapes;
}
