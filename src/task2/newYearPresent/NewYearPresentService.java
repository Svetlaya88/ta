package task2.newYearPresent;


import task2.sweets.candy.Candy;
import task2.sweets.ChocolateBar;
import task2.sweets.candy.LollipopCandy;
import task2.sweets.Sweet;
import task2.utilities.exceptions.NewYearPresentException;
import task2.utilities.exceptions.NoAvailableSweetsException;

import java.util.*;
import java.util.stream.Collectors;

public class NewYearPresentService implements Sortable {

    private static final int LIMIT_WEIGHT = 20;
    private static final int TEN_CANDIES = 10;

    public NewYearPresent composePresentWithWrapper(NewYearPresent present, List<Sweet> sweets, String presentName,
                                                    NewYearPresentPackaging.Packaging wrapper)
            throws NoAvailableSweetsException, NewYearPresentException {

        NewYearPresentPackaging packaging = new NewYearPresentPackaging();

        present.setName(presentName);
        wrapPresent(present, packaging);

        System.out.println(">>> SWEETS IN THE PRESENT " + present.getName() + ": <<<");

        List<Sweet> uniqueSweets = getUniqueSweets(sweets);
        printUniqueSweets(uniqueSweets);

        System.out.println(">>> WEIGHT OF CANDIES: " + present.getWeightOfAllSweets(sweets) + " gram <<<");

        int totalWeight = getTotalWeightWithPackaging(present.getWeightOfAllSweets(sweets), wrapper.getWeight());
        System.out.println(">>> WEIGHT TOTAL: " + totalWeight + " gram <<<");

        printLineSeparator();
        return present;
    }

    private int getTotalWeightWithPackaging(double sweetsWeight, double packagingWeight) {
        return (int) (sweetsWeight + packagingWeight);
    }

    private void wrapPresent(NewYearPresent present, NewYearPresentPackaging packaging) throws NewYearPresentException {
        try {
            present.setWrapped(packaging.assemble());
            packaging.setAssembled(true);
        }catch (NullPointerException e) {
            throw new NewYearPresentException(">>>>>> System error: present doesn't exist <<<<<<");
        }
    }

    private double getSweetsWeight(Sweet sweet, final int amount) {
        return sweet.getWeightInGram() * amount;
    }

    private List<Sweet> getUniqueSweets(List<Sweet> candiesInPresent) throws NoAvailableSweetsException {
        List<Sweet> uniqueSweets = new ArrayList<>();
        try {
            uniqueSweets.add(candiesInPresent.get(0));
        }catch (IndexOutOfBoundsException e) {
            throw new NoAvailableSweetsException(">>>>>> System error: no sweets in present <<<<<<");
        }

        for (int i = 0; i < candiesInPresent.size(); ) {
            for (int j = 0; i < candiesInPresent.size(); ) {
                try {
                    if (!candiesInPresent.get(i).getName().equals(uniqueSweets.get(j).getName())) {
                        uniqueSweets.add(candiesInPresent.get(i));
                        j++;
                    }
                    i++;
                } catch (IndexOutOfBoundsException e) {
                    throw new NoAvailableSweetsException();
                }
            }
        }
        return uniqueSweets;
    }

    private void printUniqueSweets(List<Sweet> sweets) {
        List<Sweet> sweetsBiggerTwentyGram = sweets.stream()
                .filter(candy -> candy.getWeightInGram() >= LIMIT_WEIGHT).collect(Collectors.toList());

        if (!sweetsBiggerTwentyGram.isEmpty()) {
            sweets.stream().filter(sweet -> sweet.getWeightInGram() < LIMIT_WEIGHT)
                    .forEach(sweet -> {
                        System.out.println("- " + sweet.getName() + ", " + sweet.getManufacturer() + ", " +
                                (int) getSweetsWeight(sweet, TEN_CANDIES) + " gram");
                    });

            sweetsBiggerTwentyGram.forEach(sweet -> {
                System.out.println("- " + sweet.getName() + ", " + sweet.getManufacturer() + ", " +
                        (int) sweet.getWeightInGram() + " gram");
            });

        } else {
            sweets.forEach(sweet -> {
                System.out.println("- " + sweet.getName() + ", " + sweet.getManufacturer() + ", " +
                        (int) getSweetsWeight(sweet, TEN_CANDIES) + " gram");
            });

        }
        printLineSeparator();
    }

    @Override
    public void sort(NewYearPresent newYearPresent) {
        System.out.println(">>> CANDIES FROM PRESENT SORTED BY AMOUNT OF SUGAR: <<<");

        try {
            Map<String, Double> sugarPerSweet = getUniqueSweets(newYearPresent.getSweets()).stream()
                    .collect(Collectors.toMap(Sweet::getName, Sweet::calculateSugar));

            Map<String, Double> sorted = sugarPerSweet.entrySet().stream().sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            sorted.forEach((k, v) -> {
                System.out.println(v + " gram sugar in " + k);
            });

        } catch (NoSuchElementException | NoAvailableSweetsException e) {
            System.out.println(">>>>>> System error, please see log file <<<<<<");
        }

        printLineSeparator();
    }

    public void getCandiesByManufacturerAndWeightLess(NewYearPresent newYearPresent, String manufacturer, double weight)
            throws NoAvailableSweetsException {
        List<Sweet> sweetsInPresent = newYearPresent.getSweets();

        List<Sweet> filteredSweets = sweetsInPresent.stream()
                .filter(sweet -> sweet.getManufacturer().equals(manufacturer) &&
                        sweet.getWeightInGram() < weight)
                .collect(Collectors.toList());

        getUniqueSweets(filteredSweets).forEach(sweet -> {
            System.out.println(">>> SWEET '" + sweet.getName() + "' IS FILTERED AMONG SWEETS OF "
                    + newYearPresent.getName() + " PRESENT BY MANUFACTURER '" + manufacturer
                    + "' AND WEIGHT LESS THAN " + weight + " GRAM <<<");
        });

        printLineSeparator();
    }

    public void addTenOfEachCandy(NewYearPresent present, List<Candy> candies) {
        candies.forEach(present::addTenCandies);
    }

    public List<Sweet> collectTotalAmountOfSweets(NewYearPresent present, LollipopCandy lollipopCandyWithStick,
                                                  ChocolateBar chocolateBar) throws NoAvailableSweetsException {
        List<Sweet> sweetsToBeAdded = present.getSweets();
        if (sweetsToBeAdded.isEmpty()) {
            throw new NoAvailableSweetsException();
        }
        sweetsToBeAdded.add(lollipopCandyWithStick);
        sweetsToBeAdded.add(chocolateBar);
        return sweetsToBeAdded;
    }

    private void printLineSeparator() {
        final String lineSeparator = "----------------------------------------";
        System.out.println(lineSeparator);
    }
}
