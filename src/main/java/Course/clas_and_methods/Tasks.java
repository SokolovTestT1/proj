package Course.clas_and_methods;

public class Tasks {
    public static void main(String[] args) {
        System.out.println("метод fraction");
        System.out.println(fraction(2.7));

        System.out.println("метод notEqual");
        System.out.println(notEqual(1, 2, 3));
        System.out.println(notEqual(1, 3, 3));
        System.out.println(notEqual(2, 2, 2));

        System.out.println("метод fraction2");
        System.out.println(fraction2(2.7));

        System.out.println("метод sumLastNums");
        System.out.println(sumLastNums(1232));

        System.out.println("метод charToNum");
        System.out.println(charToNum('Q'));

        System.out.println("метод isPositive");
        System.out.println(isPositive(1));
        System.out.println(isPositive(-1));

        System.out.println("метод is2Digits");
        System.out.println(is2Digits(12));
        System.out.println(is2Digits(123));

        System.out.println("метод isUpperCase");
        System.out.println(isUpperCase('A'));
        System.out.println(isUpperCase('a'));

        System.out.println("метод isInRange");
        System.out.println(isInRange(5, 1, 3));
        System.out.println(isInRange(2, 15, 33));

        System.out.println("метод isDivisor");
        System.out.println(isDivisor(2, 10));
        System.out.println(isDivisor(3, 10));

        System.out.println("метод isEqual");
        System.out.println(isEqual(1, 1, 1));
        System.out.println(isEqual(1, 2, 1));

    }

    public static double fraction(double x) {
        int result = (int) x;
        return result;
    }

    public static boolean notEqual(int a, int b, int c) {
        boolean result = (a != b) && (b != c) && (a != c);
        return result;
    }

    public static double fraction2(double x) {
        double a = (int) x;
        double result = x - a;
        return result;
    }

    public static int sumLastNums(int x) {
        int lastDigit = x % 10;           // Получаем последнюю цифру
        int secondLastDigit = (x / 10) % 10; // Получаем предпоследнюю цифру
        return lastDigit + secondLastDigit;
    }

    public static int charToNum(char x) {
        // Вычитаем из кода переданного символа код символа '0' (который равен 48)
        // Таким образом, при передаче '0' получим 0, при передаче '1' — 1 и так далее
        return x - '0';
    }

    public static boolean isPositive(int x) {
        boolean result = x > 0;
        return result;
    }

    public static boolean is2Digits(int x) {
        return x >= 10 && x <= 99;
    }

    public static boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }

    public static boolean isInRange(int a, int b, int num) {
        // Определяем левую и правую границы диапазона
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        // Проверяем, входит ли num в диапазон [min, max]
        return num >= min && num <= max;
    }

    public static boolean isDivisor(int a, int b) {
        if (b % a == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEqual(int a, int b, int c) {
        return (a == b) && (b == c) && (a == c);
    }
}

class Task10 {
    public static void main(String[] args) {
        int result = 5;
        result = lastNumSum(result, 11);
        result = lastNumSum(result, 123);
        result = lastNumSum(result, 14);
        result = lastNumSum(result, 1);
        System.out.println(result);
    }

    public static int lastNumSum(int a, int b) {
        return (a % 10) + (b % 10);
    }
}