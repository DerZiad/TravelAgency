package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.wiebatouta.models.Jadore;
import ma.wiebatouta.models.idcompose.KeyLike;

public interface JadoreRepository extends JpaRepository<Jadore, KeyLike>{

}
