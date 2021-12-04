package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.SousActivite;
@Repository
public interface SousActiviteRepository extends JpaRepository<SousActivite, Long> {

}
