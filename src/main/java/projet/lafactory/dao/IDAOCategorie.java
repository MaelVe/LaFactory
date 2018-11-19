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
	
	@Query("Select a from Categorie a where a.id = :id")
	public Categorie findByLongId(@Param("id") long id);
	
	@Query("Delete a from Categorie a where a.id = :id")
	public void deleteByLongId(@Param("id") long id);
}
