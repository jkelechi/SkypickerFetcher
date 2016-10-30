package rhxnet.skypicker.pojo.response;

import java.util.List;

public class Flight {
    public String flyFrom;
    public String flyTo;
    public String cityTo;
    public String cityFrom;
    public String fly_duration;
    public BagLimit baglimit ;
    public Float price;
    public Long dTimeUTC;
    public Long aTimeUTC;
    public List<Route> route;
    public Float distance;

    @Override
    public String toString() {
        return "Flight{" +
                "flyFrom='" + flyFrom + '\'' +
                ", flyTo='" + flyTo + '\'' +
                ", cityTo='" + cityTo + '\'' +
                ", cityFrom='" + cityFrom + '\'' +
                ", fly_duration='" + fly_duration + '\'' +
                ", baglimit=" + baglimit +
                ", price=" + price +
                ", dTimeUTC=" + dTimeUTC +
                ", aTimeUTC=" + aTimeUTC +
                ", route=" + route +
                ", distance=" + distance +
                '}';
    }
}
