package Course.arrays;

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

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        //int[] array2 = array;
        //array2[0] = 100;
        System.out.println(array[0]);
        System.out.println(contains(array, 1));
        System.out.println(contains(array, 100));

        System.out.println(findLastAWord(new String[] {"Apple", "Banana", "Avocado"}));
    }
}
