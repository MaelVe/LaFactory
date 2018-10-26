package projet.lafactory.origami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="boiteaidee")
public class BoiteAidee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public long id;

	@Column(name="idee", length=200, nullable=false)
	@NotEmpty
	public String idee;

	@Column(name="mail", length=200, nullable=false)
	@NotEmpty
	public String mail;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdee() {
		return idee;
	}

	public void setIdee(String idee) {
		this.idee = idee;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
