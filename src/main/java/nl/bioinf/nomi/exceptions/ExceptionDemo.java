package nl.bioinf.nomi.exceptions;

import java.util.List;

public class ExceptionDemo {
    List<Integer> numbers = List.of(2, 3);
    public static void main(String[] args) {
        ExceptionDemo demo = new ExceptionDemo();
        try {
            demo.start();
        } catch (Exception ex) {
            System.err.println("Something went wrong. Exiting.\n" +
                    "Error information: " + ex.getMessage() + ": " +
                    ex.getCause());
        }
    }

    private void start() {
        doSomething();
    }

    private void doSomething() {
        double result = 0;
        try {
            result = doSomethingElse(-5);
        } catch (NullPointerException | UnsupportedOperationException ex) {
            //LOG ERROR
            result = Double.NaN;
        } catch (NumberFormatException ex) {
            //iets anders

        }
        //further work on result
        System.out.println("result = " + result);
    }

    private double doSomethingElse(int i) {
        double result = i + numbers.get(0); //throws NullPointer
        int multiplier;
        try {
            multiplier = getMultiplier();
        } catch (IllegalArgumentException ex) {
            multiplier = 4;
        }
        return result * multiplier;
    }

    private int getMultiplier() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }
}
