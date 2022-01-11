package ma.wiebatouta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.wiebatouta.models.Jadore;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.idcompose.KeyLike;

public interface JadoreRepository extends JpaRepository<Jadore, KeyLike> {
	@Query("SELECT j FROM Jadore j where j.person=:person")
	public List<Jadore> findByPerson(@Param("person") Personne person);
}
