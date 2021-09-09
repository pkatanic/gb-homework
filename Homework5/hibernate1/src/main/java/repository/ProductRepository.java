package repository;

import java.util.List;

import javax.persistence.EntityManager;

import model.Product;

public class ProductRepository implements IProductRepository {

	private final EntityManager em;
	public ProductRepository(EntityManager em) {
		this.em=em;
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
	public Product findById(Long id) {
		 em.getTransaction().begin();  
       Product product = em.find(Product.class, id); // CRUD - read
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

	@Override
	public void saveOrUpdate(Product product) {
		  em.getTransaction().begin();
	        if (product.getId() == null) {
	            em.persist(product);
	        }
	        em.merge(product);
	        em.getTransaction().commit();
		
	}

}
