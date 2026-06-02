package Course.arrays;

import java.util.Random;

public class AMethods {

    public static void main(String[] args) {
        // Исходный массив
        int[] numbers = {5, 2, 8, 1, 9, 3};

        // ========================================
        // 1. Вывод массива: Arrays.toString()
        // ========================================
        // ❌ System.out.println(numbers); // выведет ссылку, например: [I@7c30a502
        // ✅ Используем Arrays.toString()

        System.out.println("Массив: " + java.util.Arrays.toString(numbers));
        // Вывод: [5, 2, 8, 1, 9, 3]

        // Для многомерных массивов используйте Arrays.deepToString()
        int[][] matrix = {{1, 2}, {3, 4}};
        System.out.println("Матрица: " + java.util.Arrays.deepToString(matrix));
        // Вывод: [[1, 2], [3, 4]]

        // ========================================
        // 2. Сортировка: Arrays.sort()
        // ========================================
        // Сортирует массив по возрастанию (использует алгоритм Dual-Pivot Quicksort)
        java.util.Arrays.sort(numbers);
        System.out.println("После сортировки: " + java.util.Arrays.toString(numbers));
        // Вывод: [1, 2, 3, 5, 8, 9]

        // Сортировка части массива: sort(массив, от, до)
        int[] data = {10, 5, 8, 1, 6, 3};
        java.util.Arrays.sort(data, 1, 4); // сортируем индексы [1, 2, 3] → элементы: 5,8,1
        System.out.println("Частичная сортировка: " + java.util.Arrays.toString(data));
        // Вывод: [10, 1, 5, 8, 6, 3]

        // ========================================
        // 3. Поиск: Arrays.binarySearch()
        // ========================================
        // ⚠️ Массив ДОЛЖЕН быть отсортирован перед использованием binarySearch!
        int[] sorted = {1, 3, 5, 7, 9, 11};
        int index = java.util.Arrays.binarySearch(sorted, 7);
        System.out.println("Индекс элемента 7: " + index); // 3

        // Если элемент не найден — возвращается отрицательное число
        int notFound = java.util.Arrays.binarySearch(sorted, 4);
        System.out.println("Поиск 4: " + notFound); // -3 → означает, что 4 можно вставить на позицию 2

        // ========================================
        // 4. Сравнение массивов: Arrays.equals()
        // ========================================
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        int[] c = {3, 2, 1};

        System.out.println("a == b? " + (a == b));           // false (сравнение ссылок)
        System.out.println("a equals b? " + java.util.Arrays.equals(a, b)); // true (сравнение содержимого)
        System.out.println("a equals c? " + java.util.Arrays.equals(a, c)); // false

        // Для многомерных массивов: Arrays.deepEquals()
        int[][] m1 = {{1, 2}, {3, 4}};
        int[][] m2 = {{1, 2}, {3, 4}};
        System.out.println("m1 deepEquals m2? " + java.util.Arrays.deepEquals(m1, m2)); // true

        // ========================================
        // 5. Заполнение массива: Arrays.fill()
        // ========================================
        int[] arr = new int[5];
        java.util.Arrays.fill(arr, 7); // заполняем весь массив значением 7
        System.out.println("Заполненный массив: " + java.util.Arrays.toString(arr));
        // Вывод: [7, 7, 7, 7, 7]

        // Заполнение части массива
        java.util.Arrays.fill(arr, 1, 4, 9); // заполнить индексы [1,2,3] значением 9
        System.out.println("Частичное заполнение: " + java.util.Arrays.toString(arr));
        // Вывод: [7, 9, 9, 9, 7]

        // ========================================
        // 6. Копирование: Arrays.copyOf() и Arrays.copyOfRange()
        // ========================================

        // Копия с новой длиной
        int[] original = {10, 20, 30};
        int[] copy = java.util.Arrays.copyOf(original, 5); // копируем, длина = 5
        System.out.println("Расширенная копия: " + java.util.Arrays.toString(copy));
        // Вывод: [10, 20, 30, 0, 0] → новые элементы = 0

        // Копия с уменьшением
        int[] shorter = java.util.Arrays.copyOf(original, 2);
        System.out.println("Укороченная копия: " + java.util.Arrays.toString(shorter));
        // Вывод: [10, 20]

        // Копирование диапазона
        int[] range = java.util.Arrays.copyOfRange(original, 1, 3); // [1, 3) → индексы 1 и 2
        System.out.println("Диапазон [1,3): " + java.util.Arrays.toString(range));
        // Вывод: [20, 30]

        // ========================================
        // 7. Генерация массива (пример с Random)
        // ========================================
        Random rand = new Random();
        int[] randomArray = new int[10];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rand.nextInt(100); // случайное число от 0 до 99
        }

        System.out.println("Случайный массив: " + java.util.Arrays.toString(randomArray));

        // Сразу сортируем и выводим
        java.util.Arrays.sort(randomArray);
        System.out.println("Отсортированный: " + java.util.Arrays.toString(randomArray));

        // ========================================
        // 8. Поиск минимума и максимума (вручную, т.к. в Arrays нет таких методов)
        // ========================================
        int min = randomArray[0];
        int max = randomArray[0];

        for (int value : randomArray) {
            if (value < min) min = value;
            if (value > max) max = value;
        }

        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);

        // ========================================
        // 9. ПОМНИТЕ: У МАССИВА НЕТ МЕТОДОВ!
        // ========================================
        /*
         * ❌ Так нельзя:
         *   numbers.sort();       // нет такого метода
         *   numbers.length();     // length — поле, не метод
         *
         * ✅ Правильно:
         *   Arrays.sort(numbers);
         *   int len = numbers.length; // без скобок!
         */

        // Также нельзя изменить размер массива после создания
        // Для динамического поведения — используйте ArrayList

        // ========================================
        // ЗАКЛЮЧЕНИЕ
        // ========================================
        System.out.println("\n✅ Основные методы java.util.Arrays:");
        System.out.println("• toString()     — красивый вывод");
        System.out.println("• sort()         — сортировка");
        System.out.println("• binarySearch() — быстрый поиск (в отсортированном!)");
        System.out.println("• equals()       — сравнение содержимого");
        System.out.println("• fill()         — заполнение");
        System.out.println("• copyOf()       — копирование с изменением размера");
        System.out.println("• copyOfRange()  — копирование части");

        System.out.println("\n💡 Совет: всегда импортируйте java.util.Arrays!");
    }
}
