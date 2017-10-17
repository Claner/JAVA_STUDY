package BookingSystem;

import java.awt.print.Book;

/**
 * Created by Clanner on 2017/10/15.
 */
public class Window1 extends Thread {
    @Override
    public void run() {
        while (BookingSystem.getTickets() > 0) {
            if (BookingSystem.getTickets() > 0){
                BookingSystem.sell(1);
            }
        }
    }
}
