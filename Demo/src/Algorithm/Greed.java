package Algorithm;

/**
 *汽车加油问题
 */
public class Greed {
    public static void main(String[] args) {
        int[] d = {2,7,4,3};
        greedy(d,7,d.length-1);
    }

    /**
     *
     * @param d 加油站之间的距离
     * @param n 汽车加满油可以行走的距离
     * @param k 加油站的个数
     */
    public static void greedy(int d[], int n, int k) {
        int num = 0;
        for (int i = 0; i <= k; i++) {
            if (d[i] > n) {
                System.out.println("no solution");
                return;
            }
        }
        for (int i = 0, s = 0; i <= k; i++) {
            s += d[i];
            if (s > n) {
                num++;
                s = d[i];
            }
        }
        System.out.println(num);
    }
}
