package projet.lafactory.model;

// Classe pas forc�ment utile
public class Visiteur extends Personne {
	Boolean isAdmin;
	
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Visiteur() {
		this.isAdmin = false;
	}
	
}
