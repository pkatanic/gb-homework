package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.ShoppingCart;

public interface CartRepository extends JpaRepository<ShoppingCart, Integer>  {

}
