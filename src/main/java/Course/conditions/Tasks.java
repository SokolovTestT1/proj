package Course.conditions;

public class Tasks {
    public static int abs(int x) {
        if (x < 0) {
            return -x;
        } else return x;
    }

    public static int safeDiv(int x, int y) {
        if (y == 0) {
            return 0;
        } else return x / y;
    }

    public static int max(int x, int y) {
        if (x > y) {
            return x;
        } else return y;
    }

    public static String makeDecision(int x, int y) {
        if (x > y) {
            return x + " > " + y;
        } else return x + " < " + y;
    }

    public static int max3(int x, int y, int z) {
        if (y > x) {
            x = y;
        }
        if (z > x) {
            x = z;
        }
        return x;
    }

    public static boolean sum3(int x, int y, int z) {
        if (x + y == z) {
            return true;
        }
        if (x + z == y) {
            return true;
        }
        if (y + z == x) {
            return true;
        } else return false;

    }

    public static int sum2(int x, int y) {
        int sum = x + y;
        if (sum >= 10 && sum <= 19) {
            return 20;
        } else return sum;
    }

    public static boolean is35(int x) {
        if (x % 3 == 0 && x % 5 == 0) {
            return false; // делится на оба — false
        }
        if (x % 3 == 0 || x % 5 == 0) {
            return true;  // делится только на одно — true
        }
        return false;
    }

    public static boolean magic6(int x, int y){
        if (x == 6 || y == 6){
            return true;
        } if (x + y == 6){
            return true;
        } if (x - y == 6 || y - x == 6){
            return true;
        } else return false;
    }

    // public static boolean magic6(int x, int y) {
    //    return x == 6 || y == 6 || x + y == 6 || Math.abs(x - y) == 6;
    //}

    public static String age(int x) {
        int lastDigit = x % 10;
        int lastTwoDigits = x % 100;

        // Исключения: 11, 12, 13, 14 — они всегда "лет"
        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return x + " лет";
        }

        if (lastDigit == 1) {
            return x + " год";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            return x + " года";
        } else {
            return x + " лет";
        }
    }


    public static void main(String[] args) {
        System.out.println("Метод abs");
        System.out.println(abs(-5));
        System.out.println(6);

        System.out.println("Метод safeDiv");
        System.out.println(safeDiv(5, 0));
        System.out.println(safeDiv(10, 5));

        System.out.println("Метод max");
        System.out.println(max(3, 7));
        System.out.println(max(10, 5));

        System.out.println("Метод makeDecision");
        System.out.println(makeDecision(5, 7));
        System.out.println(makeDecision(10, 5));

        System.out.println("Метод max3");
        System.out.println(max3(1, 2, 3));
        System.out.println(max3(10, 5, 1));

        System.out.println("Метод sum3");
        System.out.println(sum3(1, 2, 3));
        System.out.println(sum3(1, 2, 4));

        System.out.println("Метод sum2");
        System.out.println(sum2(1, 2));
        System.out.println(sum2(10, 5));

        System.out.println("Метод is35");
        System.out.println(is35(15));
        System.out.println(is35(10));

        System.out.println("Метод magic6");
        System.out.println(magic6(1, 2));
        System.out.println(magic6(1, 5));
        System.out.println(magic6(1, 6));
        System.out.println(magic6(6, 1));
        System.out.println(magic6(1, 8));

        System.out.println("Метод age");
        System.out.println(age(1));
        System.out.println(age(4));
        System.out.println(age(5));
        System.out.println(age(11));
        System.out.println(age(100));
    }
}
