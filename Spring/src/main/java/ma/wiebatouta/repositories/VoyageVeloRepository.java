package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.VoyageVelo;
@Repository
public interface VoyageVeloRepository extends JpaRepository<VoyageVelo, Long> {

}
