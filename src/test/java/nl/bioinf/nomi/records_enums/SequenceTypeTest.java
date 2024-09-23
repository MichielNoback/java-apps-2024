package nl.bioinf.nomi.records_enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceTypeTest {

    @Test
    void testPrint() {
        System.out.println(SequenceType.PROTEIN);
        SequenceType t = SequenceType.PROTEIN;
    }

}