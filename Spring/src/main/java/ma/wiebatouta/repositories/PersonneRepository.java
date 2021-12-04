package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.wiebatouta.models.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

}
