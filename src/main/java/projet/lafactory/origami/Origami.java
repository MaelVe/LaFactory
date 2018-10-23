package projet.lafactory.origami;

import java.util.ArrayList;
import java.util.List;

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
	
	@Column(name="tpsrea", nullable=false)
	@NotEmpty
	private float tpsDeRea;	
	
	@Column(name="nbFeuille", nullable=false)
	@NotEmpty
	private int nbFeuille;
	
	
	@Column(name="note", nullable=false)
	@NotEmpty
	private int note;
	
	@Column(name="activate", nullable=false)
	@NotEmpty
	private Boolean activate;
	
	@Column(name="nbVue", nullable=false)
	@NotEmpty
	private int nbVue;
	
	@Column(name="difficulte", nullable=false)
	@NotEmpty
	private Difficulte difficulte;
	
	@ManyToMany
	@JoinColumn(name="origami_categorie_id")
	private List<Categorie> categories;
	
	@OneToMany
	@JoinColumn(name="origami_etapes_id")
	private List<Etape> etapes;
}
