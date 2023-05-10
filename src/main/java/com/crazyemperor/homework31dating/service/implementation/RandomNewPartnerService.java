package com.crazyemperor.homework31dating.service.implementation;

import com.crazyemperor.homework31dating.entity.Sex;
import com.crazyemperor.homework31dating.entity.User;
import com.crazyemperor.homework31dating.repository.UserRepository;
import com.crazyemperor.homework31dating.service.NewPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Primary
public class RandomNewPartnerService implements NewPartnerService {

    private UserRepository userRepository;

    @Autowired
    public RandomNewPartnerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getNewMatch() {
        Random random = new Random();

        List<User> users = userRepository.getUser();

        int i = random.nextInt(users.size());

        return users.get(i);
    }

    @Override
    public boolean isSuitable() {
        User user = new User();
        Sex sex;

        user = getNewMatch();

        switch (user.getSex()) {
            case MALE, FEMALE -> {
                return true;
            }
        }
        return false;
    }
}
