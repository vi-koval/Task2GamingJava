package Model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private int minBarrier;
    private int maxBarrier;

    private int secretValue;

    private List<Integer> yourWay = new ArrayList<>();

    //[1 - 99] diapason check
    public void setSecretValue() {
        secretValue = (int)Math.ceil(Math.random() *
                (maxBarrier - minBarrier - 1) + minBarrier);
    }

    public boolean checkValue (int value) {
        yourWay.add(value);
        if (value == secretValue) {
            return false;
        } else if (value > secretValue) {
            maxBarrier = value;
        } else {
            minBarrier = value;
        }
        return true;
    }

    public void setPrimaryBarrier (int minBarrier, int maxBarrier){
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    public int getSecretValue() {
        return secretValue;
    }

    public int getMinBarrier () {
        return minBarrier;
    }
    public int getMaxBarrier () {
        return maxBarrier;
    }

  public List<Integer> getYourWay() {
        return yourWay;
  }
}
