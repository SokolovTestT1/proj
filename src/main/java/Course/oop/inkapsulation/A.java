package Course.oop.inkapsulation;

public class A {
    public String str;
    private int x; // всегда должен быть положительным

    public A(int x) {
        if (x > 0)
            this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x > 0)
            this.x = x;
    }

    private A(String str) {
        this.str = str;
    }

    public static A of(String str) {
        if (str == null) str = "";
        return new A(str);
    }

    public static A ofNullable(String str) {
        return new A(str);
    }

    @Override
    public String toString() {
        return "A{" +
                "str='" + str + '\'' +
                ", x=" + x +
                '}';
    }
}
