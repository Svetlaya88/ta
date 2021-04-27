package task1;

import java.util.Scanner;

public class Calculator {
    private static double firstNumberDouble;
    private static int firstNumberInt;
    private static double secondNumberDouble;
    private static int secondNumberInt;

    private static String operation;

    private static boolean intOrDouble;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        intOrDouble = true;

        scanFirstNumber();
        operation = scanOperation();
        scanSecondNumber();

       calculate(intOrDouble);
    }

    public static boolean scanFirstNumber() {
        System.out.println("Enter number: ");
        if (isInt()) {
            firstNumberInt = scanner.nextInt();
            intOrDouble = true;
        } else {
            firstNumberDouble = scanner.nextDouble();
            intOrDouble = false;
        }
        return intOrDouble;
    }

    public static boolean scanSecondNumber() {
        System.out.println("Enter number: ");
        if (isInt()) {
            secondNumberInt = scanner.nextInt();
            intOrDouble = true;
        } else {
            secondNumberDouble = scanner.nextDouble();
            intOrDouble = false;
        }
        return intOrDouble;
    }

    private static boolean isInt() {
        if (scanner.hasNextDouble()) {
            intOrDouble = false;
        } else if (scanner.hasNextInt()) {
            intOrDouble = true;
        } else {
            System.out.println("Error: Only numbers are allowed. Please enter number");
            scanner.next();
            isInt();
        }

        return intOrDouble;
    }

    public static String scanOperation() {
        System.out.println("Enter operation: ");
        String operation = scanner.next();
        boolean valid = true;
        char[] validOperation = {'+', '-', '*', '/'};
        for (char c : validOperation) {
            if (operation.charAt(0) == c) {
                valid = true;
                break;
            } else {
                valid = false;
            }
        }
        if (!valid) {
            System.out.println("Error: only '+', '-', '*' or '/' are allowed");
            operation = scanOperation();
        }
        return operation;
    }

    public static void calculate(boolean isInt) {
        if (isInt) {
            System.out.println("Result: " + calculateInt(firstNumberInt, operation, secondNumberInt));
        } else {
            System.out.println("Result: " + calculateDouble(firstNumberDouble, operation, secondNumberDouble));
        }
    }

    private static double calculateDouble(double a, String s, double b) {
        double calculation = 0.0;
        switch (s) {
            case "+":
                calculation = a + b;
                break;
            case "-":
                calculation = a - b;
                break;
            case "*":
                calculation = a * b;
                break;
            case "/":
                calculation = a / b;
        }
        return calculation;
    }

    private static int calculateInt(int a, String s, int b) {
        int calculation = 0;
        switch (s) {
            case "+":
                calculation = a + b;
                break;
            case "-":
                calculation = a - b;
                break;
            case "*":
                calculation = a * b;
                break;
            case "/":
                calculation = a / b;
        }
        return calculation;
    }
}
