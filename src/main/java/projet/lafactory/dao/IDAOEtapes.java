package projet.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.lafactory.origami.Etape;

public interface IDAOEtapes extends JpaRepository<Etape, Integer> {
	
	@Query("Select e from Etape e where e.origami_etapes_id = :id")
	public Iterable<Etape> findByOrigamiId(@Param("id") int id);

}