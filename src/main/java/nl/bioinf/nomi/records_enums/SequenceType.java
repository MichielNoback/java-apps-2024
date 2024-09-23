package nl.bioinf.nomi.records_enums;

public enum SequenceType {
    DNA("DNA"),
    RNA("RNA"),
    PROTEIN("Protein");

    private final String name;

    SequenceType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SequenceType{" +
                "name='" + name + '\'' +
                '}';
    }
}
