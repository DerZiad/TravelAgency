package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.wiebatouta.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
