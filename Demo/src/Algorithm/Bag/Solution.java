package Algorithm.Bag;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Clanner on 2018/1/13.
 */
public class Solution {

    public final int getBagMaxValue(Good[] goods, int n) {
        int sum = 0;
        int min = goods[0].getValue();
        int max = goods[0].getValue();
        for (int i = 1; i < goods.length; i++) {
            min = Math.min(goods[i].getValue(), min);
            max = Math.max(goods[i].getValue(), max);
        }
        //创建桶
        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < goods.length; i++) {
            bucket[goods[i].getValue() - min]++;//数在该桶的数量
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                goods[index++].setValue(i + min);
            }
        }

        for (int i = 0; i < n; i++) {
            sum += goods[i].getValue();
        }
        return sum;
    }


    //获取0，1背包问题最优解
    public final int get01BagMaxValue(Good[] goods, int MAX_WEIGHT) {
        int bags[][] = cal01MaxValue(goods, MAX_WEIGHT);
//        for (int i = 0;i < goods.length+1;i++){
//            for (int j = 0;j < MAX_WEIGHT+1;j++){
//                System.out.printf("%4d",bags[i][j]);
//            }
//            System.out.println();
//        }
        return bags[goods.length][MAX_WEIGHT];
    }

    //计算01背包最大价值
    private final int[][] cal01MaxValue(Good[] goods, int MAX_WEIGHT) {

        /**
         * bags[i][j]
         * i表示当前背包放入i个物品
         * j表示当前背包容量
         */
        int ROW = goods.length + 1;
        int WEIGHT = MAX_WEIGHT + 1;
        int bags[][] = new int[ROW][WEIGHT];

        //初始化背包,不放任何物品时背包价值为0
        for (int w = 1; w < WEIGHT; w++)
            bags[0][w] = 0;

        for (int i = 1; i < ROW; i++) {
            bags[i][0] = 0;//容量为0是价值为0
            for (int w = 1; w < WEIGHT; w++) {
                if (goods[i - 1].getWeight() <= w &&
                        (goods[i - 1].getValue() + bags[i - 1][w - goods[i - 1].getWeight()]) > bags[i - 1][w]) {
                    //如果当前物品容量小于背包容量，则将物品放进背包
                    //并且当前物品价值加上未添加该物品的背包价值大于相同容量但未添加该物品的价值
                    bags[i][w] = goods[i - 1].getValue() + bags[i - 1][w - goods[i - 1].getWeight()];
                } else {//如果当前物品容量大于背包容量，则当前背包价值等于上一个相同容量的背包价值
                    bags[i][w] = bags[i - 1][w];
                }
            }
        }

        return bags;
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
