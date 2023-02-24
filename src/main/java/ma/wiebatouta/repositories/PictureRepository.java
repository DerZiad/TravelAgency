package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Picture;
@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

}
