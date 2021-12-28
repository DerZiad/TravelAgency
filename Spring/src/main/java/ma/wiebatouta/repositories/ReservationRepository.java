package ma.wiebatouta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Reservation;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	public List<Reservation> findByPerson(Personne person);
	
	@Query("SELECT r FROM Reservation r where r.person.user.username=:username")
	public List<Reservation> getReservationAvecUsername(@Param("username")String username);
}
