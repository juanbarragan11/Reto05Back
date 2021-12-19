package Reto5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Reto5.repository.crud.OrderCrudRepository;
import Reto5.repository.crud.ProductCrudRepository;
import Reto5.repository.crud.UserCrudRepository;

@SpringBootApplication
public class Reto5Ciclo4Application implements CommandLineRunner {

        /*
        * Importaciones de Metodos CRUD para eliminacion de Documentos
        */
        @Autowired
        private ProductCrudRepository productRepository;

        @Autowired
        private UserCrudRepository userRepository;

        @Autowired
        private OrderCrudRepository orderRepository;

        public static void main(String[] args) {SpringApplication.run(Reto5Ciclo4Application.class, args);}

    @Override
    public void run(String... args) throws Exception {

    /*
    * Eliminacion de documentacionpara carga en Mastertech
    */
     userRepository.deleteAll();
     productRepository.deleteAll();
     orderRepository.deleteAll();

    }
}
