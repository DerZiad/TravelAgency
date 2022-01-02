package ma.wiebatouta.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import ma.wiebatouta.models.Voyage;

public interface VoyageHomeRepository extends PagingAndSortingRepository<Voyage, Long> {

}
