package ru.stepup.demo;

public class Cat {
    private String name2;
    // TODO сменить тип на Enum
    private String color;
    private int age;

    public Cat(String name2, String color, int age) {
        this.name2 = name2;
        this.color = color;
        this.age = age;
    }

    public Cat() {
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
