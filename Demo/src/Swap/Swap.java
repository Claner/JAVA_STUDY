package Swap;

/**
 * Created by Clanner on 2017/10/30.
 */
public class Swap {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;

        swap1(a, b);
        swap2(a, b);
        swap3(a, b);
    }

    public static final void swap1(int a, int b) {
        int temp = b;
        b = a;
        a = temp;
        System.out.println("a " + a);
        System.out.println("b " + b);
    }

    public static final void swap2(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a " + a);
        System.out.println("b " + b);
    }

    public static final void swap3(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a " + a);
        System.out.println("b " + b);
    }
}
