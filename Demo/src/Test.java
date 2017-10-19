import Algorithm.Good;
import Algorithm.Util;
import BookingSystem.Window1;
import BookingSystem.Window2;
import FarExecuter.JavaClassExecuter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Clanner on 2017/4/28.
 * 0，1背包问题
 */
public class Test{
    private static Good[] goods = {new Good(50, 101), new Good(20, 100), new Good(30, 120)};
    private static final String MESSAGE="taobao";

    public static void main(String[] args) throws InterruptedException {
//        String str = "if (r >= num.text()){ C = 2.0*=pi*r;}\n";
//        Util.getInstance().lexicalAnalysis(str);

//        try {
//            InputStream is = new FileInputStream("d:\\TestClass.class");
//            byte[] b  = new byte[is.available()];
//            is.read(b);
//            is.close();
//
//            System.out.println(JavaClassExecuter.execute(b));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Window1 window1 = new Window1();
//        Window2 window2 = new Window2();
//        window1.start();
//        window2.start();

//        byte b1=1,b2=2,b3,b6;
//        final byte b4=4,b5=6;
//        b6=b4+b5;
//        b3= (byte) (b1+b2);
//        System.out.println(b3+b6);

//        Thread t = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.print("2");
//            }
//        });
//        t.start();
//
//        t.join();
//        System.out.print(Math.floor(-8.5));

        String a ="tao"+"bao";
        String b="tao";
        String c="bao";
        System.out.println(a==MESSAGE);
        System.out.println((b+c)==MESSAGE);
    }
}
