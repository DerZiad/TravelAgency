package ma.wiebatouta.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByUsername(String username);
	
	
}	
