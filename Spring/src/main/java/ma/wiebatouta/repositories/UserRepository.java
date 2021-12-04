package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.wiebatouta.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
