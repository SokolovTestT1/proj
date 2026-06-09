package Course.oop.inicialization;

public class A {
    int x; // инлайн инициализация

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
    }

    A(String s) {
        this(Integer.parseInt(s));
    }
}
