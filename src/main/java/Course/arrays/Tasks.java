package Course.arrays;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Класс, реализующий базовые операции над целочисленными массивами.
 * Методы включают поиск, реверс, конкатенацию, вставку и фильтрацию элементов.
 */
public class Tasks {

    /**
     * Находит индекс первого вхождения элемента {@code x} в массиве.
     *
     * @param arr не {@code null} массив, в котором выполняется поиск
     * @param x   искомый элемент
     * @return индекс первого вхождения или {@code -1}, если элемент не найден
     */
    @Contract(pure = true)
    public static int findFirst(@NotNull int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Находит индекс последнего вхождения элемента {@code x} в массиве.
     *
     * @param arr массив, в котором выполняется поиск
     * @param x   искомый элемент
     * @return индекс последнего вхождения или {@code -1}, если элемент не найден
     */
    public static int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Возвращает элемент с максимальным по модулю значением.
     *
     * @param arr не {@code null} и не пустой массив
     * @return элемент с наибольшим абсолютным значением
     * @throws IllegalArgumentException если массив {@code null} или пустой
     */
    public static int maxAbs(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть null или пуст");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(max)) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Подсчитывает количество положительных элементов в массиве.
     *
     * @param arr массив для анализа
     * @return количество элементов, строго больше {@code 0}
     */
    public static int countPositive(int[] arr) {
        int count = 0;
        for (int value : arr) {
            if (value > 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Проверяет, является ли массив палиндромом.
     *
     * @param arr массив для проверки
     * @return {@code true}, если массив палиндром, {@code false} иначе
     */
    public static boolean isPalindrome(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * Разворачивает массив на месте (в обратном порядке).
     * Исходный массив изменяется.
     *
     * @param arr массив для реверса (не {@code null})
     */
    public static void reverse(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // нечего менять
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // обмен элементов
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    /**
     * Создаёт и возвращает новый массив с элементами в обратном порядке.
     * Исходный массив не изменяется.
     *
     * @param arr исходный массив (может быть {@code null})
     * @return новый массив с реверсированными элементами или {@code null}, если вход был {@code null}
     */
    public static int[] reverseBack(int[] arr) {
        if (arr == null) {
            return null;
        }

        int[] reversed = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }

        return reversed;
    }

    /**
     * Конкатенирует два массива в новый массив.
     *
     * @param arr1 первый массив (может быть {@code null}, тогда рассматривается как пустой)
     * @param arr2 второй массив (может быть {@code null}, тогда рассматривается как пустой)
     * @return новый массив, содержащий сначала все элементы {@code arr1}, затем {@code arr2}
     */
    public static int[] concat(int[] arr1, int[] arr2) {
        if (arr1 == null) arr1 = new int[0];
        if (arr2 == null) arr2 = new int[0];

        int[] result = new int[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);

        return result;
    }

    /**
     * Находит индексы всех вхождений элемента {@code x} в массиве.
     *
     * @param arr массив для поиска (может быть {@code null})
     * @param x   искомый элемент
     * @return массив индексов, где элемент равен {@code x}. Если вхождений нет — пустой массив.
     * Если {@code arr == null} — возвращается {@code new int[0]}.
     */
    public static int[] findAll(int[] arr, int x) {
        if (arr == null) {
            return new int[0];
        }

        // Сначала подсчитаем количество совпадений
        int count = 0;
        for (int value : arr) {
            if (value == x) {
                count++;
            }
        }

        // Если совпадений нет — возвращаем пустой массив
        if (count == 0) {
            return new int[0];
        }

        // Создаём результирующий массив нужного размера
        int[] result = new int[count];
        int index = 0;

        // Заполняем индексами вхождений
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result[index++] = i;
            }
        }

        return result;
    }

    /**
     * Удаляет все отрицательные элементы из массива.
     *
     * @param arr исходный массив (может быть {@code null})
     * @return новый массив без отрицательных элементов.
     * Если исходный массив {@code null} — возвращает {@code null}.
     * Если элементов ≥ 0 нет — возвращает пустой массив.
     */
    public static int[] deleteNegative(int[] arr) {
        if (arr == null) {
            return null;
        }

        // Считаем количество неотрицательных элементов
        int count = 0;
        for (int value : arr) {
            if (value >= 0) {
                count++;
            }
        }

        // Если таких элементов нет — возвращаем пустой массив
        if (count == 0) {
            return new int[0];
        }

        // Создаём новый массив и заполняем
        int[] result = new int[count];
        int index = 0;
        for (int value : arr) {
            if (value >= 0) {
                result[index++] = value;
            }
        }

        return result;
    }

    /**
     * Вставляет элемент {@code x} в массив на указанную позицию.
     * Создаёт новый массив, исходный не изменяется.
     *
     * @param arr исходный массив (не {@code null})
     * @param x   элемент для вставки
     * @param pos позиция вставки ({@code 0 ≤ pos ≤ arr.length})
     * @return новый массив увеличенной длины с добавленным элементом
     * @throws IllegalArgumentException если {@code arr == null}
     * @throws IndexOutOfBoundsException если {@code pos} вне допустимого диапазона
     */
    public static int[] add(int[] arr, int x, int pos) {
        if (arr == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        if (pos < 0 || pos > arr.length) {
            throw new IndexOutOfBoundsException("Позиция должна быть в диапазоне [0, arr.length]");
        }

        int[] result = new int[arr.length + 1];

        // Сначала копируем первые pos элементов
        System.arraycopy(arr, 0, result, 0, pos);

        // Вставляем x
        result[pos] = x;

        // Затем копируем оставшиеся элементы (с pos и далее)
        System.arraycopy(arr, pos, result, pos + 1, arr.length - pos);

        return result;
    }

    /**
     * Вставляет массив {@code ins} в массив {@code arr} на указанную позицию.
     * Создаёт новый массив, исходные не изменяются.
     *
     * @param arr исходный массив (не {@code null})
     * @param ins вставляемый массив (если {@code null}, treated as empty)
     * @param pos позиция вставки ({@code 0 ≤ pos ≤ arr.length})
     * @return новый массив с вставленным подмассивом
     * @throws IllegalArgumentException если {@code arr == null}
     */
    public static int[] add(int[] arr, int[] ins, int pos) {
        if (arr == null) {
            throw new IllegalArgumentException("Исходный массив не должен быть null");
        }
        if (ins == null) {
            ins = new int[0];
        }
        if (pos < 0 || pos > arr.length) {
            throw new IllegalArgumentException("Position must be between 0 and arr.length");
        }

        int[] result = new int[arr.length + ins.length];

        System.arraycopy(arr, 0, result, 0, pos);
        System.arraycopy(ins, 0, result, pos, ins.length);
        System.arraycopy(arr, pos, result, pos + ins.length, arr.length - pos);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] array = {1, -2, -7, 4, 2, 2, 5};
        System.out.println("Метод findFirst");
        System.out.println(findFirst(arr, 3));
        System.out.println(findFirst(arr, 6));

        System.out.println("\nМетод findLast");
        System.out.println(findLast(new int[]{1, 2, 3, 4, 2, 2, 5}, 2));

        System.out.println("\nМетод maxAbs");
        System.out.println(maxAbs(array));

        System.out.println("\nМетод countPositive");
        System.out.println(countPositive(array));

        System.out.println("\nМетод isPalindrome");
        System.out.println(isPalindrome(array));
        System.out.println(isPalindrome(new int[]{1, -2, -7, 4, -7, -2, 1}));

        System.out.println("\nМетод reverse");
        System.out.println("До: " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("После: " + Arrays.toString(arr));

        System.out.println("\nМетод reverseBack (новый массив)");
        int[] original = {1, 2, 3, 4, 5};
        System.out.println("Исходный: " + Arrays.toString(original));
        int[] reversedCopy = reverseBack(original);
        System.out.println("Новый (reverseBack): " + Arrays.toString(reversedCopy));
        System.out.println("Исходный после reverseBack: " + Arrays.toString(original));
        System.out.println("Это разные объекты? " + (original != reversedCopy));

        System.out.println("\nМетод concat");
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {7, 8, 9};
        System.out.println(Arrays.toString(concat(arr1, arr2)));

        System.out.println("\nМетод findAll");
        System.out.println(Arrays.toString(findAll(new int[]{1, 2, 3, 8, 2, 2, 9}, 2)));

        System.out.println("\nМетод deleteNegative");
        System.out.println(Arrays.toString(deleteNegative(new int[]{1, 2, -3, 4, -2, 2, -5})));

        System.out.println("\nМетод add (один элемент)");
        System.out.println(Arrays.toString(add(arr, 9, 3)));

        System.out.println("\nМетод add (массив)");
        System.out.println(Arrays.toString(add(arr, arr2, 3)));
    }
}