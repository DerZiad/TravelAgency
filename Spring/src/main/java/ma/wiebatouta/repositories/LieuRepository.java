package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Lieu;
@Repository
public interface LieuRepository extends JpaRepository<Lieu, Long> {

}
