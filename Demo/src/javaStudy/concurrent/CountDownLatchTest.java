package javaStudy.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Clanner on 2018/2/9.
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            c.countDown();
            System.out.println(2);
            c.countDown();
        }).start();
        c.await();
        System.out.println(3);
    }
}
