package task2;


import task2.newYearPresent.NewYearPresent;
import task2.newYearPresent.NewYearPresentPackaging;
import task2.newYearPresent.NewYearPresentService;
import task2.sweets.*;
import task2.sweets.candy.Candy;
import task2.sweets.candy.ChocolateCandy;
import task2.sweets.candy.LollipopCandy;
import task2.sweets.candy.ToffeeCandy;
import task2.utilities.FileHelper;
import task2.utilities.exceptions.NewYearPresentException;
import task2.utilities.exceptions.NoAvailableSweetsException;
import task2.utilities.exceptions.ParsingException;
import task2.utilities.Utilities;
import task2.utilities.XmlHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ApplicationRunner {

    private static FileHelper fileHelper = new FileHelper();
    private static final String SWEETS_REGISTERED_FILE = "registered_sweets.txt";
    private static XmlHelper xmlHelper = new XmlHelper();
    private static final String SWEETS_XML = "sweets_xml.xml";

    private static final NewYearPresentService newYearPresentService = new NewYearPresentService();

    private static Candy goldenKeyToffeeCandy = new ToffeeCandy("Golden Key", 5.1,
            "Красный Октябрь", "Creamy", false);
    private static ToffeeCandy grandToffyToffeeCandy = new ToffeeCandy("Grand Toffy", 4.2,
            "Roshen", "Creamy", true);

    private static LollipopCandy chupaChups = new LollipopCandy("Chupa-Chups", 22,
            "Perfetti Van Melle", "Strawberry", true);
    private static LollipopCandy citrusMix = new LollipopCandy("Citrus mix", 6.1, "Roshen",
            "Mixed", false);
    private static LollipopCandy barbaris = new LollipopCandy("Barbaris", 5.3, "Спартак",
            false);

    private static ChocolateCandy sorvanec = new ChocolateCandy("Sorvanec", 16.1, "Коммунарка");
    private static ChocolateCandy shokolapki = new ChocolateCandy("Shokolapki", 6.25, "Roshen",
            "choko");
    private static ChocolateCandy lubimayaAlenka = new ChocolateCandy("Alenka", 15, "Коммунарка");

    private static ChocolateBar milkAlpenGold = new ChocolateBar("Milk Chocolate", 90,
            "Alpen Gold", 25, ChocolateType.MILK);

    public static void main(String[] args) throws ParsingException, NewYearPresentException, NoAvailableSweetsException {

        //compose New Year present with sweets
        NewYearPresent presentHohoho = new NewYearPresent(false);
        newYearPresentService.addTenOfEachCandy(presentHohoho, collectCandies());

        List<Sweet> sweetsToBeAdded = newYearPresentService.collectTotalAmountOfSweets(presentHohoho, chupaChups, milkAlpenGold);

        newYearPresentService.composePresentWithWrapper(presentHohoho, sweetsToBeAdded, "\"Ho-ho-ho\"",
                NewYearPresentPackaging.Packaging.CARDBOARD);

        //sort candies in present
        newYearPresentService.sort(presentHohoho);

        //get particular candies from present by parameters
        newYearPresentService.getCandiesByManufacturerAndWeightLess(presentHohoho, "Roshen", 5);

        //write & read from file
        fileHelper.writeSweetsNamesToAvailableSweetsFile(collectSweets(), SWEETS_REGISTERED_FILE);
        fileHelper.printAvailableSweetsByDate(SWEETS_REGISTERED_FILE);

        //parse xml
        xmlHelper.parseCandiesXml(SWEETS_XML);
    }

    private static List<Candy> collectCandies() {
        List<Candy> candiesList = new ArrayList<>();
        candiesList.add(goldenKeyToffeeCandy);
        candiesList.add(grandToffyToffeeCandy);
        candiesList.add(citrusMix);
        candiesList.add(barbaris);
        candiesList.add(sorvanec);
        candiesList.add(shokolapki);
        candiesList.add(lubimayaAlenka);
        return candiesList;
    }

    private static List<Sweet> collectSweets() {
        List<Sweet> sweets = new ArrayList<>(collectCandies());
        sweets.add(milkAlpenGold);
        return sweets;
    }
}
