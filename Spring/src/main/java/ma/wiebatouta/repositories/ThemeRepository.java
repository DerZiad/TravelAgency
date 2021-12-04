package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.wiebatouta.models.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

}
