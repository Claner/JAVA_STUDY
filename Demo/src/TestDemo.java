/**
 * Created by Clanner on 2017/11/2.
 */
public class TestDemo {
    public static String output = "";
    public static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            output += "2";
            return;
        } finally {
            output += "3";
        }
        output += "4";
    }

    public static void main(String[] args) throws InterruptedException {
//        foo(0);
//        foo(1);
//        System.out.println(output);

        final Object obj = new Object();
        Thread t1 = new Thread() {
            public void run() {
                synchronized (obj) {
                    try {
                        obj.wait();
                        System.out.println("Thread 1 wake up.");
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        t1.start();
        Thread.sleep(1000);//We assume thread 1 must start up within 1 sec.
        Thread t2 = new Thread() {
            public void run() {
                synchronized (obj) {
                    obj.notifyAll();
                    System.out.println("Thread 2 sent notify.");
                }
            }
        };
        t2.start();
    }
}
