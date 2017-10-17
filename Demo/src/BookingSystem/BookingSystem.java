package BookingSystem;

/**
 * Created by Clanner on 2017/10/15.
 */
public class BookingSystem {
    private static int tickets = 10000;

    public static synchronized void sell(int window_id) {
        tickets--;
        if (tickets > 0) System.out.println("窗口" + window_id + "卖出1张票， 剩余票数为," + tickets);
    }

    public static int getTickets() {
        return tickets;
    }
}
