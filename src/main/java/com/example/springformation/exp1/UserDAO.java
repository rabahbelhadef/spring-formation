package com.example.springformation.exp1;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDAO {

    private Map<Integer,User> userMap ;
    private Integer lastIndex = 0 ;
    @PostConstruct
    public void init (){
        userMap = new LinkedHashMap<>() ;
        userMap.put(++lastIndex, User.builder().id(lastIndex).name("Yahia").firstname("Yahia"). build());
        userMap.put(++lastIndex, User.builder().id(lastIndex).name("Moncef").firstname("Moncef"). build()) ;
    }

    public List<User> getUsers() {
        return userMap.values().stream().toList();
    }
    public User getUserById(Integer id) {
        return userMap.get(id) ;
    }


    public User createUser(User user) {
        user.setId(++lastIndex);
        userMap.put(lastIndex, user);
        return user ;
    }

    public User updateUser(User user) {
        userMap.put(user.getId(), user) ;
        return user;
    }

    public boolean deleteUser(Integer id) {
        return userMap.remove(id) == null;
    }
}
