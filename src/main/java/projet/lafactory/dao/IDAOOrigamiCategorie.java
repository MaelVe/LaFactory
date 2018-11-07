package projet.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import projet.lafactory.model.Admin;
import projet.lafactory.origami.Etape;
import projet.lafactory.origami.Origami_categorie;

public interface IDAOOrigamiCategorie extends JpaRepository<Origami_categorie, Integer> {	

	@Query("select a from Origami_categorie a where a.id_origami = :id ")
	public Origami_categorie findIdCategorieByIdOrigami(@Param("id") int id);	
	
	@Transactional
	@Modifying
	@Query("delete from Origami_categorie e where e.id_origami = :id")
	public void deleteAllByOrigamiId(@Param("id") int id);
}