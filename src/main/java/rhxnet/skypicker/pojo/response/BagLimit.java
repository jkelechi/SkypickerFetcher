package rhxnet.skypicker.pojo.response;

public class BagLimit {
    public Integer hand_width;
    public Integer hand_length;
    public Integer hold_weight;
    public Integer hand_height;
    public Integer hand_weight;

    @Override
    public String toString() {
        return "BagLimit{" +
                "hand_width=" + hand_width +
                ", hand_length=" + hand_length +
                ", hold_weight=" + hold_weight +
                ", hand_height=" + hand_height +
                ", hand_weight=" + hand_weight +
                '}';
    }
}
