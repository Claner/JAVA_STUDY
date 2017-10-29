package BookingSystem;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Clanner on 2017/10/26.
 */
public class Demo {
    public static void main(String[] args) {
        BookingSystem.FlightBuilder flightBuilder = new BookingSystem.FlightBuilder();
        BookingSystem bookingSystem = flightBuilder
                .setFlightId(1)
                .setFlightName("和平-->广州")
                .setPrice(35)
                .setStartTime("7:00")
                .setTickets(400)
                .createFlight()
                .addFlight()
                .setFlightId(2)
                .setFlightName("和平-->广州")
                .setPrice(35)
                .setStartTime("8:30")
                .setTickets(40)
                .createFlight()
                .addFlight()
                .setFlightId(3)
                .setFlightName("和平-->广州")
                .setPrice(35)
                .setStartTime("12:30")
                .setTickets(40)
                .createFlight()
                .addFlight()
                .setFlightId(4)
                .setFlightName("和平-->广州")
                .setPrice(35)
                .setStartTime("15:00")
                .setTickets(40)
                .createFlight()
                .addFlight().build();

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        List<Flight> list = bookingSystem.getFlight(name);
        if (list != null && list.size() > 0) {
            StringBuilder builder = new StringBuilder();
            System.out.println("班次id    时间    剩票    价格");
            for (Flight f : list) {
                builder.append(f.getFlightId());
                builder.append("     ");
                builder.append(f.getStartTime());
                builder.append("     ");
                builder.append(f.getTickets());
                builder.append("     ");
                builder.append(f.getPrice());
                System.out.println(builder.toString());
                builder.setLength(0);
            }
        } else {
            System.out.println("班次不存在");
        }

        System.out.println("请输入班次id");
        int id = sc.nextInt();

        Random random = new Random();
        for (int i = 0; i < 100; i++)
            new Window(bookingSystem, 1 + random.nextInt(2), list.get(id-1).getFlightId(), 1 + random.nextInt(10)).start();

//        new Window(bookingSystem,1,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),2).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),7).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),8).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),2).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),7).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),8).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),2).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),7).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),8).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),2).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),7).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),8).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),2).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),7).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),8).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),2).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),7).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),8).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),2).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),7).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),8).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),2).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),7).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),8).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),2).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),7).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),8).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),2).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),3).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),7).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),5).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),1).start();
//        new Window(bookingSystem,1,list.get(id).getFlightId(),8).start();
//        new Window(bookingSystem,2,list.get(id).getFlightId(),3).start();
    }
}
