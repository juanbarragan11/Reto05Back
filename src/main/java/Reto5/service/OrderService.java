package Reto5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Reto5.model.Order;
import Reto5.repository.OrderRepository;


import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan Barragan
 */
@Service
public class OrderService {

    /**
     * Variable que representa el servicio de las Ordenes
     */
    @Autowired
    private OrderRepository orderRepository;

    /**
     * Metodo para obtener ordenes por lista
     */
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    /**
     * Metodo para obtener ordenes por id
     */
    public Optional<Order> getOrder(Integer id){
        return orderRepository.getOrder(id);
    }

    /**
     * Metodo para guardar una orden
     */
    public Order save(Order order){
        if (order.getId() == null){
            return order;
        } else {
            return orderRepository.save(order);
        }
    }

    /**
     * Metodo para actualizar orden
     */
    public Order update(Order order){
        if (order.getId() != null){
            Optional<Order> dbOrder = orderRepository.getOrder(order.getId());
            if (!dbOrder.isEmpty()) {

                if (order.getId() != null) {
                    dbOrder.get().setId(order.getId());
                }

                if (order.getRegisterDay() != null) {
                    dbOrder.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getStatus() != null) {
                    dbOrder.get().setStatus(order.getStatus());
                }

                if (order.getSalesMan() != null) {
                    dbOrder.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    dbOrder.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    dbOrder.get().setQuantities(order.getQuantities());
                }
                orderRepository.update(dbOrder.get());
                return dbOrder.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    /**
     * Metodo para eliminar ordenes por id
     */
    public boolean delete(Integer id){
        return getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
    }

    /**
     * Metodo para obtener ordenes por zona
     */
    public List<Order> getOrderByZone(String zone){
        return orderRepository.getOrderByZone(zone);
    }

    /**
     * Metodo para obtener ordenes por salesman
     */
    public List<Order>getBySalesManId(Integer id){
        return orderRepository.getBySalesManId(id);
    }

    /**
     * Metodo para obtener ordenes por salesman y status de orden
     */
    public List<Order>getBySalesManIdAndStatus(Integer id, String status){
        return orderRepository.getBySalesManIdAndStatus(id, status);
    }

    /**
     * Metodo para obtener ordenes por registro y el id del salesman
     */
    public List<Order>getByRegisterAndSalesManId(String registerDay, Integer id){
        return orderRepository.getByRegisterDayAndSalesManId(registerDay, id);
    }



}

