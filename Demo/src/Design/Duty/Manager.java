package Design.Duty;

/**
 * Created by Clanner on 2017/11/6.
 * 经理
 */
public class Manager extends Leader {

    public Manager(Leader nextLeader) {
        this.nextHandler = nextLeader;
    }

    @Override
    protected int limit() {
        return 10000;
    }

    @Override
    protected void handle(int money) {
        System.out.println("经理批复报账" + money + "元");
    }
}
