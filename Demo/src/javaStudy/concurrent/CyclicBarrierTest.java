package javaStudy.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Clanner on 2018/2/9.
 */
public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                c.await();//到达屏障，执行await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();
        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
