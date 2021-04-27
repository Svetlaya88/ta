package task2.sweets;

public abstract class Sweet{

    private String name;
    private double weightInGram;
    private String manufacturer;


    public Sweet(String name, double weightInGram, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.weightInGram = weightInGram;
    }

    public double getWeightInGram() {
        return weightInGram;
    }

    public void setWeightInGram(double weightInGram) {
        this.weightInGram = weightInGram;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calculateSugar() {
        final double sugarQuantityPerGram = 0.5;
        return sugarQuantityPerGram * getWeightInGram();
    }
}
