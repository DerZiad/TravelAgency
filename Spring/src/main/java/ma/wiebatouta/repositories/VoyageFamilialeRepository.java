package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.VoyageFamiliale;
@Repository
public interface VoyageFamilialeRepository extends JpaRepository<VoyageFamiliale, Long> {

}
