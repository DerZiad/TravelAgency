package ma.wiebatoute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.wiebatouta.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
