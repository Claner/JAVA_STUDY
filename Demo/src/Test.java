import Algorithm.Good;
import Algorithm.Util;
import BookingSystem.Window1;
import BookingSystem.Window2;
import FarExecuter.JavaClassExecuter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Clanner on 2017/4/28.
 * 0，1背包问题
 */
public class Test {
    private static Good[] goods = {new Good(50, 101), new Good(20, 100), new Good(30, 120)};

    public static void main(String[] args) {
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

        Window1 window1 = new Window1();
        Window2 window2 = new Window2();
        window1.start();
        window2.start();
    }
}
