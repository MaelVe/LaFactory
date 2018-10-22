package projet.lafactory.origami;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

//@Entity
//@Table(name="categorie")
public class Categorie {

//	@Column(name="nomCategorie", length=200, nullable=false)
//	@NotEmpty
	private String nomCategorie;
	
	private ArrayList<Categorie> sousCategorie;
	
}
