package javaStudy.concurrent;

/**
 * Created by Clanner on 2018/1/29.
 */
public class ConcurrencyTest {

    public static final long count = 1000000001;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    public static final void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i = 0; i < count; i++) {
                a += 5;
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency time:" + time + "ms,b=" + b);
    }

    public static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial time:" + time + "ms,b=" + b);
    }
}
