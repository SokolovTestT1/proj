package ru.stepup.demo;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Hi world!");
        System.out.println(add(10, 2));
        Cat cat = new Cat();
        cat.setName2("Barsik");
        System.out.println(cat.getName2());
    }


    public static int add(int a, int b) {
        return a + b;
    }
}
