package Algorithm;

/**
 * 乘法表
 */
public class Mul {
    public static void main(String[] args) {
        work("bbbba");
    }

    public static final void work(String str) {

        int [][][] p = new int[str.length()][str.length()][3];
        int n = str.length();
        for (int i = 0;i < n;i++){
            p[i][i][str.charAt(i) - 'a'] = 1;
        }

        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                for (int t = i; t < j; t++) {
                    //字符串中第i个元素到第j个元素的子串表达式值为a的加括号方式数
                    p[i][j][0] += p[i][t][2] * p[t + 1][j][0] + p[i][t][0] * p[t + 1][j][2] + p[i][t][1] * p[t + 1][j][2];
                    //字符串中第i个元素到第j个元素的子串表达式值为b的加括号方式数
                    p[i][j][1] += p[i][t][0] * p[t + 1][j][0] + p[i][t][0] * p[t + 1][j][1] + p[i][t][1] * p[t + 1][j][1];
                    //字符串中第i个元素到第j个元素的子串表达式值为c的加括号方式数
                    p[i][j][2] += p[i][t][1] * p[t + 1][j][0] + p[i][t][2] * p[t + 1][j][1] + p[i][t][2] * p[t + 1][j][2];
                }
            }
        }
        System.out.println(p[0][n-1][0]);
    }
}
