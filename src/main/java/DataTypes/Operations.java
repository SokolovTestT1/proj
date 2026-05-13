package DataTypes;

public class Operations {
    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        x += 9;
        y--;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        //Бинарные операции
        System.out.println("x + y = " + (x + y));
        System.out.println("x - y = " + (x - y));
        System.out.println("x * y = " + (x * y));
        System.out.println("x / y = " + (x / y));
        System.out.println("x % y = " + (x % y));
        //Унарные операции
        System.out.println("x = " + ++x);
        System.out.println("y = " + --y);

        String str = "Hello";
        System.out.println(x + y + str + x + y);

        // Сравнение
        int i = 10;
        System.out.println("i == 10 " + (i == 10));
        System.out.println("i != 10 " + (i != 10));
        System.out.println("i > 10 " + (i > 10));
        System.out.println("i < 10 " + (i < 11));
        System.out.println("i >= 10 " + (i >= 10));
        System.out.println("i <= 10 " + (i <= 10));

        // Логические операции
        int a = 21;
        System.out.println("a > 10 && a < 20 " + (a > 10 && a < 20));
        System.out.println("a > 10 || a < 20 " + (a > 10 || a < 20));
        System.out.println("!(a > 10 && a < 20) " + !(a > 10 && a < 20));
        System.out.println("(a>0 ^ a<10) " + (a > 0 ^ a < 10));


        double d = 10.8;
        int b = (int) d;
        double d1 = d - b;
        System.out.println("b == d || d1 >= 5 " + (b == d || d1 >= 5));
    }
}
