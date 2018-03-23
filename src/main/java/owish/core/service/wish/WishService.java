package owish.core.service.wish;

import java.util.List;

import owish.core.service.AbstractCrudService;
import owish.model.wish.Wish;
import owish.model.wish.Wishes;

public interface WishService extends AbstractCrudService<Wish> {

	// public List<Wish> retrieveList();

	public Wish completeWish(Wish entity);

	public Wish uncompleteWish(Wish entity);

	public Wish addWish(String title);

	/**
	 * elastic search retrieve
	 */
	public List<Wishes> retrieveWishElastic();

	/**
	 * elastic search add
	 */
	public Wishes addWishElastic(Wishes wish);

	/*Iterable<Wish> findAll();
	
	Page<Wish> findByTitle(String title, PageRequest pageRequest);*/

}
