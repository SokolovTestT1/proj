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
        System.out.println(var2);


        double d = Double.MAX_VALUE;
        System.out.println(d);

        byte b = 127;
        b++;
        System.out.println(b);

        int a = Integer.MIN_VALUE;
        a--;
        System.out.println("a = Integer.MIN_VALUE - 1 = " + a);


        double d1 = 1;
        double sum1 = d1 / 0;
        System.out.println("d1/0 = " + sum1);

        double d2 = 1;
        d2 = d2 / 98;
        System.out.println("d2 = " + d2);
        d2 = d2 * 98; // потеря данных из-за неточности
        System.out.println("d2 = " + d2);
    }
}
