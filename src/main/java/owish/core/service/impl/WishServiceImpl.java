package owish.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import owish.core.dao.wish.WishDao;
import owish.core.service.wish.WishService;
import owish.model.wish.Wish;
import owish.rest.security.JwtUser;

@Service
public class WishServiceImpl extends AbstractCrudServiceImpl<Wish> implements WishService {

	@Autowired
	WishDao wishDao;

	/*@Autowired
	WishRepository wishRepository;*/

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

		// return wishDao.findOne(Integer.toUnsignedLong(newWish.getId()));
		return wishDao.save(wish);
	}

}

