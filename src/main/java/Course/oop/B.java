package Course.oop;

public class B {
    static void main() {
        A a1 = new A("some text");
        A a2 = new A("more text");
        A a3 = a1;

        a3.str = "changed";
        A a4 = null;

        a1.print(1);

        a1.print(); // some text
        a2.print(); // changed
        a3.print(); // changed
        //a4.print(); // nullPointerException

        A a5 = new A("text");
        A a6 = new A("text");
        System.out.println(a5 == a6); // false
    }
}
