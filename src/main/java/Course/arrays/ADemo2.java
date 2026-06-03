package Course.arrays;

import java.util.Arrays;

public class ADemo2 {
    //содержит ли массив определенное число
    public static boolean contains(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return true;
            }
        }
        return false;
    }

    //найти последнее слово, начинающееся с буквы A
    public static String findLastAWord(String[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].charAt(0) == 'A') {
                return arr[i];
            }
        }
        return null;
    }

    //поделить все элементы массива на 10
    public static void div10(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= 10;
        }
    }

    // если слово начинается с нижнего регистра, то перевести его в верхний регистр
    public static void upWords(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) >= 'a' && arr[i].charAt(0) <= 'z') arr[i] = arr[i].toUpperCase();
        }
    }

    //найти максимальный элемент массива
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // объединить все слова, составив их через пробел
    public static String concat(String[] arr) {
        String res = "";
        for (int i = 0; i < arr.length - 1; i++) {
            res += arr[i] + " ";
        }
        res += arr[arr.length - 1];
        return res;
    }

    //добавить элемент в конец массива
    public static int[] addLast(int[] arr, int x) {
        int[] res = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        res[arr.length] = x;
        return res;
    }

    //добавть в конец такие элементы второго массива, которых нет в первом
    public static int[] addUniq(int[] arr1, int[] arr2) {
        // заводим временный массив, по размеру как оба
        int[] tmp = new int[arr1.length + arr2.length];
        // элементы первого копируем без изменений
        for (int i = 0; i < arr1.length; i++) {
            tmp[i] = arr1[i];
        }
        //элементы второго добавляем, если их нет в первом
        // j двигается не каждую итерацию, а только когда надо
        int j = arr1.length;
        for (int i = 0; i < arr2.length; i++) {
            if (!contains(arr1, arr2[i])) {
                tmp[j++] = arr2[i];
            }
        }
        // делаем новый массив правильного размера и копируем в него значения из tmp
        int[] res = new int[j];
        for (int i = 0; i < j; i++) {
            res[i] = tmp[i];
        }
        return res;
    }

    //сложение элементов двухмерного массива
    public static int sum2d(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        //int[] array2 = array;
        //array2[0] = 100;
        System.out.println(array[0]);

        System.out.println("Метод contains");
        System.out.println(contains(array, 10));
        System.out.println(contains(array, 100));

        System.out.println("Метод findLastAWord");
        System.out.println(findLastAWord(new String[]{"Apple", "Banana", "Avocado"}));

        div10(array);
        System.out.println("После выполнения div10 -" + Arrays.toString(array));

        String[] arrS = {"Apple", "banana", "Avocado", "avocado", "Pineapple"};

        upWords(arrS);
        System.out.println("После выполнения upWords - " + Arrays.toString(arrS));
        System.out.println("Метод concat - " + concat(arrS));

        int[] arr2 = addLast(array, 1000);
        System.out.println("arr2 " + Arrays.toString(arr2));

        System.out.println("Метод addUniq");
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        System.out.println(Arrays.toString(addUniq(arr3, arr4)));

        int[][] arr2d = new int[5][3];
        arr2d[0][2] = 88;
        arr2d[3][0] = 91;
        arr2d[4][1] = 106;
        for (int i = 0; i < arr2d.length; i++) {
            System.out.println(Arrays.toString(arr2d[i]));
        }

        System.out.println("Сумма элементов массива " + sum2d(arr2d));

        System.out.println("\n=== ЗУБЧАТЫЙ (RAGGED) МАССИВ ===");
        // Создаём зубчатый массив: разная длина строк
        int[][] jaggedArray = {
                {1},                // 1 элемент
                {2, 3},             // 2 элемента
                {4, 5, 6},          // 3 элемента
                {7, 8, 9, 10},      // 4 элемента
                {11, 12}            // 2 элемента
        };

        System.out.println("Исходный зубчатый массив:");
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.println("Строка " + i + " (длина = " + jaggedArray[i].length + "): " + Arrays.toString(jaggedArray[i]));
        }

        System.out.println("\nТреугольный вывод по строкам:");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.printf("%4d", jaggedArray[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nПроверка длины строк:");
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.printf("jaggedArray[%d].length = %d%n", i, jaggedArray[i].length);
        }

        // Пример суммирования только по не пустым строкам
        int jaggedSum = 0;
        for (int[] row : jaggedArray) {
            for (int value : row) {
                jaggedSum += value;
            }
        }
        System.out.println("\nСумма всех элементов зубчатого массива: " + jaggedSum);
    }
}


