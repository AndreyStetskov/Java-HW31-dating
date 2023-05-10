package com.crazyemperor.homework31dating.controller;

import com.crazyemperor.homework31dating.entity.User;
import com.crazyemperor.homework31dating.service.NewPartnerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatingController {

    private NewPartnerService newPartnerService;

    @Autowired
    public DatingController(NewPartnerService newPartnerService) {
        this.newPartnerService = newPartnerService;
    }

    @GetMapping(value = "/new-match")
       public User newMatch() {
       return newPartnerService.getNewMatch();
       }

    @GetMapping(value = "/agree")
    public User agree() {
        if (newPartnerService.isSuitable()) {
            return newPartnerService.getNewMatch();
        }
        else {
            System.out.println("Sorry, you're not a match'");
        }
        return null;
    }
}
