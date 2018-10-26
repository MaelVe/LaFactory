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
	
	@Column(name="content", length=200, nullable=false)
	@NotEmpty
	public String content;
	
	@Column(name="numEtape", nullable=false)
	public int numEtape;
	
	public int origami_etapes_id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNumEtape() {
		return numEtape;
	}

	public void setNumEtape(int numEtape) {
		this.numEtape = numEtape;
	}

	public int getOrigami_etapes_id() {
		return origami_etapes_id;
	}

	public void setOrigami_etapes_id(int origami_etapes_id) {
		this.origami_etapes_id = origami_etapes_id;
	}
}
