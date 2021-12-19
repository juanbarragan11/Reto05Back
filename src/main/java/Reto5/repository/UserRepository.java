package Reto5.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto5.model.User;
import Reto5.repository.crud.UserCrudRepository;

import java.util.List;
import java.util.Optional;

/*
 * @author Juan Barragan
 */

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    /*
    *Acceso a la consulta de los usuarios general
    */
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }

    /*
    *Acceso consulta de los usuarios por identificador
    */
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }

    /*
    *Acceso a guardar los usuarios
    */
    public User save(User user){
        return userCrudRepository.save(user);
    }
    
    /*
    *Acceso a actualizar los usuarios
    */
    public void update(User user){
        userCrudRepository.save(user);
    }

    /*
    *Acceso a eliminar los usuarios
    */
    public void delete(User user){
        userCrudRepository.delete(user);
    }

    /*
    *Acceso a validar emails
    */
    public boolean emailExists(String email){
        Optional<User> user=userCrudRepository.findByEmail(email);
        return user.isPresent();
    }

    /*
    *Acceso a autenticación de usuarios
    */
    public Optional<User>authenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /*
    *Acceso a consulta de mes de nacimiento
    */
    public List<User>getByMonthBirthtDay(String monthBirthtDay){
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
}
