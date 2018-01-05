package com.example.restapi.service;

import com.example.restapi.model.User;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserService {
    private Map<String,User> users;
    List<User> l1;

    @PostConstruct
    private void loadUser() {
        users = new HashMap<>();
        users.put("1",new User("Tom",20));
        users.put("2",new User("Jerry",19));

        User u1 = new User("bharath",13);
        User u2 = new User("kumar",13);
        User u3 = new User("vinod",13);
        User u4 = new User("aishu",13);
        l1 = new ArrayList<>();
        l1.add(u1);
        l1.add(u2);
        l1.add(u3);
        l1.add(u4);
    }



    public User findById(String id) {
        return users.get(id);
    }

    public void addUsers() { users.put("3",new User("Bharath",29));}

    public List<User> getAllUsers() {return l1;}

}