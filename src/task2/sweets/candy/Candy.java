package task2.sweets.candy;

import task2.sweets.Sweet;

public class Candy extends Sweet {

    private String taste;

    public Candy(String name, double weightInGram, String manufacturer) {
        super(name, weightInGram, manufacturer);
    }

    public Candy(String name, double candyWeight, String manufacturer, String taste) {
        super(name, candyWeight, manufacturer);
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
