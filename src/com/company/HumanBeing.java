package com.company;

public class HumanBeing {
    private String name;
    private String lastName;
    private String sex;
    private int age;

    //constructor

    protected HumanBeing (String name, String lastName, String sex, int age){
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    //getters

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
