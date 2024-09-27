package nl.bioinf.nomi;


import picocli.CommandLine;

import java.util.Arrays;

/**
 * alles leeft in classes
 */
public class Main {
    //instance variabele (object variabele)
    private int zValue;

    //constructor
    public Main(int zValue){
        this.zValue = zValue;
    }

    /**
     * entry point voor een applicatie
     * @param args
     */
    public static void main(String[] args) {
        int exitCode = new CommandLine(new CommandlineProcessor()).execute(args);
        System.exit(exitCode);
    }

    /**
     * static ofwel utility method
     * gebruikt nooit object data
     * @param x
     * @param y
     * @return
     */
    public static int multiply(int x, int y, int z) {
        return x * y * z;
    }

    public void start(String[] args) {
        int length = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        int surface = multiply(length, width, this.zValue);
        System.out.println("surface = " + surface);
    }
}