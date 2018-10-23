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
@Table(name="categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public long id;

	@Column(name="nomCategorie", length=200, nullable=false)
	@NotEmpty
	public String nomCategorie;
	
	@ManyToMany
	@JoinColumn(name="origami_sousCategorie_id")
	public List<Categorie> sousCategorie;
	
}
