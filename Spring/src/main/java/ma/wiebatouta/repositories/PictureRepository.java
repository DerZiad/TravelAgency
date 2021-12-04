package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.wiebatouta.models.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long> {

}
