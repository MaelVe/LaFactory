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
	
	@Column(name="tpsrea", nullable=false)
	@NotEmpty
	public float tpsDeRea;	
	
	@Column(name="nbFeuille", nullable=false)
	@NotEmpty
	public int nbFeuille;
	
	
	@Column(name="note", nullable=false)
	@NotEmpty
	public int note;
	
	@Column(name="activate", nullable=false)
	@NotEmpty
	public Boolean activate;
	
	@Column(name="nbVue", nullable=false)
	@NotEmpty
	public int nbVue;
	
	@Column(name="difficulte", nullable=false)
	@NotEmpty
	public Difficulte difficulte;
	
	@ManyToMany(mappedBy="origamis", cascade = CascadeType.ALL)
	//@JoinColumn(name="origami_categorie_id")
	public List<Categorie> categories;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="origami_etapes_id")
	public List<Etape> etapes;
}
