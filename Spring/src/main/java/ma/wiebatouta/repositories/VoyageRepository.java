package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.wiebatouta.models.Voyage;

public interface VoyageRepository extends JpaRepository<Voyage, Long> {

}
