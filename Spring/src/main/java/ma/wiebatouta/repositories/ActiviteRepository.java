package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.wiebatouta.models.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Long> {
	
}
