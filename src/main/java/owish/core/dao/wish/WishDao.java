package owish.core.dao.wish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import owish.model.wish.Wish;

@Repository
// public interface WishDao extends AbstractDao<Wish> {
public interface WishDao extends JpaRepository<Wish, Long> {



}