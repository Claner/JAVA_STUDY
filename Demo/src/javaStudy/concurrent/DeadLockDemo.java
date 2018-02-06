package javaStudy.concurrent;

/**
 * Created by Clanner on 2018/1/29.
 */
public class DeadLockDemo {

    public static final String LOCK_A = "A";
    public static final String LOCK_B = "B";

    public static void main(String[] args) {
        deadLock();
    }

    private static final void deadLock() {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK_A) {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK_B) {
                    System.out.println(1);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (LOCK_B) {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK_A) {
                    System.out.println(2);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
