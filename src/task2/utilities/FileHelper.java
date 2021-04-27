package task2.utilities;


import task2.sweets.Sweet;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHelper extends Utilities {

    private final String writeException = ">>>>>> Exception: cannot write to the file %s <<<<<<";
    private final String readException = ">>>>>> Exception: cannot read from the file %s <<<<<<";
    private final String fileNotFoundException = ">>>>>> Exception: file %s is not found <<<<<<";

    public void writeSweetsNamesToAvailableSweetsFile(List<Sweet> sweets, final String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getDefaultFilePath(filename)))) {
            writer.write(getCurrentDate());
            writer.newLine();

            List<String> sweetsNames = new ArrayList<>();
            sweets.forEach(sweet -> {
                sweetsNames.add(sweet.getName());
            });


            sweetsNames.forEach(name -> {
                try {
                    writer.write(name);
                    writer.newLine();
                } catch (IOException e) {
                    printException(writeException, filename);
                }
            });
        } catch (IOException e) {
            printException(writeException, filename);
        }
    }

    public void printAvailableSweetsByDate(final String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getDefaultFilePath(fileName)))) {
            String line = bufferedReader.readLine();

            System.out.println(">>> AVAILABLE SWEETS BY DATE " + line + " <<<");

            List<String> lines = new ArrayList<>();

            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }

            Collections.sort(lines);

            for (int i = 1; i < lines.size(); i++) {
                System.out.println(i + ". " + lines.get(i));
            }

            printLineSeparator();
        } catch (FileNotFoundException e) {
            printException(fileNotFoundException, fileName);
        } catch (IOException e) {
            printException(readException, fileName);
        }
    }
}
