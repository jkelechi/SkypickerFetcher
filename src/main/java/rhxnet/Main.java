package rhxnet;

import rhxnet.skypicker.RestApi;
import rhxnet.skypicker.pojo.response.Flight;

import java.text.SimpleDateFormat;

public class Main {

    private static final SimpleDateFormat DATE_FORMAT_DAY = new SimpleDateFormat("dd/MM/yyyy");
    private static final Integer MONTH_DAYS = 30;

    public static final String FROM = "BTS,KSC,VIE,PRG,BUD,KRK,KTW";

    public static void main(String[] args) {

        final RestApi restApi = new RestApi();
        final AirfareChecker airfareChecker = new AirfareChecker(restApi);

//        findCheapest(airfareChecker, "Singapore");
//        findCheapest(airfareChecker, "Jakarta");
//        findCheapest(airfareChecker, "Denpasar");
        findCheapest(airfareChecker, "Kuala Lumpur");

    }

    private static void findCheapest(AirfareChecker airfareChecker, String destination) {
        Flight flight = airfareChecker.findCheapestFlight(FROM, destination);
        if (flight != null) {
            System.out.println(destination + "(" + flight.price / 4 + "): " + flight);
        }
    }
}
