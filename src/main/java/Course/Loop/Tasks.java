package Course.Loop;

public class Tasks {
    public static void listNums(int x) {
        for (int i = 0; i < x; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void reverseListNums(int x) {
        for (int i = x; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void chet(int x) {
        for (int i = 0; i < x; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Возводит число x в степень y.
     *
     * @param x основание степени
     * @param y показатель степени (неотрицательное целое число)
     * @return результат x^y
     * <p>
     * Примеры:
     * pow(2, 3) → 8
     * pow(5, 0) → 1
     * pow(3, 4) → 81
     */
    public static int pow(int x, int y) {
        int result = 1; // Начинаем с 1, потому что x^0 = 1

        for (int i = 0; i < y; i++) {
            result = result * x; // Умножаем результат на x, y раз
        }

        return result;
    }

    /**
     * Возвращает количество цифр в десятичной записи числа x.
     * Учитывает, что 0 содержит одну цифру.
     * Работает и с отрицательными числами — считает цифры без учёта знака.
     *
     * @param x число, длину которого нужно определить
     * @return количество цифр в числе
     * <p>
     * Примеры:
     * numLen(123) → 3
     * numLen(0)   → 1
     * numLen(-456) → 3
     */
    public static int numLen(long x) {
        // Обрабатываем случай, если x — отрицательное число
        if (x < 0) {
            x = -x; // делаем положительным, чтобы не мешал минус
        }
        // Особый случай: 0 содержит одну цифру
        if (x == 0) {
            return 1;
        }
        int count = 0;
        while (x > 0) {
            count++;       // увеличиваем счётчик цифр
            x /= 10;       // убираем последнюю цифру
        }
        return count;
    }

    /**
     * Проверяет, все ли цифры в числе x одинаковые.
     *
     * @param x число для проверки (допускаются отрицательные, знак игнорируется)
     * @return true, если все цифры числа одинаковы; иначе false
     * <p>
     * Примеры:
     * equalNum(111) → true
     * equalNum(121) → false
     * equalNum(5)   → true
     * equalNum(-333) → true
     * equalNum(0)   → true
     */
    public static boolean equalNum(int x) {
        // Делаем число положительным, чтобы избавиться от минуса
        if (x < 0) {
            x = -x; // меняем знак на положительный
        }
        // Если число — 0, то у него одна цифра → все цифры "одинаковы"
        if (x == 0) {
            return true;
        }

        // Получаем последнюю цифру числа — будем сравнивать все остальные с ней
        int lastDigit = x % 10;
        x /= 10; // убираем последнюю цифру

        // Перебираем оставшиеся цифры
        while (x > 0) {
            int currentDigit = x % 10; // берём текущую цифру
            if (currentDigit != lastDigit) {
                return false; // если нашли цифру, отличную от первой — не все одинаковы
            }
            x /= 10; // переходим к следующей цифре
        }

        // Если дошли сюда — все цифры одинаковы
        return true;
    }

    public static void square(int x){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    /**
     * Выводит на экран левый прямоугольный треугольник из символов '*',
     * где количество строк равно x, а в строке номер i (1..x) — ровно i звёздочек.
     *
     * @param x высота треугольника (число строк)
     * <p>
     * Пример при x = 5:
     * *
     * **
     * ***
     * ****
     * *****
     */
    public static void leftTriangle(int x) {
        for (int i = 1; i <= x; i++) {  // строки от 1 до x
            for (int j = 0; j < i; j++) {  // j от 0 до i (i раз)
                System.out.print("*");
            }
            System.out.println(); // переходим на новую строку
        }
    }
    /**
     * Выводит на экран прямоугольный треугольник из символов '*',
     * выровненный по правому краю. Высота треугольника — x строк,
     * в строке номер i (1..x) должно быть i звёздочек, выровненных по правому краю.
     *
     * @param x высота треугольника
     * Пример при x = 5:
     *     *
     *    **
     *   ***
     *  ****
     * *****
     */
    public static void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            // Печатаем пробелы: x - i штук
            for (int j = 0; j < x - i; j++) {
                System.out.print(" ");
            }
            // Печатаем звёздочки: i штук
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            // Переход на новую строку
            System.out.println();
        }
    }

    /**
     * Игра "Угадай число":
     * - Программа загадывает случайное число от 0 до 9.
     * - Пользователь вводит числа с консоли, пока не угадает.
     * - После угадывания выводится сообщение об успехе и количество сделанных попыток.
     */
    public static void guessGame() {
        int randomNum = 3; // Число, которое нужно угадать (в реальной игре можно использовать Random)
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int attempts = 0; // Счётчик попыток
        int x;

        System.out.println("What number am I thinking (0 to 9)? :");

        // Цикл продолжается, пока пользователь не угадает
        do {
            x = sc.nextInt();
            attempts++; // Увеличиваем счётчик попыток

            if (x != randomNum) {
                System.out.println("No, try again");
            }
        } while (x != randomNum);

        // После выхода из цикла — число угадано
        System.out.println("Yes, it's " + randomNum);
        System.out.println("You guessed it in " + attempts + " attempts.");
    }




     static void main(String[] args) {
        System.out.println("метод listNums");
        listNums(10);

        System.out.println("метод reverseListNums");
        reverseListNums(10);

        System.out.println("метод chet");
        chet(9);

        System.out.println("метод pow");
        System.out.println(pow(2, 3));

        System.out.println("метод numLen");
        System.out.println(numLen(123));
        System.out.println(numLen(0));
        System.out.println(numLen(-123));

        System.out.println("метод equalNum");
        System.out.println(equalNum(111));
        System.out.println(equalNum(121));
        System.out.println(equalNum(5));

        System.out.println("метод square");
        square(5);
        square(3);

        System.out.println("метод leftTriangle");
        leftTriangle(5);

        System.out.println("метод rightTriangle");
        rightTriangle(5);

        System.out.println("метод guessGame");
        guessGame();
    }
}
