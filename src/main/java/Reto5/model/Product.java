package Reto5.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/*
 *
 * @author Juan Barragan
 */
@Data
@NoArgsConstructor
@Document(collection = "chocolate")
public class Product {
    
    @Id
    /*
     *Atributos Modelo Producto
     */
    private String reference;
    private String category;
    private String description;
    private boolean availability;
    private double price;
    private Integer quantity;
    private String photography;

}
