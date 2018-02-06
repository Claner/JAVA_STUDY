package Algorithm.Matrix;

/**
 * Created by Clanner on 2018/1/12.
 */
public class Solution {

    //计算两个矩阵的乘积
    public int[][] matrixMultiply(int[][] a, int[][] b) {
        if (a.length != b[0].length) return null;
        int row_a = a.length;
        int col_a = a[0].length;
        int col_b = b[0].length;

        int c[][] = new int[row_a][col_b];
        for (int i = 0; i < row_a; i++) {
            for (int j = 0; j < col_b; j++) {
                int sum = a[i][0] * b[0][j];
                for (int k = 1; k < col_a; k++) {
                    c[i][j] = sum += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    //计算矩阵连乘最优解
    public int matrixChain(Matrix[] matrices) {
        int n = matrices.length;
        int[][] m = new int[n][n];
        int[] p = new int[matrices.length + 1];
        p[0] = matrices[0].getRow();
        for (int i = 0; i < n; i++) p[i + 1] = matrices[i].getCol();

        for (int i = 0; i < n; i++) {
            int col = i + 1;
            for (int row = 0; row < n - i - 1; row++, col++) {
                m[row][col] = m[row + 1][col] + p[row] * p[row + 1] * p[col + 1];

                for (int a = row + 1; a < col; a++) {
                    int t = m[row][a] + m[a + 1][col] + p[row] * p[a + 1] * p[col + 1];
                    if (t < m[row][col]) m[row][col] = t;
                }
            }
        }
//        for (int i = 0;i < n;i++){
//            for (int j = 0;j < n;j++){
//                System.out.printf("%8d",m[i][j]);
//            }
//            System.out.println();
//        }
        return m[0][n - 1];
    }

    private Solution(){}

    public static final Solution getInstance() {
        return Holder.instance;
    }

    private static final class Holder {
        private static final Solution instance = new Solution();
    }
}
