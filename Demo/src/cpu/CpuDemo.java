package cpu;

import java.util.Scanner;

/**
 * Created by Clanner on 2017/4/27.
 */
public class CpuDemo {
    public static void main(String[] args) {
        int size = 0;
        int max = 0;
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        int[] lArr = new int[size];
        for (int i = 0; i < size; i++) {
            lArr[i] = scanner.nextInt();
            max += lArr[i];
        }
        int[] dp = new int[max / 2 + 1];
        for (int i = 0; i < size; i++) {
            for (int j = max / 2; j >= lArr[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - lArr[i]] + lArr[i]);
            }
        }
        System.out.println(Math.max(dp[max /2],max - dp[max / 2]));
    }
}
