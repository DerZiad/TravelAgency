package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Theme;
@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

}
