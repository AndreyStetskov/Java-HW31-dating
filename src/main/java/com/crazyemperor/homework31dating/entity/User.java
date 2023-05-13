package com.crazyemperor.homework31dating.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    public String name;
    public String firstName;
    public String lastName;
    public int age;
    public Sex sex;
    public String address;
    public String city;
    public String postIndex;
    public String Country;
    private int point;
    private boolean isBlocked;


    public User(String name, int age, Sex sex, int point) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.point = point;
    }

    public User(String[] info) {
        this.name = info[1];
        firstName = info[2];
        lastName = info[3];
        this.age = Integer.parseInt(info[4]);
        this.sex = Sex.valueOf(info[5]);
        address = info[6];
        city = info[7];
        postIndex = info[8];
        Country = info[9];
        this.point = Integer.parseInt(info[10]);
        this.isBlocked = Boolean.parseBoolean(info[11]);
    }

}
