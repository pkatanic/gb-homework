package repositories;
import java.util.List;

import entities.User;
public interface IUserRepository {
	 List<User> findAll();

	    User findById(Long id);

	    void deleteById(Long id);

	    void saveOrUpdate(User user);
	 
}
