package Dispatch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Clanner on 2017/10/26.
 * 处理机调度
 */
public class Dispatch {
    private LinkedList<PCB> processQueue;
    private static final int TIME_SLICE = 5;
    private static final int MAX_NEED_TIME = 10;
    public static int currentTime = 0;

    private Dispatch() {
        processQueue = new LinkedList<PCB>();
    }

    public static final Dispatch getInstanec() {
        return Holder.instance;
    }

    private static final class Holder {
        private static final Dispatch instance = new Dispatch();
    }

    /**
     * 先来先服务
     */
    public void FCFS() {
        sortByArriveTime(processQueue);
        int currentTime = 0;
        int arriveTime;
        PCB process;
        Iterator<PCB> iter = processQueue.iterator();
        while (iter.hasNext()) {
            process = iter.next();
            arriveTime = process.getArriveTime();
            System.out.print("进程：" + process.getPid() + ",");
            System.out.print("到达时间：" + process.getArriveTime() + ",");
            System.out.print("需要时间:" + process.getNeedTime() + ",");

            if (arriveTime > currentTime)
                currentTime = arriveTime;
            System.out.print("开始时间：" + currentTime + ",");

            currentTime += process.getNeedTime();
            System.out.println("结束时间：" + currentTime);
            iter.remove();
        }
    }

    /**
     * 短作业优先
     */
    public void SJF() {
        sortByArriveTime(processQueue);
        PCB process, tempProcess;
        int arriveTime, needTime, minIndex, minNeedTime, currentTime = 0;

        while (!processQueue.isEmpty()) {

            process = processQueue.pollFirst();
            arriveTime = process.getArriveTime();
            needTime = process.getNeedTime();

            if (currentTime < arriveTime)
                currentTime = arriveTime;

            minIndex = -1;
            minNeedTime = MAX_NEED_TIME + 2;

            // 要执行进程时，挑选已到达的需要作业时间最短的进程
            for (int i = 0; i < processQueue.size(); i++) {
                tempProcess = processQueue.get(i);
                if (tempProcess.getArriveTime() > currentTime + needTime)
                    break;
                // 到达时间相同，挑选最短作业为当前作业
                if (tempProcess.getArriveTime() == arriveTime && tempProcess.getNeedTime() < needTime) {
                    processQueue.set(i, process);
                    process = tempProcess;
                    tempProcess = processQueue.get(i);
                    needTime = process.getNeedTime();
                }
                if (tempProcess.getNeedTime() < minNeedTime) {
                    minIndex = i;
                    minNeedTime = tempProcess.getNeedTime();
                }
            }
            // 将最短作业放入队首
            if (minIndex != -1) {
                tempProcess = processQueue.remove(minIndex);
                processQueue.addFirst(tempProcess);
            }

            System.out.print("进程：" + process.getPid() + ",到达时间：" + process.getArriveTime() + ",需要时间:"
                    + process.getNeedTime() + ",开始时间：" + currentTime + ",");
            currentTime += needTime;
            System.out.println("结束时间：" + currentTime);
        }

    }

    /**
     * 时间片轮转
     */
    public void RR() {
        sortByArriveTime(processQueue);

        PCB process;
        int currentTime = 0;
        int arriveTime;
        int needTime;

        while (!processQueue.isEmpty()) {
            process = processQueue.pollFirst();
            needTime = process.getNeedTime();
            arriveTime = process.getArriveTime();
            System.out.print("进程：" + process.getPid() + ",");
            System.out.print("到达时间：" + process.getArriveTime() + ",");
            System.out.print("还需要时间:" + process.getNeedTime() + ",");

            if (currentTime < arriveTime)
                currentTime = arriveTime;
            System.out.print("开始时间：" + currentTime + ",");

            if (TIME_SLICE < needTime) {
                currentTime += TIME_SLICE;
                System.out.println("进程中断时间：" + currentTime);
                process.setNeedTime(needTime - TIME_SLICE);
                for (int i = 0; i < processQueue.size(); i++) {
                    if (processQueue.get(i).getArriveTime() > currentTime) {
                        processQueue.add(i, process);
                        break;
                    } else if (i == processQueue.size() - 1) {
                        processQueue.add(process);
                        break;
                    }
                }
            } else {
                currentTime += needTime;
                System.out.println("结束时间：" + currentTime);
            }
        }

    }

