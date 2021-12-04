package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.VoyagePied;
@Repository
public interface VoyagePiedRepository extends JpaRepository<VoyagePied, Long> {

}
