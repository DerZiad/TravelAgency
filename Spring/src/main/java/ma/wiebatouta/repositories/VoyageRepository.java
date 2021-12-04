package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Voyage;
@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Long> {

}
