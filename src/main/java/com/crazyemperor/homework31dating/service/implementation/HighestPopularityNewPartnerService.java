package com.crazyemperor.homework31dating.service.implementation;

import com.crazyemperor.homework31dating.entity.User;
import com.crazyemperor.homework31dating.repository.UserRepository;
import com.crazyemperor.homework31dating.service.NewPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighestPopularityNewPartnerService implements NewPartnerService {

    private final UserRepository userRepository;

    @Autowired
    public HighestPopularityNewPartnerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getNewMatch() {
        List<User> users = userRepository.getUser();

        User highestPointer = null;

        int maxPoint = 0;

        for (User user : users) {
            if (user.getPoint() > maxPoint) {
                maxPoint = user.getPoint();
                highestPointer = user;
            }
        }

        return highestPointer;
    }

    @Override
    public boolean isSuitable() {

       switch (getNewMatch().getSex()) {
            case MALE, FEMALE -> {
                return true;
            }
        }
        return false;
    }
}
