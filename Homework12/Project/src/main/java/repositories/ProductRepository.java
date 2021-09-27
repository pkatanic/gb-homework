package repositories;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findProductsByPriceBetweenAndTitleLike(BigDecimal minPrice, BigDecimal maxPrice, String partTitle, Pageable varPageSort);
}
