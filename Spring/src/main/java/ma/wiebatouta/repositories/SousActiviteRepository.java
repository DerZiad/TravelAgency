package ma.wiebatouta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Activite;
import ma.wiebatouta.models.SousActivite;
@Repository
public interface SousActiviteRepository extends JpaRepository<SousActivite, Long> {
	@Query("select s from SousActivite s , Activite a where s.activite=:activite")
	List<SousActivite> getSousActiviteByActivite(@Param("activite")Activite activite);
}
