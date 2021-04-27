package task2.newYearPresent;

import task2.sweets.candy.Candy;
import task2.sweets.Sweet;

import java.util.ArrayList;
import java.util.List;

public class NewYearPresent {

    private String name;
    private List<Sweet> sweets = new ArrayList<>();
    private boolean isWrapped;

    public NewYearPresent(boolean isWrapped) {
        this.isWrapped = isWrapped;
    }

    public String getName() {
        return name;
    }

    public void setName(String presentName) {
        this.name = presentName;
    }

    public boolean isWrapped() {
        return isWrapped;
    }

    public void setWrapped(boolean wrapped) {
        isWrapped = wrapped;
    }

    public List<Sweet> getSweets() {
        return sweets;
    }

    public void addTenCandies(Candy candy) {
        int tenCandies = 10;
        List<Candy> tenCandiesList = new ArrayList<>();

        for (int i = 0; i < tenCandies; i++) {
            tenCandiesList.add(candy);
        }

        sweets.addAll(tenCandiesList);
    }

    public int getWeightOfAllSweets(List<Sweet> sweets) {
        return (int) sweets.stream().mapToDouble(Sweet::getWeightInGram).sum();
    }


}
