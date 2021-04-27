package task2.sweets.candy;


public class LollipopCandy extends Candy {

    private boolean withStick;

    public LollipopCandy(String name, double weightInGram, String manufacturer, boolean withStick) {
        super(name, weightInGram, manufacturer);
        this.withStick = withStick;
    }

    public LollipopCandy(String name, double weightInGram, String manufacturer, String taste, boolean withStick) {
        super(name, weightInGram, manufacturer, taste);
        this.withStick = withStick;
    }
}
