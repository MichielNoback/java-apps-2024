package nl.bioinf.nomi.records_enums;

public class SequenceDemo {
    String complement(String sequence, SequenceType type) {
        switch (type) {
            case DNA: return complementDNA(sequence);
            case RNA: return complementRNA(sequence);
            case PROTEIN: throw new UnsupportedOperationException("cannot complement Protein");
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }

    }

    private String complementRNA(String sequence) {
        return null;
    }

    private String complementDNA(String sequence) {
        return null;

    }
}
