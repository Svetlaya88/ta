package task2.sweets.candy;


public class ToffeeCandy extends Candy {

    private boolean isSoft;

    public ToffeeCandy(String name, double weightInGram, String manufacturer, String taste, boolean isSoft) {
        super(name, weightInGram, manufacturer, taste);
        this.isSoft = isSoft;
    }

    public boolean isSoft() {
        return isSoft;
    }

    public void setSoft(boolean soft) {
        isSoft = soft;
    }


}