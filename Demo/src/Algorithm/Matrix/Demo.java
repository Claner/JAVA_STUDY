package Algorithm.Matrix;

import Algorithm.*;

/**
 * Created by Clanner on 2018/1/12.
 */
public class Demo {
    public static void main(String[] args) {
//        int[][] a = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        };
//        int[][] b = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9},
//                {10, 11, 12}
//        };
//        int[][] c = Solution.getInstance().matrixMultiply(a, b);
//        for (int i = 0; i < c.length; i++) {
//            for (int j = 0; j < c[0].length; j++) {
//                System.out.print(c[i][j] + ",");
//            }
//            System.out.println();
//        }
//
//
        Matrix[] matrices = {
                new Matrix(30, 35),
                new Matrix(35, 15),
                new Matrix(15, 5),
                new Matrix(5, 10),
                new Matrix(10, 20),
                new Matrix(20, 25)
        };
        System.out.println(Solution.getInstance().matrixChain(matrices));
    }
}
