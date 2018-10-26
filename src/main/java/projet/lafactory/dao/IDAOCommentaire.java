package projet.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.lafactory.origami.Commentaire;
import projet.lafactory.origami.Etape;

public interface IDAOCommentaire extends JpaRepository<Commentaire, Integer> {

	@Query("Select e from Commentaire e where e.idOrigami = :id")
	public Iterable<Commentaire> findByOrigamiId(@Param("id") int id);
}
