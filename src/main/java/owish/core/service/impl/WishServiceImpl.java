package owish.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import owish.core.dao.wish.WishDao;
import owish.core.repository.WishesRepository;
import owish.core.service.wish.WishService;
import owish.model.wish.Wish;
import owish.model.wish.Wishes;
import owish.rest.security.JwtUser;

@Service
public class WishServiceImpl extends AbstractCrudServiceImpl<Wish> implements WishService {

	@Autowired
	WishDao wishDao;

	// elastic search
	@Autowired
	WishesRepository wishesRepository;

	@Override
	// public AbstractDao<Wish> getDao() {
	public WishDao getDao() {
		return wishDao;
	}

	@Override
	public Wish modify(Wish entity) {
		return wishDao.save(entity);
	}

	@Override
	public Wish completeWish(Wish entity) {
		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername(); // get logged in username

		Date date = new Date();
		SimpleDateFormat sdp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		entity.setCompletedDate(sdp.format(date));
		// entity.setCompletedDate(date);
		entity.setCompletedUser(username);
		return wishDao.save(entity);
	}

	@Override
	public Wish uncompleteWish(Wish entity) {
		entity.setCompletedDate(null);
		entity.setCompletedUser(null);
		return wishDao.save(entity);
	}

	@Override
	public Wish addWish(String title) {
		Wish wish = new Wish();
		wish.setTitle(title);

		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername(); // get logged in username
		wish.setCreationUser(username);

		//ELASTIC SEARCH ADD
		Wishes wishes = new Wishes();
		wishes.setTitle(title);
		wishes.setActive("Y");

		addWishElastic(wishes);
		
		return wishDao.save(wish);
	}


	@Override
	public List<Wishes> retrieveWishElastic() {
		Iterable<Wishes> wishesIterable = wishesRepository.findAll();
		List<Wishes> wishes = StreamSupport.stream(wishesIterable.spliterator(), false)
				.collect(Collectors.toList());
		return wishes;
	}

	@Override
	public Wishes addWishElastic(Wishes wish) {
		return wishesRepository.save(wish);
	}

}

