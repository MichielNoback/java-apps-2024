package nl.bioinf.nomi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsTest {
    @Test
    void collectionsInitTest() {
        List<Integer> numbers = new ArrayList<>(100000);
        numbers.contains(42); //O(n)
        numbers.add(64);
        numbers.add(34);
        numbers.add(21);
        numbers.add(97);
        numbers.add(58);

        Set<Integer> numbers2 = new HashSet<Integer>();
        numbers.contains(42); //O(1)

        numbers.
                parallelStream().
                mapToInt(number -> number).
                mapToObj(number -> "number = " + number).
                forEach(System.out::println);
    }
}
