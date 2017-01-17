package fr.inti.test.user.dao;

import java.util.List;

import fr.inti.test.entities.User;

public interface IUserDao {

     User addUser(final User u);
     
     User updateUser(final User u);
     
     User getOne(final Long id);
     
     List<User> getUsers();
     
     User remove(final Long id);
     
     long getUserByName(String nom);
}
