package ma.wiebatouta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.User;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {
	
	@Query("SELECT p FROM Personne p where p.user.username=:username")
	public Personne getPersonneFromUsername(@Param("username") String username);
	
	@Query("SELECT p FROM Personne p where p.user=:user")
	public List<Personne> findByUser(@Param("user")User user);
}
