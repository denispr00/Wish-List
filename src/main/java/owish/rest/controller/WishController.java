package owish.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import owish.core.service.wish.WishService;
import owish.model.wish.Wish;
import owish.model.wish.Wishes;

@RestController
@RequestMapping("/wish")
public class WishController {

	@Autowired
	WishService wishService;

	@Autowired
	SimpMessagingTemplate template;

	/*@RequestMapping(method = RequestMethod.GET)
	public List<Wish> retrieveList() {
		return wishService.retrieveList();
	}*/

	@RequestMapping(path = "retrieve", method = RequestMethod.GET)
	public List<Wishes> retrieveListElastic() {
		return wishService.retrieveWishElastic();
	}

	@RequestMapping(path = "completewish", method = RequestMethod.PUT)
	public Wish completeWish(@RequestBody Wish entity) {
		return wishService.completeWish(entity);
	}

	@RequestMapping(path = "uncompletewish", method = RequestMethod.PUT)
	public Wish uncompleteWish(@RequestBody Wish entity) {
		Wish wish = wishService.uncompleteWish(entity);
		this.template.convertAndSend("/wish", wish.getTitle());
		return wish;
	}

	@RequestMapping(path = "addwish", method = RequestMethod.PUT)
	public Wish add(@RequestBody String title) {
		Wish wish = wishService.addWish(title);
		this.template.convertAndSend("/wish", wish.getTitle());
		return wish;
	}

}
