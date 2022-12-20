package com.example.springformation.exp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserDAO userDAO ;

    public List<User> getUsers(){
        return userDAO.getUsers() ;
    }
    public User getUserById(Integer id){
        return userDAO.getUserById(id) ;
    }

    public User createUser(User user){
        return userDAO.createUser(user);
    }

    public User updateUser(User user){
        return userDAO.updateUser(user);
    }

    public boolean deleteUser(Integer id) {
        return userDAO.deleteUser(id);
    }
}
