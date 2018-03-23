package owish.core.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import owish.model.wish.Wishes;

@Repository
public interface WishesRepository extends ElasticsearchRepository<Wishes, String> {

	// Page<Wish> findByTitle(String title, Pageable pageable);

	List<Wishes> findByTitle(String title);
}