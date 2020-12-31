package beans;

import javax.ejb.Stateful;

@Stateful
public class CounterManufacturerEJB {
    private int counter = 0;
    public String counter() {
        counter++;
        return ""+counter;
    }
}
