package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>{


}
