package Reto5.repository.crud;

import org.springframework.data.mongodb.repository.MongoRepository;
import Reto5.model.Product;

import java.util.List;

public interface ProductCrudRepository extends MongoRepository<Product, String> {

    /**
     * CRUD de busqueda producto por precio
     */
    public List<Product>findByPrice(double price);

    /**
     * CRUD de busqueda por descripcion
     */
    public List<Product>findByDescriptionContainingIgnoreCase(String description);
}



