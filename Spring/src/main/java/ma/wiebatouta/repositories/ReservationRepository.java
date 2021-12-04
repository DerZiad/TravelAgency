package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.wiebatouta.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
