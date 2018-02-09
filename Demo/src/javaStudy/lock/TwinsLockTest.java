package javaStudy.lock;

import java.util.concurrent.locks.Lock;

import static java.lang.Thread.sleep;

/**
 * Created by Clanner on 2018/2/7.
 */
public class TwinsLockTest {
    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        //启动十个线程
        for (int i = 0;i < 10;i++){
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        //每隔一秒换行
        for (int i = 0;i < 10;i++){
            sleep(1000);
            System.out.println();
        }
    }
}
