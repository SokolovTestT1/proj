package Course.conditions;

public class Tasks {
    public static int abs(int x){
        if(x<0){
            return -x;
        } else return x;
    }
    public static int safeDiv(int x, int y){
        if(y==0){
            return 0;
        } else return x/y;
    }
    public static int max(int x, int y){
        if(x>y){
            return x;
        } else return y;
    }
    public static String makeDecision(int x, int y){
        if(x>y){
            return x + " > " + y;
        } else return x + " < " + y;
    }
    public static int max3(int x, int y, int z) {
        if (y > x) {
            x = y;
        }
        if (z > x) {
            x = z;
        }
        return x;
    }
    public static void main(String[] args) {
        System.out.println("Метод abs");
        System.out.println(abs(-5));
        System.out.println(6);

        System.out.println("Метод safeDiv");
        System.out.println(safeDiv(5,0));
        System.out.println(safeDiv(10,5));

        System.out.println("Метод max");
        System.out.println(max(3,7));
        System.out.println(max(10,5));

        System.out.println("Метод makeDecision");
        System.out.println(makeDecision(5,7));
        System.out.println(makeDecision(10,5));

        System.out.println("Метод max3");
        System.out.println(max3(1,2,3));
        System.out.println(max3(10,5,1));
    }
}
