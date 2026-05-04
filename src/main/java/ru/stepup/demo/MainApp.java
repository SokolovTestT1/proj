package ru.stepup.demo;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Hello, ALL!");
        System.out.println(add(5, 2));
        Cat cat = new Cat();
        cat.setName2("Barsik");
        System.out.println(cat.getName2());

        System.out.println(substract(3,2));
    }


    public static int add(int a, int b) {
        return a + b;
    }
    public static int substract (int c,int d){
        return(c-d);
    }
}
