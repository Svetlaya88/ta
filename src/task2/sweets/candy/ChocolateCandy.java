package task2.sweets.candy;


public class ChocolateCandy extends Candy {

    private String filling;

    public ChocolateCandy(String name, double weightInGram, String manufacturer, String filling) {
        super(name, weightInGram, manufacturer);
        this.filling = filling;
    }
    public ChocolateCandy(String name, double weightInGram, String manufacturer) {
        super(name, weightInGram, manufacturer);
    }
}
