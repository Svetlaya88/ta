package task2.utilities.exceptions;

public class NoAvailableSweetsException extends Exception{

    public NoAvailableSweetsException(String message) {
        super(message);
    }

    public NoAvailableSweetsException() {
        super(">>>>>> System error: sweets less than expected <<<<<<");
    }
}
