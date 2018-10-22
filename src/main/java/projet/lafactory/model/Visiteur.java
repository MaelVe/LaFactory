package projet.lafactory.model;

// Classe pas forcément utile
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
