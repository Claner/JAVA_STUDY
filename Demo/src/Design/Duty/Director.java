package Design.Duty;

/**
 * Created by Clanner on 2017/11/6.
 */
public class Director extends Leader{

    public Director(Leader leader) {
        this.nextHandler = leader;
    }

    @Override
    protected int limit() {
        return 5000;
    }

    @Override
    protected void handle(int money) {
        System.out.println("主管批复报账" + money + "元");
    }
}
