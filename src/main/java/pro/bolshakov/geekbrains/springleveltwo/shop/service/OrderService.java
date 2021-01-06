package pro.bolshakov.geekbrains.springleveltwo.shop.service;

import pro.bolshakov.geekbrains.springleveltwo.shop.domain.Order;

public interface OrderService {
    void saveOrder(Order order);
    Order getOrder(Long id);
}
