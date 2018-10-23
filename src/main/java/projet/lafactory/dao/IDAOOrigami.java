package projet.lafactory.dao;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.lafactory.origami.Origami;

// aide pour la requete: http://www.astorm.ch/blog/index.php?post/2010/02/23/JPA-incompl%C3%A8te
public interface IDAOOrigami extends JpaRepository<Origami, Integer> {
	@Query("select og from Origami og LEFT JOIN origami_categorie ogCat ON (ogCat.origami_id = og.id) LEFT JOIN Categorie cat on (cat.id = :id)")
	public Iterable<Origami> findByCategorieId(@Param("id") int id);
}