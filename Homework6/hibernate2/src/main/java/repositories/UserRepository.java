package repositories;
import org.springframework.stereotype.Repository;
import entities.User;
import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class UserRepository implements IUserRepository {
	 private final EntityManager em;

	    public UserRepository(EntityManager em) {
	        this.em = em;
	    }
	    @Override
	    public List<User> findAll() {
	        em.getTransaction().begin();
	        List<User> list = em.createNamedQuery("User.findAll", User.class).getResultList();
	        em.getTransaction().commit();
	        return list;
	    }

	    @Override
	    public void saveOrUpdate(User user) {
	        em.getTransaction().begin();
	        if (user.getId() == null) {
	            em.persist(user);
	        }
	        em.merge(user);
	        em.getTransaction().commit();
	    }

	    @Override
	    public User findById(Long id) {
	        em.getTransaction().begin();
	        User user = em.find(User.class, id); // CRUD - read
	        em.getTransaction().commit();
	        return user;
	    }

	    @Override
	    public void deleteById(Long id) {
	        em.getTransaction().begin();
	        em.createNamedQuery("User.deleteById")
	                .setParameter("id", id)
	                .executeUpdate();
	        em.getTransaction().commit();
	    } 
}
