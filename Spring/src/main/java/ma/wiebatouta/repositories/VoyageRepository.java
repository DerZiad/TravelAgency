package ma.wiebatouta.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Voyage;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Long> {
	@Query("select v from Voyage v where v.destination=:destination and "
			+ "v.dateDepart >= :dateDepart and v.dateArrivee <= :dateArrivee and v.prix <= :prix and v.nbrPersonnes > :nombrePersonne ")
	public List<Voyage> getVoyageSearch(@Param("destination") String destination, @Param("dateDepart") Date date_depart,
			@Param("dateArrivee") Date date_arrivee, @Param("prix") Double prix,
			@Param("nombrePersonne") int nbrPersone);//TODO a modifiier date et prix 


  
}
