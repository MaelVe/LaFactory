package projet.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.lafactory.origami.Origami;

public interface IDAOOrigami extends JpaRepository<Origami, Integer> {

}