package owish.core.service.user;

import owish.model.user.User;

public interface UserService {

	String retrieveAll();

	User retrieveByUsername(String username);

}
