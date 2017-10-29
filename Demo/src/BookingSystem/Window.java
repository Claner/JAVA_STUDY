package BookingSystem;

import java.awt.print.Book;

/**
 * Created by Clanner on 2017/10/15.
 */
public class Window extends Thread {

    private int window_id;
    private int flightId;
    private int num;
    private BookingSystem bs;

    public Window(BookingSystem bs,int window_id, int flightId,int num) {
        this.bs = bs;
        this.window_id = window_id;
        this.flightId = flightId;
        this.num = num;
    }

    @Override
    public void run() {
        bs.book(flightId,num,window_id);
    }
}
