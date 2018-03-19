package owish.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import owish.core.service.user.UserService;
import owish.core.service.wish.WishService;
import owish.model.wish.Wish;

@RestController
@RequestMapping(path = "/authentication")
public class AuthenticationController {

	@Autowired
	UserService userService;

	@Autowired
	WishService wishService;

	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	// @PreAuthorize("hasAuthority('ADMIN_USER') or
	// hasAuthority('STANDARD_USER')")
	public List<Wish> getUser() {
		return wishService.retrieveList();
	}

	@RequestMapping(value ="/users", method = RequestMethod.GET)
	// @PreAuthorize("hasAuthority('ADMIN_USER')")
    public String getUsers(){
		return userService.retrieveAll();
    }

}