    /**
     * 优先级调度
     */
    public void PSA() {
        sortByArriveTime(processQueue);
        PCB process, tempProcess;
        int arriveTime, needTime, runTime, currentTime = 0;
        while (!processQueue.isEmpty()) {
            process = processQueue.pollFirst();
            arriveTime = process.getArriveTime();

            if (currentTime < arriveTime)
                currentTime = arriveTime;

            for (int i = 0; i < processQueue.size(); i++) {
                needTime = process.getNeedTime();
                tempProcess = processQueue.get(i);
                if (tempProcess.getArriveTime() > currentTime + needTime)
                    break;
                // 当前进程执行至被高优先级进程抢占
                if (tempProcess.getPriority() < process.getPriority()) {
                    if (tempProcess.getArriveTime() != currentTime) {
                        processQueue.remove(i);
                        System.out.print("进程：" + process.getPid() + ",优先级：" + (int) process.getPriority() + ",到达时间："
                                + process.getArriveTime() + ",需要时间:" + process.getNeedTime() + ",开始时间：" + currentTime
                                + ",");
                        runTime = tempProcess.getArriveTime() - currentTime;
                        process.setNeedTime(needTime - runTime);
                        currentTime += runTime;
                        System.out.println("进程中断时间：" + currentTime);
                        processQueue.addFirst(process);
                        process = tempProcess;
                    } else {
                        processQueue.set(i, process);
                        process = tempProcess;
                        tempProcess = processQueue.get(i);
                        // needTime = process.getNeedTime();
                    }

                } else {
                    subSortByPriority(processQueue, 0, i + 1);
                }
            }

            System.out.print("进程：" + process.getPid() + ",优先级：" + (int) process.getPriority() + ",到达时间："
                    + process.getArriveTime() + ",需要时间:" + process.getNeedTime() + ",开始时间：" + currentTime + ",");
            currentTime += process.getNeedTime();
            System.out.println("结束时间：" + currentTime);
        }
    }

    /**
     * 高响应比
     */
    public void HRRN() {
        sortByArriveTime(processQueue);
        PCB process, tempProcess;
        int arriveTime, needTime, maxIndex, currentTime = 0;
        double respRatio, maxPriority = 0;
        List<Thread> threadList = new ArrayList<>();
        final Object lock = new Object();

        long now = System.currentTimeMillis();
        while (!processQueue.isEmpty()) {

            process = processQueue.pollFirst();
            arriveTime = process.getArriveTime();
            needTime = process.getNeedTime();

            if (currentTime < arriveTime)
                currentTime = arriveTime;

            maxIndex = -1;
            maxPriority = -1;
            // 当前进程执行完后，挑选已到达的响应比最高的进程
            for (int i = 0; i < processQueue.size(); i++) {
                tempProcess = processQueue.get(i);
                if (tempProcess.getArriveTime() > currentTime + needTime)
                    break;
                //计算响应比respRatio
                respRatio = (currentTime + needTime - tempProcess.getArriveTime()) / (double) tempProcess.getNeedTime() + 1;
                tempProcess.setPriority(respRatio);
                if (respRatio > maxPriority) {
                    maxIndex = i;
                    maxPriority = respRatio;
                }
            }
            // 将响应比最高的进程放入队首
            if (maxIndex != -1) {
                tempProcess = processQueue.remove(maxIndex);
                processQueue.addFirst(tempProcess);
            }

            System.out.print("进程：" + process.getPid() + ",响应比：" + process.getPriority() + ",到达时间："
                    + process.getArriveTime() + ",需要时间:" + process.getNeedTime() + ",开始时间：" + currentTime + ",");
            threadList.add(new Working(process.getPid(), now, currentTime, process.getNeedTime(), lock));
            currentTime += needTime;
            System.out.println("结束时间：" + currentTime);
        }

        for (Thread t:threadList){
            t.start();
        }
    }

    public void addProcess(int pid, int arriveTime, int needTime) {
        PCB process = new PCB(pid, arriveTime, needTime);
        processQueue.push(process);
    }

    public void addProcess(int pid, int arriveTime, int needTime,int priority) {
        PCB process = new PCB(pid, arriveTime, needTime,priority);
        processQueue.push(process);
    }

    /**
     * 对进程队列按到达时间排序
     *
     * @param processQueue
     */
    private <T> void sortByArriveTime(LinkedList<PCB> processQueue) {
        processQueue.sort((p1, p2) -> {
            Integer p1Time = p1.getArriveTime();
            Integer p2Time = p2.getArriveTime();
            return p1Time.compareTo(p2Time);
        });
    }

    /**
     * 对指定子队列按优先级排序
     *
     * @param processQueue
     * @param fromIndex
     * @param toIndex
     */
    private void subSortByPriority(LinkedList<PCB> processQueue, int fromIndex, int toIndex) {
        List<PCB> subQueue = processQueue.subList(fromIndex, toIndex);
        subQueue.sort((p1, p2) -> {
            Double p1Priority = p1.getPriority();
            Double p2Priority = p2.getPriority();
            return p1Priority.compareTo(p2Priority);
        });
    }
}
