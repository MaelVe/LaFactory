package projet.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.lafactory.model.Admin;
import projet.lafactory.origami.Categorie;
import projet.lafactory.origami.Commentaire;

public interface IDAOCategorie extends JpaRepository<Categorie, Integer> {
	//@Query("Select * from categorie where ")
	//public void findSubCategories();
}