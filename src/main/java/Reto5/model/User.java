package Reto5.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "users")
/*
 *
 * @author Juan Barragan
 */
public class User {
    @Id
    /*
     *Atributos Modelo Usuario
     */
    private Integer id;
    
    private String identification;
   
    private String name;

    private Date birthtDay;

    private String monthBirthtDay;
    
    private String address;
    
    private String cellPhone;
    
    private String email;
   
    private String password;
   
    private String zone;
    
    private String type;

}

