package Dispatch;

/**
 * Created by Clanner on 2017/10/26.
 */
public class Test {
    public static void main(String[] args) {
        Dispatch dispatch = Dispatch.getInstanec();
        dispatch.addProcess(1, 0, 20);
        dispatch.addProcess(2, 5, 15);
        dispatch.addProcess(3, 10, 5);
        dispatch.addProcess(4, 15, 10);
//        dispatch.HRRN();//高响应比调度
//        dispatch.FCFS();//先来先服务调度
//        dispatch.SJF();//短作业优先调度
//        dispatch.RR();//时间片轮转调度
//        dispatch.PSA();//优先级调度
    }
}
