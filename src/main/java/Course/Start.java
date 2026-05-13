package Course;

public class Start {
    public static void main(String[] args) {
        int var1 = 1;
        String var2 = "Hello";
        int[] arr = new int[2];
        String var3 = null;
        // получаем исходные числа
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        // складываем
        int sum = x + y;
        // выводим
        System.out.println(x + " + " + y + " = " + sum);
        System.out.println("var2 = " + var2);


        double d = Double.MAX_VALUE;
        System.out.println("d = " + d);

        byte b = 127;
        b++;
        System.out.println("b = " + b);

        int a = Integer.MIN_VALUE;
        a--;
        System.out.println("a = Integer.MIN_VALUE - 1 = " + a);


        double d1 = 4;
        double sum1 = d1 / 2;
        System.out.println("d1/2 = " + sum1);

        double d2 = 1;
        d2 = d2 / 98;
        System.out.println("d2 = " + d2);
        d2 = d2 * 98; // потеря данных из-за неточности
        System.out.println("d2 = " + d2);

        int i = Integer.max(900,1000);
        System.out.println("i = " + i);

        System.out.println("Tasks.notEqual " + Tasks.notEqual(4,4,4));
    }
}
