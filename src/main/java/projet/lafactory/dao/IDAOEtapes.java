package projet.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import projet.lafactory.origami.Etape;

public interface IDAOEtapes extends JpaRepository<Etape, Integer> {
	
	@Query("Select e from Etape e where e.origami_etapes_id = :id order by e.numEtape ASC")
	public Iterable<Etape> findByOrigamiId(@Param("id") int id);
	
	@Transactional
	@Modifying
	@Query("delete from Etape e where e.origami_etapes_id = :id")
	public void deleteAllByOrigamiId(@Param("id") int id);

}