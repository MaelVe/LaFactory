package projet.lafactory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

//@Entity
//@Table(name="admin")
public class Admin extends Personne{

//		@Id
//		@GeneratedValue(strategy=GenerationType.IDENTITY)
//		@Column(name="id")
		private long id;
	
//		@Column(name="isAdmin", nullable=false)
//		@NotEmpty
		Boolean isAdmin;
		
//		@Column(name="password", length=500, nullable=false)
//		@NotEmpty
		String password;


		public void setPassword(String password) {
			this.password = password;
		}

		public Admin() {
			this.isAdmin = true;
		}
		
		public void creationAdmin() {
			this.setMail("admin@admin.fr");
			this.setPassword("password");
		}
		
		public Boolean getIsAdmin() {
			return isAdmin;
		}
		

		public String getPassword() {
			return password;
		}
}
