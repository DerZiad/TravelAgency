package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.wiebatouta.models.Lieu;

public interface LieuRepository extends JpaRepository<Lieu, Long> {

}
