package ma.wiebatouta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.wiebatouta.models.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
