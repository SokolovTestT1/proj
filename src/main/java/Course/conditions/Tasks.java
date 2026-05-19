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

    public static boolean magic6(int x, int y) {
        if (x == 6 || y == 6) {
            return true;
        }
        if (x + y == 6) {
            return true;
        }
        if (x - y == 6 || y - x == 6) {
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

    public static String day(int x) {
        switch (x) {
            case 1:
                return "понедельник";
            case 2:
                return "вторник";
            case 3:
                return "среда";
            case 4:
                return "четверг";
            case 5:
                return "пятница";
            case 6:
                return "суббота";
            case 7:
                return "воскресенье";
            default:
                return "это не день недели";
        }
    }

    public static void printDays(String x) {
        switch (x) {
            case "понедельник":
                System.out.println("понедельник");
                break;
            case "вторник":
                System.out.println("вторник");
                break;
            case "среда":
                System.out.println("среда");
                break;
            case "четверг":
                System.out.println("четверг");
                break;
            case "пятница":
                System.out.println("пятница");
                break;
            case "суббота":
                System.out.println("суббота");
                break;
            case "воскресенье":
                System.out.println("воскресенье");
                break;
            default:
                System.out.println("это не день недели");
        }
    }
    public static String season(int month) {
        if (month == 12 || month == 1 || month == 2) {
            return "Зима";
        } else if (month == 3 || month == 4 || month == 5) {
            return "Весна";
        } else if (month == 6 || month == 7 || month == 8) {
            return "Лето";
        } else if (month == 9 || month == 10 || month == 11) {
            return "Осень";
        } else return "некорректный месяц";
    }
    /* public static String season(int month) {
        return switch (month) {
            case 12, 1, 2 -> "Зима";
            case 3, 4, 5 -> "Весна";
            case 6, 7, 8 -> "Лето";
            case 9, 10, 11 -> "Осень";
            default -> "некорректный месяц";
        };
    } */

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

        System.out.println("Метод day");
        System.out.println(day(1));
        System.out.println(day(5));
        System.out.println(day(7));
        System.out.println(day(8));

        System.out.println("Метод printDays");
        printDays("понедельник");
        printDays("вторник");
        printDays("пятница");
        printDays("тест");

        System.out.println("Метод season");
        System.out.println(season(1));
        System.out.println(season(3));
        System.out.println(season(6));
        System.out.println(season(10));
        System.out.println(season(13));
    }
}
