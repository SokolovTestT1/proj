package Course.oop;

public class Stack {
    int[] stack = new int[10];
    int cur;

    public void push(int x) {
        stack[cur++] = x;
    }

    public int pop() {
        return stack[--cur];
    }
}
