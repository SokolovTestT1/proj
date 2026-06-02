package Course.arrays;

public class ADemo {
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
