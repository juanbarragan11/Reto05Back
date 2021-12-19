package Reto5.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import Reto5.model.Product;
import Reto5.service.ProductService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan Barragan
 */
@RestController
@RequestMapping("/api/chocolate")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductController {
    @Autowired
    private ProductService productService;

    /*
    *URL consulta de productos
    */
    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    /*
    *URL consulta de productos por referencia
    */
    @GetMapping("/{reference}")
    public Optional<Product> getProduct(@PathVariable("reference") String reference) {
        return productService.getProduct(reference);
    }

    /*
    *URL creacion de producto
    */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product save (@RequestBody Product product){
        return productService.save(product);
    }

    /*
    *URL actualizar producto
    */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    /*
    *URL eliminar producto por referencia
    */
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return productService.delete(reference);
    }

    /*
    *URL consulta de productos por precio
    */
    @GetMapping("/price/{price}")
    public List<Product>getByPrice(@PathVariable("price")double price){
        return productService.getByPrice(price);
    }

    /*
    *URL consulta de productos por descripcion
    */
    @GetMapping("/description/{description}")
    public List<Product>getByByDescriptionContainingIgnoreCase(@PathVariable("description") String description){
        return productService.getByDescriptionContainingIgnoreCase(description);
    }

}

