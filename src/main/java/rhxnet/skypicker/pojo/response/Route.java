package rhxnet.skypicker.pojo.response;

public class Route {
    public Boolean bags_recheck_required;
    public Integer flight_no;
    public String flyTo;
    public String flyFrom;
    public String cityFrom;
    public String cityTo;
    public Long dTimeUTC;
    public Long aTimeUTC;
    public Float price ;
    public String airline;

    @Override
    public String toString() {
        return "Route{" +
                "bags_recheck_required=" + bags_recheck_required +
                ", flight_no=" + flight_no +
                ", flyTo='" + flyTo + '\'' +
                ", flyFrom='" + flyFrom + '\'' +
                ", cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                ", dTimeUTC=" + dTimeUTC +
                ", aTimeUTC=" + aTimeUTC +
                ", price=" + price +
                ", airline='" + airline + '\'' +
                '}';
    }
}
