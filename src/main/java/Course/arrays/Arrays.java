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

class ADemo {
    public static void main(String[] args) {
        int[] days = new int[30];

        int min = days[0];
        for (int i = 1; i < days.length; i++) {
            if (days[i] < min) {
                min = days[i];
                }
        }
        System.out.println(min);

        int[] arr = new int[10];
        System.out.println("Array length: " + arr.length);
        arr[0] = 777;
        System.out.println("First element: " + arr[0]); // 0 by default
        System.out.println("Last element: " + arr[arr.length - 1]); // 0 by default
        System.out.println("------------");

        char[] arr2 = {'A', 'B', 'C', 'D'};
        System.out.println("Array length: " + arr2.length);
        System.out.println("First element: " + arr2[0]);
        System.out.println("Last element: " + arr2[arr2.length - 1]);
        System.out.println("------------");

        String[] arr3 = new String[5];
        System.out.println("Array length: " + arr3.length);
        System.out.println("First element: " + arr3[0]);
        System.out.println("Last element: " + arr3[arr3.length - 1]);
        System.out.println("------------");
        System.out.println(arr3[10]); // ArrayIndexOutOfBoundsException
    }
}


class AMethods {

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