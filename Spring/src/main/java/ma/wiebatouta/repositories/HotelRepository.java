package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Hotel;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
