package projet.lafactory.dao;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.lafactory.origami.Origami;

public interface IDAOOrigami extends JpaRepository<Origami, Integer> {
	@Query("Select e from Origami e "
			+ "join e.categories c where c.id = :id and e.activate = true")
	public Iterable<Origami> findByCategorieId(@Param("id") long id);
}