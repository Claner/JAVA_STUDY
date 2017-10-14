/**
 * Created by Clanner on 2017/6/5.
 * 一次一步，
 * 一次两步
 * 走10级楼梯有几种走法
 */
public class Stairs {
    //走10级台阶
    private static final int size = 10;

    private static final int one = 1;//走第一级的放法数
    private static final int two = 2;//走第二级的方法数
    private static int i = 2;

    public static void main(String[] args) {
        System.out.println("一共有" + f(10) + "种走法");
    }

    public static final int f(int num) {
        int a = 1;//走1级楼梯的走法数
        int b = 2;//走2级楼梯的走法数
        int temp = 0;
        for (int i = 2; i < num; i++) {
            temp = a+b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
