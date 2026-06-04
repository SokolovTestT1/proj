package Course.oop;

import java.util.Arrays;
import java.util.Stack;

public class StackTest {
    static class Stack{
        int[] stack = new int[10];
        int cur;

        public void push(int x){
            stack[cur++] = x;
        }

        public int pop(){
            return stack[--cur];
        }
    }

    public static void main(String[] args) {
        Stack s1 = new Stack();
        Stack s2 = new Stack();

        s1.push(1);
        s2.push(2);
        s1.push(3);
        System.out.println(Arrays.toString(s1.stack));
        System.out.println(s1.pop());
    }


}
