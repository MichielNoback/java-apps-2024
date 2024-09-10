package nl.bioinf.nomi;

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
        System.out.println("args = " + Arrays.toString(args));
        Main app = new Main(3);
        app.start(args);
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