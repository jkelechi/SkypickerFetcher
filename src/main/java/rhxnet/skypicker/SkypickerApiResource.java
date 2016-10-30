package rhxnet.skypicker;

import rhxnet.skypicker.pojo.response.Flights;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface SkypickerApiResource {

    @GET
    @Path("/flights?flyFrom={from}&to={to}&dateFrom={dateFrom}&dateTo={dateTo}" +
            "&daysInDestinationFrom={daysInDestinationFrom}&daysInDestinationTo={daysInDestinationTo}" +
            "&passengers={passengers}" +
            "&sort=price" +
            "&limit=5")
    @Produces(MediaType.APPLICATION_JSON)
    public Flights getFlights(@PathParam("from") String from,
                              @PathParam("to") String to,
                              @PathParam("dateFrom") String dateFrom,
                              @PathParam("dateTo") String dateTo,
                              @PathParam("daysInDestinationFrom") Integer daysInDestinationFrom,
                              @PathParam("daysInDestinationTo") Integer daysInDestinationTo,
                              @PathParam("passengers") Integer passengers);
}
