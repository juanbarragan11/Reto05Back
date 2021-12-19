package Reto5.repository.crud;

import org.springframework.data.mongodb.repository.MongoRepository;

import Reto5.model.Order;


import java.util.Date;
import java.util.List;


public interface OrderCrudRepository extends MongoRepository<Order, Integer>{

    /**
     * CRUD de busqueda por zona
     */
    public List<Order> findBySalesManZone(String zone);

    /**
     * CRUD de busqueda por salesman id
     */
    public List<Order>findBySalesManId(Integer id);

    /**
     * CRUD de busqueda por salesman id y su estatus
     */
    public List<Order>findBySalesManIdAndStatus(Integer id, String status);

    /**
     * CRUD de busqueda por fecha y salesman id
     */
    public List<Order>findByRegisterDayAndSalesManId(Date registerDay,Integer id);

}



