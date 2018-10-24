package projet.lafactory.dao;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.lafactory.origami.Origami;

// aide pour la requete: http://www.astorm.ch/blog/index.php?post/2010/02/23/JPA-incompl%C3%A8te
public interface IDAOOrigami extends JpaRepository<Origami, Integer> {
	@Query("Select e from Origami e "
			+ "join e.categories c where c.id = :id")
	public Iterable<Origami> findByCategorieId(@Param("id") long id);
}


// select og from Origami og JOIN origami_categorie ogCat ON ogCat.origami_id = og.id LEFT JOIN Categorie cat on (cat.id = :id)
// select og, (select ogCat, (select cat from Categorie cat where cat.id = :id)  from origami_categorie where ogCat.origami_id = og.id) from Origami og
// select og from Origami og JOIN origami_categorie ogCat where ogCat.origami_id = og.id JOIN Categorie cat on cat.id = :id
// select og from Origami og inner join ogCat from origami_categorie ogCat  where ogCat.origami_id = :id
// Select e from Origami e inner join origami_categorie c where c.origami_id = :id