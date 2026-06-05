package Course.oop;

public class Start {
    static void main() {
        Stack s1 = new Stack();
        Stack s2 = new Stack();

        s1.push(1);
        s2.push(2);
        s1.push(3);
        System.out.println(s2.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
    }
}
