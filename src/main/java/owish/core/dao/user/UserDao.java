package owish.core.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import owish.model.user.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	User findByUsername(String username);

}
