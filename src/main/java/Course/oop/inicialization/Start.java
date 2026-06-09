package Course.oop.inicialization;

public class Start {
    public static void main(String[] args) {
        Color color = new Color();
        System.out.println(color);

        A a1 = new A();
        A a2 = new A("551");
        A a = new A(5);
        //System.out.println(a.x);
        System.out.println(a2.x);

        Name name = new Name("Test");
        System.out.println("Объект - " + name.familyName + " " + name.personName);
    }
}
