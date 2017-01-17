package fr.inti.test.user.service;

import java.util.List;

import fr.inti.test.entities.User;
import fr.inti.test.exception.UserFound;

public interface IUserService {


    User addUser(final User u) throws UserFound;
    
    User updateUser(final User u);
    
    User getOne(final Long id);
    
    List<User> getUsers();
    
    User remove(final Long id);
    
    long getUserByName(String nom);
}
