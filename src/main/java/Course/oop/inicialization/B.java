package Course.oop.inicialization;

public class B {
    String str;

    private static final B nullB = new B(null);
    private static final B emptyB = new B("");

    private B(String str) {
        this.str = str;
    }

    static B of(String str) {
        if (str == null) return emptyB;
        return new B(str);
    }

    static B ofNullable(String str) {
        if (str == null) return nullB;
        return new B(str);
    }

    @Override
    public String toString() {
        return "B{" +
                "str='" + str + '\'' +
                '}';
    }
}
