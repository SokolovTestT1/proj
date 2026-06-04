package Course.conditions;

/**
 * Класс, реализующий базовые утилитарные методы для работы с примитивами:
 * арифметические операции, сравнения, логические проверки, обработка дат/времени.
 */
public class Tasks {

    /**
     * Вычисляет абсолютное значение числа (модуль).
     *
     * @param x входное число
     * @return |x| — неотрицательное значение числа
     */
    public static int abs(int x) {
        if (x < 0) {
            return -x;
        } else return x;
    }

    /**
     * Безопасное целочисленное деление: при делении на ноль возвращает 0.
     *
     * @param x делимое
     * @param y делитель
     * @return x / y, если y ≠ 0; иначе — 0
     */
    public static int safeDiv(int x, int y) {
        if (y == 0) {
            return 0;
        } else return x / y;
    }

    /**
     * Возвращает большее из двух целых чисел.
     *
     * @param x первое число
     * @param y второе число
     * @return максимальное из x и y
     */
    public static int max(int x, int y) {
        if (x > y) {
            return x;
        } else return y;
    }

    /**
     * Сравнивает два числа и возвращает строку вида "a &gt; b" или "a &lt; b".
     *
     * @param x первое число
     * @param y второе число
     * @return строка сравнения
     */
    public static String makeDecision(int x, int y) {
        if (x > y) {
            return x + " > " + y;
        } else return x + " < " + y;
    }

    /**
     * Возвращает наибольшее из трёх целых чисел.
     *
     * @param x первое число
     * @param y второе число
     * @param z третье число
     * @return max(x, y, z)
     */
    public static int max3(int x, int y, int z) {
        if (y > x) {
            x = y;
        }
        if (z > x) {
            x = z;
        }
        return x;
    }

    /**
     * Проверяет, равна ли сумма двух любых чисел третьему.
     *
     * @param x первое число
     * @param y второе число
     * @param z третье число
     * @return {@code true}, если x + y == z или x + z == y или y + z == x
     */
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

    /**
     * Складывает два числа. Если сумма лежит в диапазоне [10, 19], возвращает 20.
     *
     * @param x первое число
     * @param y второе число
     * @return x + y, либо 20, если сумма в диапазоне [10, 19]
     */
    public static int sum2(int x, int y) {
        int sum = x + y;
        if (sum >= 10 && sum <= 19) {
            return 20;
        } else return sum;
    }

    /**
     * Проверяет, делится ли число на 3 или на 5, но НЕ на оба одновременно.
     *
     * @param x проверяемое число
     * @return {@code true}, если делится ровно на одно из: 3 или 5;
     *         {@code false}, если делится на оба или ни на одно
     */
    public static boolean is35(int x) {
        if (x % 3 == 0 && x % 5 == 0) {
            return false; // делится на оба — false
        }
        if (x % 3 == 0 || x % 5 == 0) {
            return true;  // делится только на одно — true
        }
        return false;
    }

    /**
     * Проверяет "магическое число 6": истинно, если:
     * - одно из чисел равно 6,
     * - сумма чисел равна 6,
     * - модуль разности чисел равен 6.
     *
     * @param x первое число
     * @param y второе число
     * @return {@code true}, если выполнено одно из условий, иначе {@code false}
     */
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

    /**
     * Возвращает строку с правильным склонением слова "год" в зависимости от возраста.
     * Поддерживает русскую морфологию (1 год, 2–4 года, 5–20 лет и т.д.).
     *
     * @param x возраст (целое неотрицательное число)
     * @return строка в формате "X год/года/лет"
     */
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

    /**
     * Возвращает название дня недели по его номеру (1 = понедельник, ..., 7 = воскресенье).
     *
     * @param x номер дня недели (1–7)
     * @return название дня или сообщение об ошибке, если номер некорректен
     */
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

    /**
     * Выводит название дня недели по строковому имени (для демонстрации switch по строке).
     * Поддерживает полные названия: "понедельник" ... "воскресенье".
     *
     * @param x название дня недели
     */
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

    /**
     * Определяет сезон по номеру месяца.
     *
     * @param month номер месяца (1–12)
     * @return название сезона: "Зима", "Весна", "Лето", "Осень"
     *         или "некорректный месяц", если введён неверный номер
     */
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

    public static void main(String[] args) {
        System.out.println("Метод abs");
        System.out.println(abs(-5));
        System.out.println(abs(6));

        System.out.println("\nМетод safeDiv");
        System.out.println(safeDiv(5, 0));
        System.out.println(safeDiv(10, 5));

        System.out.println("\nМетод max");
        System.out.println(max(3, 7));
        System.out.println(max(10, 5));

        System.out.println("\nМетод makeDecision");
        System.out.println(makeDecision(5, 7));
        System.out.println(makeDecision(10, 5));

        System.out.println("\nМетод max3");
        System.out.println(max3(1, 2, 3));
        System.out.println(max3(10, 5, 1));

        System.out.println("\nМетод sum3");
        System.out.println(sum3(1, 2, 3));
        System.out.println(sum3(1, 2, 4));

        System.out.println("\nМетод sum2");
        System.out.println(sum2(1, 2));
        System.out.println(sum2(10, 5));

        System.out.println("\nМетод is35");
        System.out.println(is35(15));
        System.out.println(is35(10));

        System.out.println("\nМетод magic6");
        System.out.println(magic6(1, 2));
        System.out.println(magic6(1, 5));
        System.out.println(magic6(1, 6));
        System.out.println(magic6(6, 1));
        System.out.println(magic6(1, 8));

        System.out.println("\nМетод age");
        System.out.println(age(1));
        System.out.println(age(4));
        System.out.println(age(5));
        System.out.println(age(11));
        System.out.println(age(100));

        System.out.println("\nМетод day");
        System.out.println(day(1));
        System.out.println(day(5));
        System.out.println(day(7));
        System.out.println(day(8));

        System.out.println("\nМетод printDays");
        printDays("понедельник");
        printDays("вторник");
        printDays("пятница");
        printDays("тест");

        System.out.println("\nМетод season");
        System.out.println(season(1));
        System.out.println(season(3));
        System.out.println(season(6));
        System.out.println(season(10));
        System.out.println(season(13));
    }
}