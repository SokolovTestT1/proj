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
        System.out.println(x+" + "+y+" = "+sum);
        System.out.println(var2);
    }
}
