package com.crazyemperor.homework31dating.repository;

import com.crazyemperor.homework31dating.entity.User;

import java.util.List;

@FunctionalInterface
public interface UserRepository {

    public List<User> getUser();
}
