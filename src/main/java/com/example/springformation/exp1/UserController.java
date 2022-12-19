package com.example.springformation.exp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@RestController
//@Scope("request")
//@ConditionalOnProperty(value = "test", havingValue = "true")
//@Primary
//@Component
@ConditionalOnMissingBean(UserDAO.class)
public class UserController {

    private UserService userService ;

    @Autowired
    ApplicationContext context ;
    @PostConstruct
    public void init(){
        System.out.println();
    }

    public UserController(){
        System.out.println("instantiated");
    }

    @Autowired
    public void setUserService(UserService userService) {
        System.out.println("dependencies injected");
        this.userService = userService;
    }

    @PreDestroy
    public void destroty(){
        System.out.println();
    }

    @GetMapping("/")
    public String test(){
        return "Hello";
    }
}
