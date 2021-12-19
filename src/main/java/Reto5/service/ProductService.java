package Reto5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Reto5.model.Product;
import Reto5.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan Barragan
 */

@Service
public class ProductService {

    /**
     * Variable que representa el servicio de Usuario
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * Obtener Lista de todos los productos
     */
    public List<Product>getAll(){
        return productRepository.getAll();
    }

    /**
     * Obtener producto por id
     */
    public Optional<Product>getProduct(String reference) {
        return productRepository.getProduct(reference);
    }

    /**
     * Metodo para guardar producto
     */
    public Product save(Product product){
        if (product.getReference()==null){
            return product;
        }
        return productRepository.save(product);
    }

     /**
     * Metodo para actualizar producto
     */
    public Product update(Product product){
        if (product.getReference()!=null){
            Optional<Product>dbProduct=productRepository.getProduct(product.getReference());
            if (!dbProduct.isEmpty()){
                if (product.getCategory()!=null){
                    dbProduct.get().setCategory(product.getCategory());
                }
                if (product.getDescription()!=null){
                    dbProduct.get().setDescription(product.getDescription());
                }

                dbProduct.get().setAvailability(product.isAvailability());

                if (product.getPrice()!=0.0){
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity()!=0){
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography()!=null){
                    dbProduct.get().setPhotography(product.getPhotography());
                }
                productRepository.update(dbProduct.get());
                return dbProduct.get();
            }else
                return product;
        }else{
            return product;
        }
    }

     /**
     * Metodo para norrar producto mediante su referencia
     */
    public boolean delete(String reference){
        return getProduct(reference).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElse(false);
    }

     /**
     * Metodo para listar productos por precio
     */
    public List<Product>getByPrice(double price){
        return productRepository.getByPrice(price);
    }

     /**
     * Metodo para listar producto por descripcion
     */
    public List<Product>getByDescriptionContainingIgnoreCase(String description){
        return productRepository.getByDescriptionContainingIgnoreCase(description);
    }



}
