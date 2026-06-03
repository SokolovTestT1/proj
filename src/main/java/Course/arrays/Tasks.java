package Course.arrays;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Tasks {
    @Contract(pure = true)
    public static int findFirst(int @NotNull [] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int maxAbs(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(max)) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int countPositive(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println("Метод findFirst");
        System.out.println(findFirst(new int[]{1, 2, 4, 3, 5}, 3));
        System.out.println(findFirst(new int[]{1, 2, 4, 3, 5}, 6));

        System.out.println("Метод findLast");
        System.out.println(findLast(new int[]{1, 2, 3, 4, 2, 2, 5}, 2));

        System.out.println("Метод maxAbs");
        System.out.println(maxAbs(new int[]{1, -2, -7, 4, 2, 2, 5}));

        System.out.println("Метод countPositive");
        System.out.println(countPositive(new int[]{1, -2, -7, 4, 2, 2, 5}));
    }
}
