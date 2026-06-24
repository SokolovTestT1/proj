package Course.oop.inkapsulation;

public class A {
    private String str;
    private int x; // всегда должен быть положительным

    public A(int x) {
        privateSetX(x);
    }

    public int getX() {
        return x;
    }

    private void privateSetX(int x) {
        if (x < 0)
            throw new IllegalArgumentException("x must be positive");
        this.x = x;
    }

    public void setX(int x) {
        privateSetX(x);
    }

    private A(String str) {
        this.str = str;
    }

    public static A of(String str) {
        if (str == null) str = "";
        return new A(str);
    }

    //public static A ofNullable(String str) {
    //    return new A(str);
    //}

    @Override
    public String toString() {
        return "A{" +
                "str='" + str + '\'' +
                ", x=" + x +
                '}';
    }
}

class B { // immutable
    private final int x; // всегда должен быть положительным

    public B(int x) {
        if (x < 0)
            throw new IllegalArgumentException("x must be positive");
        this.x = x;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "B{" +
                "x=" + x +
                '}';
    }
}

class A1 {
    private B1 b1;

    public B1 getB1() {
        return new B1(b1.x);
    }

    public void setB1(B1 b1) {
        if (b1.x < 0)
            throw new IllegalArgumentException("x must be positive");
        this.b1 = new B1(b1.x);
    }

    @Override
    public String toString() {
        return "A1{" +
                "b1=" + b1 +
                '}';
    }
}



class B1 {
    int x;

    public B1(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "B1{" +
                "x=" + x +
                '}';
    }
}


