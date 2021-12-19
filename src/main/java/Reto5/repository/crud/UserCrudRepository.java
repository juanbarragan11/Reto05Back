package Reto5.repository.crud;

import org.springframework.data.mongodb.repository.MongoRepository;

import Reto5.model.User;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends MongoRepository<User,Integer> {

    /**
     * CRUD de busqueda usuario por email
     */
    Optional<User> findByEmail(String email);

    /**
     * CRUD de busqueda por email y contraseña usuario
     */
    Optional<User>findByEmailAndPassword(String email, String password);

    /**
     * CRUD de busqueda por nombre o email usuario
     */
    Optional<User>findByNameOrEmail(String name, String email);

    /**
     * CRUD de busqueda usuario fecha cumpleaños
     */
    List<User>findByMonthBirthtDay(String monthBirthtDay);
}
