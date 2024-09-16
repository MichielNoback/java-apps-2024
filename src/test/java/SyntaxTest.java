import nl.bioinf.nomi.kill_em_all.Ninja;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
//import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static java.lang.System.out;

public class SyntaxTest {

    @org.junit.jupiter.api.Test
    void dataTypes() {
        // Primitives
        char nuc = 'C';
        // Calculating using the ASCII table. 'C' [67] + '$' [36] = 103 ==> 'g'
        assertEquals('g', nuc + '$');

        byte b = 13; // byte value: [00001101]
        // byte overflow!
        b = 127; // max value: [11111111]
        // -128 [00000001 00000000] requires 16 bits, but only the last 8 bits
        // are stored [00000000] (min value)
        b++;

        int i = 42;
        int easy_to_read = 1_050_500;
        int hard_to_read = 1__0_5_50_0_0; // yes, also allowed...
        long j = 128l; // all typed-values are by default of type int. Use 'l' to denote long

        // Default decimal values are of type double, use 'f' to denote float
        float x = 10.0f;
        double y = 5.0;
        double z = 5; // int is 'cast' to double, value stored is 5.0.
    }

    @Test
    void castingTest() {
        byte b = 64; // implicit cast from int to byte
        byte c = (byte)64; // what is actually stored

        int i = 10;
        int j = 3;
        double x = i / j; // = 3.0, integer division!
        assertEquals(3.0, x);

        x = (double)i / j; // = 3.33333, cast one value (up) to double
        assertEquals(3.3333, x, 0.01); // delta is used for rounding errors

        float f = (float)x * 10; // down-casting to float; loses precision (dangerous!)

        long earthPopulation = 8_175_882_318l;
        int doesNotFit = (int)earthPopulation; // = -414052274, integer overflow!
    }

    @Test
    void arrayTest() {
        int[] range = new int[10]; // All elements have value 0

        // Iterate over the array and fill with a number
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
        }
        assertEquals(5, range[5]);

        // Create with contents
        char[] nucleotides = {'A', 'C', 'G', 'T'};
        // Printing
        System.out.println(Arrays.toString(nucleotides)); // prints [A, C, G, T]

        // Array of Objects
        Ninja[] clan = new Ninja[4]; // Note: requires a public Ninja class
        clan[0] = new Ninja("hargg");
        clan[2] = new Ninja("kloemp");
        System.out.println(Arrays.toString(clan));
    }

    @Test
    void flowControlTest() {
        char[] nucleotides = {'A', 'C', 'G', 'T'};

        // Standard iteration
        for (int i = 0; i < nucleotides.length; i++) {
            System.out.println(nucleotides[i]);
        }
        System.out.println("-----");

        // Reversing the array
        for (int i = nucleotides.length - 1; i >= 0; i--) {
            System.out.println(nucleotides[i]);
        }
        System.out.println("-----");

        // Alternative for-loop for arrays (and other collections)
        for(char nuc: nucleotides) {
            System.out.println(nuc);
        }

        // Creates an array with all letters of the alphabet
        char[] alphabet = new char[26];
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            alphabet[letter - 'A'] = letter; // Subtracting 'A' to get index location
        }
        System.out.println(Arrays.toString(alphabet));

        // These highly inefficient nested for-loops walks through the alphabet and
        // tries to find all nucleotide letters. Using 'break' we exit as soon as
        // we've seen them all.
        int nucsSeen = 0;
        for (char letter: alphabet) {
            for (char nucleotide: nucleotides) {
                if (letter == nucleotide)
                    nucsSeen++;
            }
            if (nucsSeen == nucleotides.length) break;
        }
    }

    @Test
    void testIncrements(){
        int x = 43;
        int y = 43;

        x += 1;
        y++;

        for (int i = 0; i < 10; i++){

        }
        assertEquals(x, y);

    }

    //method overloading; two arguments
    int add(int x, int y){
        return x + y;
    }

    //method overloading; one argument
    int add(int x) {
        //extra logic
        return add(x, 2);
    }

    //test method overloading
    @Test
    void testAdd() {
        add(2, 3);
        add(2);
        out.println();
    }
}
