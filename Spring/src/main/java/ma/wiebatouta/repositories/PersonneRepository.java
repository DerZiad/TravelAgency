package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Personne;
@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

}
