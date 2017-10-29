package Dispatch;

/**
 * Created by Clanner on 2017/10/26.
 */
public class Working extends Thread {

    private long now;
    private int pid;
    private int runTime;
    private int startTime;
    private boolean ONCE = true;
    private final Object lock;

    public Working(int pid, long now, int startTime, int runTime, Object lock) {
        this.pid = pid;
        this.now = now;
        this.startTime = startTime;
        this.runTime = runTime;
        this.lock = lock;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (lock) {
                if ((System.currentTimeMillis() - now) / 1000 >= startTime) {
                    System.out.println("进程" + pid + "开始工作");
                    while (true) {
                        if ((System.currentTimeMillis() - now) / 1000 > runTime) {
                            System.out.println("进程" + pid + "完成工作");
                            lock.notifyAll();
                            break;
                        }
                    }
                    break;
                } else {
                    if (ONCE) {
                        System.out.println("还未到开始时间,进程" + pid + "等待");
                        ONCE = false;

                        try {
                            lock.wait();
                            System.out.println("锁住进程" + pid);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println("加锁失败,出现异常");
                        }
                    }
                }
            }
        }
    }
}
