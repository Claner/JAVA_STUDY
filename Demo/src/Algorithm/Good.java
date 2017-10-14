package Algorithm;

/**
 * Created by Clanner on 2017/4/28.
 */
public class Good {

    private int weight;//容量
    private int value;//价值

    public Good(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
