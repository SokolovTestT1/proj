package Course.Loop;

public class Loop {
    /**
     * Проверяет строку по следующему правилу:
     * Все слова длиннее 3 символов должны начинаться с заглавной буквы (от 'A' до 'Z').
     * Слова длиной 3 и менее символа могут начинаться с любой буквы — они игнорируются.
     *
     * @param str входная строка, состоящая из слов, разделённых пробелами
     * @return true, если все слова длиннее 3 символов начинаются с заглавной буквы;
     * false — если хотя бы одно такое слово начинается не с заглавной буквы
     */
    public static boolean checkString(String str) {
        // Разбиваем строку на отдельные слова по пробелу
        String[] words = str.split(" ");

        // Перебираем каждое слово в массиве
        for (String word : words) {
            // Проверяем, является ли длина слова больше 3 символов
            if (word.length() > 3) {
                // Получаем первую букву слова
                char ch = word.charAt(0);
                // Проверяем, является ли первый символ заглавной латинской буквой от 'A' до 'Z'
                // Если НЕ является — условие нарушено, возвращаем false сразу
                if (ch < 'A' || ch > 'Z') {
                    return false;
                }
            }
            // Если слово короче или равно 3 символам — пропускаем его (ничего не делаем)
        }
        // Если все проверяемые слова (длиннее 3 символов) начинаются с заглавной буквы — возвращаем true
        return true;
    }

    public static void line(int len) {
        for (int i = 0; i < len; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public static void square(int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        System.out.println("Простой цикл");
        for (int i = 1; i <= 10; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("Обратный цикл");
        for (int i = 9; i >= 0; i--) {
            System.out.println(i + " ");
        }

        System.out.println("Таблица умножения");
        int x = 2;
        int max = 10;
        for (int i = 0; i <= max; i++) {
            System.out.println(x + " * " + i + " = " + x * i);
        }

        System.out.println("Цикл с возведением в степень");
        int max2 = 3000;
        for (int res = 1; res <= max2; res *= x) {
            System.out.println(res);
        }

        System.out.println("Чётные числа");
        int max3 = 100;
        for (int i = 0; i <= max3; i += 2) {
            System.out.println(i);
        }

        System.out.println("Обратный порядок");
        int max4 = 15;
        for (int i = 1, j = max4; i <= max4; i++, j--) {
            System.out.println(i + " - " + j);
        }

        System.out.println("Цикл с накапливанием");
        int max5 = 10;
        int res = 0;
        for (int i = 1; i <= max5; i++) {
            System.out.print(res + " + " + i + " = ");
            res += i;
            System.out.println(res);
        }
        System.out.println(res);


        System.out.println("Цикл в цикле");
        int first = 5;
        int second = 5;
        for (int i = 2; i <= first; i++) {
            for (int j = 2; j <= second; j++) {
                System.out.print(j + " * " + i + " = " + i * j + "\t");
            }
            System.out.println("");
        }

        System.out.println("Метод line");
        line(5);
        line(10);

        System.out.println("Метод square");
        square(5);
        square(10);

        System.out.println("Цикл с continue");
        for (int i = 0; i < 30; i++) {
            if (i % 5 == 0) continue;
            System.out.println(i);
        }

        System.out.println("Цикл с break");
        int i = 0;
        for (; ; ) {
            if (i == 10) break;
            System.out.println(i++);
        }

        System.out.println("Цикл while простой");
        int j = 0;
        while (j < 10) {
            System.out.println(j++);
        }

        System.out.println("Метод checkString");
        System.out.println(checkString("Hello world")); // false — "world" > 3, но начинается с 'w' (строчной)
        System.out.println(checkString("Hello World")); // true  — оба слова > 3, оба с заглавной
        System.out.println(checkString("Hi there Java")); // true  — оба слова > 3, оба с заглавной
        System.out.println(checkString("Hi The End")); // true  — "The" > 3 и с заглавной, остальные короткие
        System.out.println(checkString("Hi the End")); // false — "the" > 3, но начинается со строчной 't'
    }
}
