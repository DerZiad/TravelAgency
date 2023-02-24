package ma.wiebatouta.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Activite;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long> {
	List<Activite> findByNomActivite(String nomActivite);


}
