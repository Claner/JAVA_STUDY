package BookingSystem;

/**
 * Created by Clanner on 2017/10/15.
 * 班次
 */
public class Flight {
    private final int flightId;//班次id
    private final String flightName;
    private final String startTime;//出发时间
    private int tickets;//票数
    private final int price;//价格

    public Flight(int flightId, String flightName, String startTime, int tickets, int price) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.startTime = startTime;
        this.tickets = tickets;
        this.price = price;
    }

    public int getFlightId() {
        return flightId;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int getPrice() {
        return price;
    }

    public String getFlightName() {
        return flightName;
    }

}
