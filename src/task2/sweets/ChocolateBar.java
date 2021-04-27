package task2.sweets;

public class ChocolateBar extends Sweet {

    private double percentOfCocoa;
    private ChocolateType chocolateType;

    public ChocolateBar(String name, double weightInGram, String manufacturer, double percentOfCocoa, ChocolateType type) {
        super(name, weightInGram, manufacturer);
        this.percentOfCocoa = percentOfCocoa;
        this.chocolateType = type;
    }
}
