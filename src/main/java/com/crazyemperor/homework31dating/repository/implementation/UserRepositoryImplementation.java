package com.crazyemperor.homework31dating.repository.implementation;

import com.crazyemperor.homework31dating.entity.User;
import com.crazyemperor.homework31dating.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Primary
@Component
public class UserRepositoryImplementation implements UserRepository {

    private List<User> userList;

    @PostConstruct
    public  void  init() {

        userList = new ArrayList<>();

        try(BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/main/static/users/userDating"))) {
            Stream <String> userDating = bufferedReader.lines();

            userDating.map(user -> user.replaceAll("\\s+", " "))
                    .skip(2)
                    .forEach(user -> {

                        String[] data = user.split(" \\| ");

                        User someUser = new User(data);

                        userList.add(someUser);
                    });
        }
        catch (IOException e) {
            throw new IllegalArgumentException("Something strange is going on with this file", e);
        }
    }


    @Override
    public List<User> getUser() {
        return userList;
    }
}
