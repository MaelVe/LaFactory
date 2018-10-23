package projet.lafactory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="admin")
public class Admin{

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private long id;
		
		@Column(name="password", length=200, nullable=false)
		@NotEmpty
		String password;

		@Column(name="pseudo", length=200, nullable=false)
		@NotEmpty
		private String pseudo;

		@Column(name="mail", length=200, nullable=false)
		@NotEmpty
		private String mail;
		
		public Admin() {
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getPseudo() {
			return pseudo;
		}

		public void setPseudo(String pseudo) {
			this.pseudo = pseudo;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void creationAdmin() {
			this.setMail("admin@admin.fr");
			this.setPassword("password");
		}
		
		public String getPassword() {
			return password;
		}
}
