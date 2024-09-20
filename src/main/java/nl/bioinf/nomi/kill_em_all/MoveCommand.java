package nl.bioinf.nomi.kill_em_all;

import java.util.Collections;
import java.util.Map;

public class MoveCommand implements Command {
    private Map<GameCharacter, Coordinate> moveOperations;

    public MoveCommand(GameCharacter character, Coordinate coordinate) {
        moveOperations = Collections.singletonMap(character, coordinate);
    }

    @Override
    public void runCommand() {
        GameCharacter character =  moveOperations.keySet().iterator().next();
        character.move(moveOperations.get(character));
    }

    @Override
    public String toString() {
        return "MoveCommand{" +
                "moveOperations=" + moveOperations +
                '}';
    }
}
