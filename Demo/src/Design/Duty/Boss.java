package Design.Duty;

/**
 * Created by Clanner on 2017/11/6.
 * 老板
 */
public class Boss extends Leader {
    @Override
    protected int limit() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected void handle(int money) {
        System.out.println("老板批复报账" + money + "元");
    }
}
