package Design.Duty;

/**
 * Created by Clanner on 2017/11/6.
 * 抽象领导者
 */
public abstract class Leader {

    //上一级领导处理者
    protected Leader nextHandler;

    //处理报账请求
    public final void handleRequest(int money) {
        if (money <= limit()) {
            handle(money);
        } else {
            nextHandler.handleRequest(money);
        }
    }

    //自身能批复的最大额度
    protected abstract int limit();

    //处理报账行为
    protected abstract void handle(int money);
}
