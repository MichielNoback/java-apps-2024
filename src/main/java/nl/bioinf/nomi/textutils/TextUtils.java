package nl.bioinf.nomi.textutils;

public abstract class TextUtils {

    public static String getLongestWord(String text) {
        if (text == null) throw new IllegalArgumentException("input cannot be null");
        String[] s = text.split("[^A-Za-z'-]+");
        String longest = "";
        for(String word : s) {
            //System.out.println("word = " + word);
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
}
