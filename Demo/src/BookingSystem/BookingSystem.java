package BookingSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Clanner on 2017/10/15.
 * 订票系统
 */
public class BookingSystem {

    private List<Flight> list;

    private BookingSystem(List<Flight> list) {
        this.list = list;
    }

    public static class FlightBuilder {
        private List<Flight> list = new ArrayList<Flight>();
        private int flightId;//班次id
        private String flightName;
        private String startTime;//出发时间
        private int tickets;//票数
        private int price;//价格
        private Flight flight;

        public BookingSystem.FlightBuilder setFlightId(int flightId) {
            this.flightId = flightId;
            return this;
        }

        public BookingSystem.FlightBuilder setFlightName(String flightName) {
            this.flightName = flightName;
            return this;
        }

        public BookingSystem.FlightBuilder setStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public BookingSystem.FlightBuilder setTickets(int tickets) {
            this.tickets = tickets;
            return this;
        }

        public BookingSystem.FlightBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public BookingSystem.FlightBuilder createFlight() {
            flight = new Flight(flightId, flightName, startTime, tickets, price);
            return this;
        }

        /**
         * 添加班次
         */
        public BookingSystem.FlightBuilder addFlight() {
            list.add(flight);
            return this;
        }

        public BookingSystem build() {
            return new BookingSystem(list);
        }
    }

    /**
     * 移除班次
     *
     * @param flightId
     * @return
     */
    public boolean removeFlight(int flightId) {
        for (Flight f : list) {
            if (f.getFlightId() == flightId) {
                list.remove(f);
                return true;
            }
        }
        return false;
    }

    /**
     * 根据起始站和终点站获取班次
     *
     * @return
     */
    public List<Flight> getFlight(String flightName) {
        List<Flight> flights = new ArrayList<Flight>();
        for (Flight f : list) {
            if (f.getFlightName().equals(flightName)) {
                flights.add(f);
            }
        }
        return flights;
    }

    /**
     * 购买车票
     *
     * @param flightId  班次id
     * @param num       购买票数
     * @param window_id 窗口id
     */
    public synchronized void book(int flightId, int num, int window_id) {
        for (Flight f : list) {
            if (f.getFlightId() == flightId) {
                if (f.getTickets() < num) {
                    if (f.getTickets() == 0) {
                        list.remove(f);
                        System.out.println("该班次车票已全部卖完");
                    } else {
                        System.out.println("窗口" + window_id + ":您预购的票数为" + num + "剩余票数为" + f.getTickets() + "购买失败");
                    }
                    break;
                }
                f.setTickets(f.getTickets() - num);
                System.out.println("窗口:" + window_id + "卖出" + num + "张票，" + "班次" + flightId + "还剩" + f.getTickets() + "张票");
            }
        }
    }
}
