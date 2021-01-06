package pro.bolshakov.geekbrains.springleveltwo.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.bolshakov.geekbrains.springleveltwo.shop.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
