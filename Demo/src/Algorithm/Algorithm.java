package Algorithm;

/**
 * Created by Clanner on 2018/1/3.
 * 算法
 */
public class Algorithm {
    public static void main(String[] args) {
//        System.out.println(fibonacci(6));
        System.out.println(method("((]]"));
    }

    //返回裴波那数列第n个数
    public static final int fibonacci(int n) {
        if (n <= 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static final boolean method(String string) {
        int aCount = 0;
        int bCount = 0;
        StringBuilder builder = new StringBuilder();
        for (char c : string.toCharArray()) {
            builder.append(c);
            switch (c) {
                case '(':
                    aCount++;
                    break;
                case ')':
                    aCount--;
                    break;
                case '[':
                    bCount++;
                    break;
                case ']':
                    bCount--;
                    break;
            }
        }



        if (aCount == 0 && bCount == 0) return true;
        else return false;
    }
}
