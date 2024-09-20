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
        assertEquals(21, hargg.getCoordinate().getTop());
        assertEquals(23, hargg.getCoordinate().getLeft());

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

    @Test
    void testAttackRange() {
        Ninja hargg = new Ninja("Hargg");
        hargg.move(new Coordinate(8, 10));

        GameCharacter kloemp = new Troll("Kloemp");
        kloemp.move(new Coordinate(0, 20));

        // Test range calculation
        assertEquals(12.8, hargg.getDistanceToCharacter(kloemp), 0.01);

        hargg.attack(20, kloemp);
        // No damage!
        assertEquals(100, kloemp.getEnergyLevel());

        // Move closer and attack!
        hargg.move(new Coordinate(3, 16));
        assertEquals(5.0, hargg.getDistanceToCharacter(kloemp), 0.01);
        hargg.attack(20, kloemp);
        assertEquals(60, kloemp.getEnergyLevel());
    }

    @Test
    void testTrollMoveSpeed() {
        GameCharacter kloemp = new Troll("Kloemp");
        // Initial move is always valid
        kloemp.move(new Coordinate(0, 20));

        // Moving too far results in no move
        Coordinate kloempPosition = kloemp.getCoordinate();
        kloemp.move(new Coordinate(15, 20));
        assert(kloempPosition.equals(kloemp.getCoordinate()));
    }
}