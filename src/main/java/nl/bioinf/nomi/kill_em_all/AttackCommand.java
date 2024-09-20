package nl.bioinf.nomi.kill_em_all;

import java.util.Collections;
import java.util.Map;

public class AttackCommand implements Command {
    private Map<GameCharacter, Map<GameCharacter, Integer>> attackOperations;

    // Attack Operation
    public AttackCommand(GameCharacter character, GameCharacter opponent, int power) {
        attackOperations = Collections.singletonMap(
                character,
                Collections.singletonMap(opponent, power)
        );
    }

    @Override
    public void runCommand() {
        for (Map.Entry<GameCharacter, Map<GameCharacter, Integer>> entry: attackOperations.entrySet()) {
            for (Map.Entry<GameCharacter, Integer> attack: entry.getValue().entrySet()) {
                entry.getKey().attack(attack.getValue(), attack.getKey());
            }
        }
    }

    @Override
    public String toString() {
        return "AttackCommand{" +
                "attackOperations=" + attackOperations +
                '}';
    }
}
