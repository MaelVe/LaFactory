package projet.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.lafactory.origami.Commentaire;

public interface IDAOCommentaire extends JpaRepository<Commentaire, Integer> {

}
