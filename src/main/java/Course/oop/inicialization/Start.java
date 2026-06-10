package Course.oop.inicialization;

public class Start {
    public static void main(String[] args) {
        Color color = new Color();
        System.out.println(color);

        //A a1 = new A();
        //A a2 = new A("551");
        //A a = new A(5);
        //System.out.println(a.x);
        //System.out.println(a2.x);

        Name name = new Name("Test");
        System.out.println("Объект - " + name.familyName + " " + name.personName);

        Name name1 = Name.ofPersonNameAndFamilyName("Ivan", "Ivanov");
        Name name2 = Name.ofPersonNameAndPatronymic("Petr", "Petrovich");

        System.out.println(name1.familyName + " " + name1.personName);
        System.out.println(name2.familyName + " " + name2.personName + " " + name2.patronymic);

        B b1 = B.of(null); //B{str=''}
        B b2 = B.ofNullable(null); // B{str='null'}
        B b3 = B.of("Test"); // B{str='Test'}

        B b4 = B.ofNullable(null);
        System.out.println(b4 == b2); //true

        Integer i1 = 500;
        Integer i2 = 500;
        System.out.println(i1 == i2); //false
        Integer i3 = Integer.valueOf(50);
        Integer i4 = 50;
        System.out.println(i3 == i4); //true
    }
}
