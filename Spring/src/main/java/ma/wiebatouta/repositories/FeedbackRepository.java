package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Feedback;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
