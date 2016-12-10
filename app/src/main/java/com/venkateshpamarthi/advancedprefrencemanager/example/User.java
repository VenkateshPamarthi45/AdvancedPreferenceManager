package com.venkateshpamarthi.advancedprefrencemanager.example;

import java.io.Serializable;

/**
 * Created by venkateshpamarthi on 10/12/16.
 */

public class User implements Serializable {
    public String name;
    public int age;
    public int phoneNo;

    public User(String name, int age, int phoneNo) {
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
    }
}
