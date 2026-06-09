package Course.oop;

public class A {
    String str;
    A(String str){
        this.str = str;
    }
    void print(){
        System.out.println("A " + str);
    }
    void print(int x){
        for(int i = 0; i < x; i++){
            this.print();
        }
    }

    @Override
    public String toString() {
        return "A{" +
                "str='" + str + '\'' +
                '}';
    }
}
