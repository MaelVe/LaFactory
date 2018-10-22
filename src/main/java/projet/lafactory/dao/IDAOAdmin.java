package projet.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.lafactory.model.Admin;

public interface IDAOAdmin extends JpaRepository<Admin, Integer> {
	@Query("select a from Administrateur a where a.username = :username and a.password = :password")
	public Admin auth(@Param("username") String username, @Param("password") String password);
}
