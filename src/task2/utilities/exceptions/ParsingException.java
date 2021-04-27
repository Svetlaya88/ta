package task2.utilities.exceptions;

public class ParsingException extends Exception{

    @Override
    public String toString() {
        return ">>>>>> System error: Cannot parse file <<<<<<";
    }

    public ParsingException(String message) {
    }
}
