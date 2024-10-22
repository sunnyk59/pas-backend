package com.pas.demo.model;

public class Patient {
    private int urNo;
    private String name;
    private int age;

    // Constructors
    public Patient() {}

    public Patient(int urNo, String name, int age) {
        this.urNo = urNo;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public int getUrNo() {
        return urNo;
    }

    public void setUrNo(int urNo) {
        this.urNo = urNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "urNo=" + urNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
