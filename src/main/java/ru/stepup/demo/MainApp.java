package ru.stepup.demo;

public class MainApp {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", 2, 8.5f, "black");
        Cat cat2 = new Cat();
        cat2.setName("Murzic");
        cat2.setAge(4);
        cat2.setWeight(6.70F);
        cat2.setColor("orange");


        System.out.println(substract(3, 2));
        System.out.println(add(5, 2));

        Dog dog = new Dog();
        Dog dog1 = new Dog("Sharick",3,10.1f);
    }


    public static int add(int a, int b) {
        return a + b;
    }

    public static int substract(int c, int d) {
        return (c - d);
    }
}
