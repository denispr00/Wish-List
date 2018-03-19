package owish.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import owish.core.service.wish.WishService;
import owish.model.wish.Wish;

@RestController
public class WebSocketController {

	@Autowired
	SimpMessagingTemplate template;

	@Autowired
	WishService wishService;

	@MessageMapping("/send/message")
	public void onReceivedMessage(String message) {
		this.template.convertAndSend("/wish", message);
	}
	
	@RequestMapping(path="/socket/init", method=RequestMethod.GET)
	public void init() {
		List<Wish> wishList = wishService.retrieveList();
		for (Wish wish : wishList) {
			if (wish.getCompletedDate() == null) {
				this.template.convertAndSend("/wish", wish.getTitle());
			}
		}
	}
}
