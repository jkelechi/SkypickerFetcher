package rhxnet;

import org.joda.time.DateTime;
import rhxnet.skypicker.RestApi;
import rhxnet.skypicker.pojo.response.Flight;
import rhxnet.skypicker.pojo.response.Flights;

import java.text.SimpleDateFormat;
import java.util.List;

public class AirfareChecker {
    private static final SimpleDateFormat DATE_FORMAT_DAY = new SimpleDateFormat("dd/MM/yyyy");

    private final RestApi restApi;

    public AirfareChecker(RestApi restApi) {
        this.restApi = restApi;
    }

    public Flight findCheapestFlight(String from, String destination) {
        Flight result = null;
        Float cheapestPrice = Float.MAX_VALUE;
        for (int i = 1; i <= 6 ; i++) {
            Flight flight = findCheapestFlight(from, destination, i * 30, 14, 18, 22, 4);
            if (flight != null) {
                if (cheapestPrice.compareTo(flight.price) > 0) {
                    cheapestPrice = flight.price;
                    result = flight;
                }
            }
        }
        return result;
    }

    private Flight findCheapestFlight(String from, String to, Integer departureInDays, Integer departureRangeInDays,
                                     Integer daysInDestinationFrom, Integer daysInDestinationTo, Integer passengers) {
        DateTime today = new DateTime();
        DateTime departureFrom = today.plusDays(departureInDays);
        DateTime departureTo = today.plusDays(departureInDays + departureRangeInDays);

        Flights flights = restApi.getFlights(from, to, DATE_FORMAT_DAY.format(departureFrom.toDate()),
                DATE_FORMAT_DAY.format(departureTo.toDate()), daysInDestinationFrom, daysInDestinationTo, passengers,
                1);
        final List<Flight> data = flights.data;

        if ((data != null) && (data.size() > 0)) {
            return data.get(0);
        }
        return null;

    }
}
