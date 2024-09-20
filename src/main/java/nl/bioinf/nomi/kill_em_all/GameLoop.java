package nl.bioinf.nomi.kill_em_all;

import java.util.LinkedList;

public class GameLoop {
    LinkedList<Command> turn = new LinkedList<>();

    public void addCommand(Command command) {
        turn.add(command);
    }

    public void turn() {
        System.out.println("\nRunning the following commands:\n" + turn.toString());
        while(!turn.isEmpty()) {
            Command command = turn.removeFirst();
            command.runCommand();
        }
    }
}
