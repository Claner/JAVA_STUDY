package BookingSystem;

/**
 * Created by Clanner on 2017/10/15.
 */
public class Window2 extends Thread{
    @Override
    public void run() {
        while (BookingSystem.getTickets() > 0){
            if (BookingSystem.getTickets() > 0){
                BookingSystem.sell(2);
            }
        }
    }
}
