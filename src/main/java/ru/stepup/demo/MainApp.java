package ru.stepup.demo;

public class MainApp {
    static void main() {
        System.out.println("Hello, world!");
        System.out.println(add(0, 2));
        Cat cat = new Cat();
        cat.setName2("Barsik");
        System.out.println(cat.getName2());
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
