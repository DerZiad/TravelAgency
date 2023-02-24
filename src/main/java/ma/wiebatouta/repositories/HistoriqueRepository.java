package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Historique;

@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Long>{

}
