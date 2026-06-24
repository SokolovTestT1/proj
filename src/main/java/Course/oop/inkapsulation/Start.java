package Course.oop.inkapsulation;

public class Start {
    public static void main(String[] args) {
        System.out.println("Hello incapsulation");
        A a = A.of("qwerty");
        System.out.println(a);

        A a1 = new A(44);
        // a1.setX(-5);
        System.out.println(a1);

        B b = new B(12);
        System.out.println(b.getX());
    }
}

class Start1 {
    public static void main(String[] args) {
        B1 b1 = new B1(4);
        A1 a1 = new A1();
        a1.setB1(b1);
        b1 = a1.getB1();
        b1.x = -15;
        System.out.println(a1);
    }
}
