package Dispatch;

/**
 * Created by Clanner on 2017/10/26.
 * 进程控制块
 */
public class PCB {
    private int pid;
    private double priority;//响应比或优先级
    private int arriveTime;//到达时间
    private int needTime;//运行时间

    public PCB(int pid, int arriveTime, int needTime) {
        this.pid = pid;
        this.arriveTime = arriveTime;
        this.needTime = needTime;
    }

    public PCB(int pid, double priority, int arriveTime, int needTime) {
        this.pid = pid;
        this.priority = priority;
        this.arriveTime = arriveTime;
        this.needTime = needTime;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(int arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getNeedTime() {
        return needTime;
    }

    public void setNeedTime(int needTime) {
        this.needTime = needTime;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }
}
