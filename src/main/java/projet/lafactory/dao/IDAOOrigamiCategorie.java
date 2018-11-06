package projet.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.lafactory.model.Admin;
import projet.lafactory.origami.Etape;
import projet.lafactory.origami.Origami_categorie;

public interface IDAOOrigamiCategorie extends JpaRepository<Origami_categorie, Integer> {	

	@Query("select a from Origami_categorie a where a.id_origami = :id ")
	public Origami_categorie findIdCategorieByIdOrigami(@Param("id") int id);
}