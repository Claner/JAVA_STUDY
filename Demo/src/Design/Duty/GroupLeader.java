package Design.Duty;

/**
 * Created by Clanner on 2017/11/6.
 * 组长
 */
public class GroupLeader extends Leader {

    public GroupLeader(Leader nextLeader) {
        this.nextHandler = nextLeader;
    }

    @Override
    protected int limit() {
        return 1000;
    }

    @Override
    protected void handle(int money) {
        System.out.println("组长批复报账" + money + "元");
    }
}
