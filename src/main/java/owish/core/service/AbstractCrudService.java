package owish.core.service;

import java.util.List;

public interface AbstractCrudService<E> {

	public List<E> retrieveList();
	// public List<Wish> retrieveList();

	public E modify(E entity);

}
