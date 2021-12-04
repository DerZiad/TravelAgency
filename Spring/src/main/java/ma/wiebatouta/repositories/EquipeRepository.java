package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Equipe;
@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}
