package owish.core.service.wish;

import owish.core.service.AbstractCrudService;
import owish.model.wish.Wish;

public interface WishService extends AbstractCrudService<Wish> {

	// public List<Wish> retrieveList();

	public Wish completeWish(Wish entity);

	public Wish uncompleteWish(Wish entity);

	public Wish addWish(String title);

	/*Iterable<Wish> findAll();
	
	Page<Wish> findByTitle(String title, PageRequest pageRequest);*/

}
