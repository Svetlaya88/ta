package task2.utilities;


import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Utilities {

    public String getDefaultFilePath(String fileName) {
        return System.getProperty("user.dir") + System.getProperty("file.separator") + fileName;
    }

    public String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd.yyy");
        return dateFormat.format(new Date());
    }

    public void printException(String message, String fileName) {
        System.out.println(String.format(message, fileName));
    }

    public void printLineSeparator() {
        System.out.println("----------------------------------------");
    }
}
