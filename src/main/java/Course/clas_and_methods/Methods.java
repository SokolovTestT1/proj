package Course.clas_and_methods;

public class Methods {
    public static void main(String[] args) {
        int num = sum(2,3);
        num = sum(num,5);
        System.out.println("num = " + num);
        helloName("Dima");
        System.out.println(isLowerCase('a'));
        System.out.println(isLowerCase('A'));

        System.out.println(toUpperCase('q'));
    }
    public static int sum(int x, int y){
        int result = x + y;
        return result;
    }
    public static void helloName(String name){
        System.out.println("Hello " + name);
    }
    public static boolean isLowerCase(char ch){
        return ch >= 'a' && ch <= 'z';
    }
    public static char toUpperCase(char ch){
        int diff = 'a' - 'A'; // находим разницу в кодах маленьких и больших букв
        int res = ch - diff; // уменьшаем код буквы на разницу, чтобы получить код большой буквы
        return (char) res; // получанную букву приводим к типу char и возвращаем
    }
}
