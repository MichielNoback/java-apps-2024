package nl.bioinf.nomi.kill_em_all;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameCharacterTest {
    @Test
    void testCreateNinja() {
        Ninja hargg = new Ninja("Hargg");
        System.out.println(hargg);
        hargg.move(new Coordinate(30, 26));
        hargg.move(new Coordinate(21, 23));
        assertEquals(51, hargg.getCoordinate().getTop());
        assertEquals(49, hargg.getCoordinate().getLeft());

        GameCharacter kloemp = new Troll("Kloemp");
        hargg.attack(10, kloemp);

        assertEquals(90, hargg.getEnergyLevel());
        System.out.println(hargg);
    }

    @Test
    void testEnergyProperty() {
        Ninja hargg = new Ninja("Hargg");
        System.out.println(hargg);
        hargg.setEnergyLevel(100);
    }

    @Test
    void testRepeatedAttack() {
        Ninja hargg = new Ninja("Hargg");
        GameCharacter kloemp = new Troll("Kloemp");
        for (int i = 0; i < 6; i++) {
            hargg.attack(25, kloemp);
            System.out.println("hargg = " + hargg);
        }
    }

    @Test
    void testInheritance() {
        Ninja ninja = new Ninja("Hargg");
        ninja.jump();


    }
}