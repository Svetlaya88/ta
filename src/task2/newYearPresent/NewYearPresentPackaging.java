package task2.newYearPresent;

public class NewYearPresentPackaging {

    private boolean isAssembled;

    public enum Packaging {
        CARDBOARD(31.5), FABRIC_BAG(53.2), CELLOPHANE(27.6);

        private final double weight;

        Packaging(double weight) {
            this.weight = weight;
        }

        public double getWeight() {
            return weight;
        }
    }

    public void setAssembled(boolean assembled) {
        isAssembled = assembled;
    }

    public boolean assemble() {
        return isAssembled = true;
    }
}
