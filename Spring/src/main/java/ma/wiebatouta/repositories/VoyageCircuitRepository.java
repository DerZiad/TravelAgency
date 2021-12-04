package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.VoyageCircuit;
@Repository
public interface VoyageCircuitRepository extends JpaRepository<VoyageCircuit, Long> {

}
