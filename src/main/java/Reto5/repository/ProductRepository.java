package Reto5.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto5.model.Product;
import Reto5.repository.crud.ProductCrudRepository;

import java.util.List;
import java.util.Optional;

/*
 * @author Juan Barragan
 */
@Repository
public class ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    /*
    *Acceso a la consulta de los productos en general
    */
    public List<Product> getAll(){
        return productCrudRepository.findAll();
    }

    /*
    *Acceso consulta de los productos por referencia
    */
    public Optional<Product> getProduct(String reference){
        return productCrudRepository.findById(reference);
    }

    /*
    *Acceso a guardar los nuevos producrtos
    */
    public Product save(Product product){
        return productCrudRepository.save(product);
    }

    /*
    *Acceso a actualizar los productos
    */
    public void update(Product product){
        productCrudRepository.save(product);
    }

    /*
    *Acceso a eliminar los productos por referencia
    */
    public void delete(Product product){
        productCrudRepository.delete(product);
    }

    /*
    *Acceso a consultar los productos por precio
    */
    public List<Product>getByPrice(double price){
       return productCrudRepository.findByPrice(price);
    }

    /*
    *Acceso a consultar los productos por descripcion
    */
    public List<Product>getByDescriptionContainingIgnoreCase(String description){
        return productCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }
}



