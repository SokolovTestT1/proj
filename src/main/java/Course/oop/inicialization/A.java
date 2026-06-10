package Course.oop.inicialization;

public class A {
    int x; // инлайн инициализация
    static int y;

    static {
        System.out.println("A static");
    }

    //{
    //    System.out.println("A created");
    //     блок инициализации
    //}

    A() {
        this(0);
    }

    public A(int x) {
        if (x > 0) {
            this.x = x;
        }
        System.out.println("A created");
    }

    A(String s) {
        this(Integer.parseInt(s));
    }
}
