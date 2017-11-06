package Algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Clanner on 2017/11/3.
 */
public class Solution {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public boolean Find(int target, int[][] array) {
        int i = 0;//右上角横坐标
        int j = array[0].length - 1;//右上角纵坐标
        int temp;

        while (i < array.length && j >= 0) {
            temp = array[i][j];
            if (temp == target) return true;
            if (temp < target) {
                i++;
            } else if (temp > target) {
                j--;
            }
        }
        return false;
    }

    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 两个栈实现队列
     */
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int first = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return first;
    }

    //斐波那契数列
    public int Fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        int a = 1;
        int b = 1;
        int cur = 0;

        for (int i = 2; i < n; i++, a = b, b = cur) cur = a + b;
        return cur;
    }

    //一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int JumpFloor(int target) {
        if (target == 1) return 1;
        else if (target == 2) return 2;
        else return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int JumpFloorII(int target) {
        return 1 << --target;
    }

    //输出将帅的合法位置，只能用一个字节存储变量
    public void printAB() {
        byte i = 81;
        while (i-- != 0) {
            if (i / 9 % 3 == i % 9 % 3) continue;
            System.out.printf("A=%d,B=%d\n", i / 9 + 1, i % 9 + 1);
        }
    }

    private Solution() {
    }

    public static final Solution getInstance() {
        return Holder.instance;
    }

    private static final class Holder {
        private static final Solution instance = new Solution();
    }
}
