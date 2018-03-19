package owish.core.service.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import owish.core.service.AbstractCrudService;

public abstract class AbstractCrudServiceImpl<E> implements AbstractCrudService<E> {
	// public abstract AbstractDao<E> getDao();
	public abstract JpaRepository<E, Long> getDao();

	@Override
	public List<E> retrieveList() {
	//public List<Wish> retrieveList() {

		return this.getDao().findAll();
	}

}
