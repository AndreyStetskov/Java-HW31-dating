package com.crazyemperor.homework31dating.service;

import com.crazyemperor.homework31dating.entity.User;


public interface NewPartnerService {

    User getNewMatch();

    boolean isSuitable();
}
