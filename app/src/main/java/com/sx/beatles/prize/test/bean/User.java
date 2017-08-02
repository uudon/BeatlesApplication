package com.sx.beatles.prize.test.bean;

/**
 * Created by 施行 on 2017/7/30.
 */

public class User {

    private String name;
    private String age;

    public User(String name, String age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
