package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.ProductInOrder;

public interface ProductInOrderRepository  extends JpaRepository<ProductInOrder, Long>{

}
