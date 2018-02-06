package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
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

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) return null;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < in.length; i++) map.put(in[i], i);
        return preIn(pre, 0, pre.length - 1, 0, map);
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) return result;
        int n = matrix.length, m = matrix[0].length;
        if (m == 0) return result;
        int layers = (Math.min(n, m) - 1) / 2 + 1;//这个是层数
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < m - i; k++) result.add(matrix[i][k]);//左至右
            for (int j = i + 1; j < n - i; j++) result.add(matrix[j][m - i - 1]);//右上至右下
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--) result.add(matrix[n - i - 1][k]);//右至左
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--) result.add(matrix[j][i]);//左下至左上
        }
        return result;
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int index;
        int target = popA[0];
        for (index = pushA.length - 1; index > -1; index--) {
            if (pushA[index] == target) break;
        }
        for (int i = 1; i < popA.length; i++) {
            if (popA[i] != pushA[index--]) return false;
        }
        return false;
    }

    /**
     * 根据前序和后序重构二叉树
     */
    private TreeNode preIn(int[] p, int pi, int pj, int ni, java.util.HashMap<Integer, Integer> map) {
        if (pi > pj) return null;
        TreeNode head = new TreeNode(p[pi]);
        int index = map.get(p[pi]);
        head.setLeft(preIn(p, pi + 1, pi + index - ni, ni, map));
        head.setRight(preIn(p, pi + index - ni + 1, pj, index + 1, map));
        return head;
    }

    /**
     * 返回一个数的二进制数1的个数
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            System.out.println(n);
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public double Power(double base, int exponent) {
        double temp = 1;
        int n;
        if (exponent < 0) n = -exponent;
        else n = exponent;
        for (int i = 1; i <= n; i++) {
            temp = temp * base;
            if (temp > 1.7976931348623157E308) return -1;//已经超出double类型的取值范围
        }
        if (exponent < 0) temp = 1.0 / temp;
        return temp;
    }


    public void reOrderArray(int[] array) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        int index = 0;
        for (int i = array.length - 1; i > -1; i--) {
            if (array[i] % 2 != 0) {
                stack1.push(array[i]);
            } else {
                stack2.push(array[i]);
            }
        }

        while (!stack1.isEmpty()) array[index++] = stack1.pop();
        while (!stack2.isEmpty()) array[index++] = stack2.pop();
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
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
