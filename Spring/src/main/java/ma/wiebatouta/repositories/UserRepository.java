package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
