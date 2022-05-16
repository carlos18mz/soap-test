package com.claroplay.soapdummy.service;

import com.claroplay.soapdummy.samples.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize() {

        User v = new User();
        v.setName("Victor");
        v.setEmpId(1111);
        v.setSalary(12000);

        User g = new User();
        g.setName("Gianfranco");
        g.setEmpId(1112);
        g.setSalary(32000);
        User e = new User();
        e.setName("Eduardo");
        e.setEmpId(1113);
        e.setSalary(16000);

        users.put(v.getName(), v);
        users.put(g.getName(), g);
        users.put(e.getName(), e);
    }


    public User getUsers(String name) {
        return users.get(name);
    }
}
