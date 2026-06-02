package Course.arrays;

import java.util.Random;
/**
 * Класс Arrays — демонстрация основ работы с массивами в Java.
 *
 * Массив — это структура данных, которая хранит фиксированное количество элементов одного типа.
 * Элементы массива хранятся в непрерывной области памяти и доступ к ним осуществляется по индексу.
 * Индексы начинаются с 0.
 */
public class Arrays {

    public static void main(String[] args) {
        // ========================================
        // 1. ОБЪЯВЛЕНИЕ И ИНИЦИАЛИЗАЦИЯ МАССИВОВ
        // ========================================

        // Объявление массива (без выделения памяти)
        int[] numbers;

        // Выделение памяти (создание массива на 5 элементов)
        numbers = new int[5];

        // Объявление + инициализация за один шаг
        int[] scores = new int[10];

        // Инициализация с заданными значениями
        int[] primes = {2, 3, 5, 7, 11, 13};

        // Массив строк
        String[] names = {"Анна", "Иван", "Сергей", "Мария"};

        // Массив объектов
        double[] temperatures = {36.6, -5.0, 23.4, 100.0};

        // ========================================
        // 2. ДОСТУП К ЭЛЕМЕНТАМ МАССИВА
        // ========================================

        // Запись значений
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // Чтение значений
        System.out.println("Первый элемент: " + numbers[0]); // 10
        System.out.println("Последний элемент: " + numbers[4]); // 50

        // Изменение значения
        numbers[2] = 999;
        System.out.println("Третий элемент после изменения: " + numbers[2]); // 999

        // ========================================
        // 3. ПРОХОД ПО МАССИВУ (ЦИКЛЫ)
        // ========================================

        // С помощью обычного for (по индексу)
        System.out.println("\n=== Проход по массиву через for ===");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        // С помощью for-each (усиленный цикл)
        System.out.println("\n=== Проход через for-each ===");
        for (int value : numbers) {
            System.out.println("Значение: " + value);
        }

        // Пример с массивом строк
        System.out.println("\n=== Имена сотрудников ===");
        for (String name : names) {
            System.out.println("Привет, " + name + "!");
        }

        // ========================================
        // 4. СВОЙСТВО .length
        // ========================================

        System.out.println("\nДлина массива numbers: " + numbers.length); // 5
        System.out.println("Длина массива names: " + names.length); // 4

        // Важно: length — это поле, а не метод (не пишем length())
        // Это НЕ строка! У строк length() — это метод.

        // Пример: поиск максимального элемента
        int[] data = {5, -3, 10, 8, 1};
        int max = data[0]; // предполагаем, что первый — максимальный

        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        System.out.println("Максимальное значение: " + max);

        // ========================================
        // 5. ДВУМЕРНЫЕ МАССИВЫ (МАТРИЦЫ)
        // ========================================

        // Двумерный массив — таблица (строки и столбцы)
        int[][] matrix = new int[3][4]; // 3 строки, 4 столбца

        // Заполнение матрицы
        int value = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value++;
            }
        }

        // Вывод матрицы
        System.out.println("\n=== Двумерный массив (матрица) ===");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]); // форматированный вывод
            }
            System.out.println(); // новая строка
        }

        // Необязательно все строки одной длины («зубчатые» массивы)
        int[][] jaggedArray = {
                {1, 2},
                {3, 4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("\n=== Зубчатый массив ===");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }

        // ========================================
        // 6. ПОИСК В МАССИВЕ
        // ========================================

        int target = 30;
        boolean found = false;
        int index = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                found = true;
                index = i;
                break; // выходим при первом совпадении
            }
        }

        if (found) {
            System.out.println("Элемент " + target + " найден по индексу: " + index);
        } else {
            System.out.println("Элемент " + target + " не найден.");
        }

        // ========================================
        // 7. КОПИРОВАНИЕ МАССИВОВ
        // ========================================

        int[] original = {1, 2, 3, 4, 5};
        int[] copy = new int[original.length];

        // Копирование вручную
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }

        // Или с помощью System.arraycopy()
        int[] copy2 = new int[original.length];
        System.arraycopy(original, 0, copy2, 0, original.length);

        // Или через clone()
        int[] copy3 = original.clone();

        // Печать копии
        System.out.println("\nКопия массива: ");
        for (int x : copy) {
            System.out.print(x + " ");
        }
        System.out.println();

        // ========================================
        // 8. ВАЖНЫЕ ОШИБКИ И ОГРАНИЧЕНИЯ
        // ========================================

        // ❌ Ошибка: выход за границы массива
        // System.out.println(numbers[10]); // ArrayIndexOutOfBoundsException

        // ✅ Проверка перед доступом:
        int safeIndex = 10;
        if (safeIndex >= 0 && safeIndex < numbers.length) {
            System.out.println("Значение: " + numbers[safeIndex]);
        } else {
            System.out.println("Индекс " + safeIndex + " выходит за границы массива!");
        }

        // Массивы нельзя сравнить через == или equals() напрямую
        // Они сравниваются по ссылке, а не по содержимому!
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println("a == b? " + (a == b)); // false — разные объекты

        // Для сравнения содержимого используйте Arrays.equals()
        // (но для этого нужно import java.util.Arrays)

        // ========================================
        // 9. ПОЛЕЗНЫЕ СОВЕТЫ
        // ========================================
        /*
         * - Размер массива фиксирован при создании.
         * - Если нужен динамический размер — используйте ArrayList.
         * - Массивы — это объекты, хранятся в куче (heap).
         * - Все элементы автоматически инициализируются (0 для int, null для объектов и т.д.).
         * - Массив может быть пустым: new int[0], но не null.
         * - null-массив нельзя использовать без проверки:
         *   if (arr != null) { ... }
         */

        // Пример инициализации по умолчанию
        int[] empty = new int[3]; // [0, 0, 0]
        String[] emptyStr = new String[2]; // [null, null]

        System.out.println("\nПо умолчанию: empty[0] = " + empty[0]);
        System.out.println("emptyStr[0] = " + emptyStr[0]);

        // ========================================
        // ЗАКЛЮЧЕНИЕ
        // ========================================
        System.out.println("\n✅ Массивы — основа для работы с данными в Java.");
        System.out.println("Используются в алгоритмах, коллекциях, GUI, играх, обработке файлов и т.д.");
    }
}


