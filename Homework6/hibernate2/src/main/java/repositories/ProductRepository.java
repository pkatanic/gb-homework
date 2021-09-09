package repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entities.Product;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
	 private final EntityManager em;
	    public ProductRepository(EntityManager em) {
	        this.em = em;
	    }

	    @Override
	    public List<Product> findAll() {
	        em.getTransaction().begin();
	        List<Product> list = em.createNamedQuery("Product.findAll", Product.class).getResultList();
	        em.getTransaction().commit();
	        return list;
	    }

	    @Override
	    public List<Product> findAllSortedByName() {
	        em.getTransaction().begin();
	        List<Product> list = em.createNamedQuery("Product.findAllSortedByName", Product.class).getResultList();
	        em.getTransaction().commit();
	        return list;
	    }

	    @Override
	    public void saveOrUpdate(Product product) {
	        em.getTransaction().begin();
	        if (product.getId() == null) {
	            em.persist(product);
	        } else {
	            em.merge(product);
	        }
	        em.getTransaction().commit();
	    }

	    @Override
	    public Product findById(Long id) {
	        em.getTransaction().begin();
	        Product product =  em.createNamedQuery("Product.findById", Product.class)
	                .setParameter("id", id)
	                .getSingleResult();
	        em.getTransaction().commit();
	        return product;
	    }

	    @Override
	    public void deleteById(Long id) {
	        em.getTransaction().begin();
	        em.createNamedQuery("Product.deleteById")
	                .setParameter("id", id)
	                .executeUpdate();
	        em.getTransaction().commit();
	    } 
}
