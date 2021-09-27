package repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import entities.Order;

public interface CartEntryRepository extends JpaRepository<Order, Long> {

}
