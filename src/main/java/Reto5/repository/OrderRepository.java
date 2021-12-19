package Reto5.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import Reto5.model.Order;
import Reto5.repository.crud.OrderCrudRepository;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/*
 * @author Juan Barragan
 */
@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

     /*
    *Acceso a la consulta de ordenes en general
    */
    public List<Order> getAll() {
        return orderCrudRepository.findAll();
    }

    /*
    *Acceso consulta de ordenes por id
    */
    public Optional<Order> getOrder(Integer id){
        return orderCrudRepository.findById(id);
    }

    /*
    *Acceso a guardar las nuevas ordenes
    */
    public Order save(Order order) {
        return orderCrudRepository.save(order);
    }

    /*
    *Acceso a actualizar las ordenes
    */
    public void update(Order order){
        orderCrudRepository.save(order);
    }

    /*
    *Acceso a eliminar las ordenes
    */
    public void delete (Order order){
        orderCrudRepository.delete(order);
    }

    /*
    *Acceso a consultar las ordenes por zona
    */
    public List<Order> getOrderByZone(String zone){
        return orderCrudRepository.findBySalesManZone(zone);
    }

    /*
    *Acceso a consultar las ordenes por salesman id
    */
    public List<Order>getBySalesManId(Integer id){
        return orderCrudRepository.findBySalesManId(id);
    }

    /*
    *Acceso a consultar las salesmanid y su estatus
    */
    public List<Order>getBySalesManIdAndStatus(Integer id, String status){
        return orderCrudRepository.findBySalesManIdAndStatus(id, status);
    }
       
    @Autowired
    private MongoTemplate mongoTemplate;

    /*
    *Acceso a consultar las ordenes por fecha y salesman id
    */
    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(registerDay, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(registerDay, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);

        return mongoTemplate.find(query,Order.class);
    }

}
