package projet.lafactory.origami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="etape")
public class Etape {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="content", length=500, nullable=false)
	@NotEmpty
	public String content;
	
	@Column(name="numEtape", nullable=false)
	@NotEmpty
	public int numEtape;
	
	public int origami_etapes_id;
}
