package rhxnet;

import org.joda.time.DateTime;
import rhxnet.skypicker.RestApi;
import rhxnet.skypicker.pojo.response.Flight;
import rhxnet.skypicker.pojo.response.Flights;

import java.text.SimpleDateFormat;

public class Main {

    private static final SimpleDateFormat DATE_FORMAT_DAY = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        RestApi restApi = new RestApi();

        DateTime today = new DateTime();
        DateTime tomorrow = today.plusDays(1);
        DateTime inTwoWeeks = today.plusDays(14);

        Flights flights = restApi.getFlights("PL,CZ,AT,HU", "Singapore", DATE_FORMAT_DAY.format(tomorrow.toDate()),
                DATE_FORMAT_DAY.format(inTwoWeeks.toDate()), 18, 22, 4);


        System.out.println("Currency: " + flights.currency);

        for (Flight flight : flights.data) {
            System.out.println("");
            System.out.print(flight.price / 4 + ": " + flight);
        }

    }
}
