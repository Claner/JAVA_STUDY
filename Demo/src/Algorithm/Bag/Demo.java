package Algorithm.Bag;

/**
 * Created by Clanner on 2018/1/13.
 */
public class Demo {
    public static void main(String[] args) {
        Good[] goods = new Good[5];
        goods[0] = new Good(2, 6);
        goods[1] = new Good(2, 3);
        goods[2] = new Good(6, 5);
        goods[3] = new Good(5, 4);
        goods[4] = new Good(4, 6);
        System.out.println(Solution.getInstance().get01BagMaxValue(goods, 10));
        System.out.println(Solution.getInstance().getBagMaxValue(goods, 5));
    }
}
