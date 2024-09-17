package nl.bioinf.nomi.textutils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextUtilsTest {

    @Test
    void getLongestWord_sunny() {
        String input = "De apen (Simiiformes) zijn een infraorde uit de orde" +
                " der primaten (Primates). Alle primaten die niet tot de " +
                "infraorde van de apen behoren worden halfapen genoemd. " +
                "Een groep halfapen, de spookdiertjes, wordt beschouwd " +
                "als de nauwste verwant van de apen en samen worden ze " +
                "geplaatst in de onderorde Haplorhini.\n";
        assertEquals("spookdiertjes", TextUtils.getLongestWord(input));

        input = "De apen zijn verdeeld in twee groepen (\"parvordes\"), " +
                "de breedneusapen (Platyrrhini) uit Midden- en Zuid-Amerika " +
                "en de smalneusapen (Catarrhini) uit Afrika en Azië. Deze " +
                "parvordes worden soms als aparte infra-ordes gezien. ";
        assertEquals("breedneusapen", TextUtils.getLongestWord(input));
    }

    @Test
    void getLongestWord_null(){
        assertThrows(IllegalArgumentException.class,
                () -> TextUtils.getLongestWord(null));
    }

    @Test
    void getLongestWord_empty() {
        String input = "";

        //",", ", ", " -" --> Illegal
        //"'t", "'s", --> word
    }

}