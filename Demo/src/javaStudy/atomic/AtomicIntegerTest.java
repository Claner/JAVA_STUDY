package javaStudy.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Clanner on 2018/2/9.
 */
public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}
