package Algorithm;

import java.util.List;

/**
 * Created by Clanner on 2017/6/6.
 */
public class Bag {
    private List<Good> goodList;//物品
    private int max;//背包最大容量
    private int value;//背包的总价值
    private int num;//物品数量

    public Bag(List<Good> goodList, int max) {
        this.goodList = goodList;
        this.max = max;
    }

    public int getValue() {

        for (int i = 0, j = 0; i < max; i++) {
            if (i == goodList.get(j).getWeight()) {
                value += goodList.get(j++).getValue();
            }
            i++;
        }

        return value;
    }
}
