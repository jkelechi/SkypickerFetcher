package rhxnet.skypicker;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import feign.okhttp.OkHttpClient;
import rhxnet.Utils;
import rhxnet.skypicker.pojo.response.Flights;

public class RestApi {

    private static final java.util.logging.Logger logger = Utils.getLogger(RestApi.class.getName());

    private final static String BASE = "https://api.skypicker.com/";

    private SkypickerApiResource service = null;

    public RestApi() {
        final okhttp3.OkHttpClient httpClient = new okhttp3.OkHttpClient.Builder()
                .build();

        service = Feign.builder()
                .client(new OkHttpClient(httpClient))
                .contract(new JAXRSContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new CustomLogger(logger))
                .logLevel(Logger.Level.FULL)
                .target(SkypickerApiResource.class, BASE);
    }

    public Flights getFlights(String from, String to, String dateFrom, String dateTo, Integer daysInDestinationFrom,
                              Integer daysInDestinationTo, Integer passengers) {
        return service.getFlights(from, to, dateFrom, dateTo, daysInDestinationFrom, daysInDestinationTo, passengers);
    }

    public static class CustomLogger extends Logger {

        private final java.util.logging.Logger logger;

        public CustomLogger(java.util.logging.Logger logger) {
            this.logger = logger;
        }

        @Override
        protected void log(String configKey, String format, Object... args) {
            final String msg = String.format(methodTag(configKey) + format + "%n", args);
            if (logger != null) {
                logger.info(msg);
            }
        }
    }

}
