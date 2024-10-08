package nl.bioinf.nomi.kill_em_all;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    void gameLoopTest() {
        Ninja hargg = new Ninja("Hargg");
        hargg.move(new Coordinate(8, 10));

        GameCharacter kloemp = new Troll("Kloemp");
        kloemp.move(new Coordinate(0, 20));

        GameLoop game = new GameLoop();

        // Turn 1 (move player)
        game.addCommand(new MoveCommand(hargg, new Coordinate(8, 10)));
        game.turn(); // after a turn() call, the command queue is empty

        // Turn 2 (move opponent)
        game.addCommand(new MoveCommand(kloemp, new Coordinate(0, 20)));
        game.turn();

        //Turn 3 (move player, attack and move away!)
        game.addCommand(new MoveCommand(hargg, new Coordinate(3, 8)));
        game.addCommand(new AttackCommand(hargg, kloemp, 10));
        game.addCommand(new MoveCommand(hargg, new Coordinate(3, 8)));
        game.turn();
    }

    @Test
    public void testIllegalMoveOperation() {
        Ninja hargg = new Ninja("Hargg");

        // Moving to negative coordinates or setting negative energy levels
        // should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> hargg.move(new Coordinate(-100, 10)));
        assertThrows(IllegalArgumentException.class, () -> hargg.setEnergyLevel(-100));

        // GameLoop however should catch errors and print ERROR log
        GameLoop game = new GameLoop();
        game.addCommand(new MoveCommand(hargg, new Coordinate(-100, 10)));
        game.turn();
    }
}
