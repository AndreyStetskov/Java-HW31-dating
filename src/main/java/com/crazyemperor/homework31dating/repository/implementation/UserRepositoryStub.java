package com.crazyemperor.homework31dating.repository.implementation;

import com.crazyemperor.homework31dating.entity.Sex;
import com.crazyemperor.homework31dating.entity.User;
import com.crazyemperor.homework31dating.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryStub implements UserRepository {

    private List<User> userList;

    @PostConstruct
    public  void  init() {
        User user = new User("George", 22, Sex.MALE, 18);
        User user1 = new User("Melissa", 18, Sex.FEMALE, 153);
        User user2 = new User("Vasilii", 38, Sex.MALE, 75);
        User user3 = new User("Tina", 44, Sex.FEMALE, 64);
        User user4 = new User("Julia", 19, Sex.MALE, 128);

        userList = new ArrayList<>();

        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
    }

    @Override
    public List<User> getUser() {
        return userList;
    }
}
