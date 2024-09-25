package nl.bioinf.nomi.kill_em_all;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

public class GameLoop {
    LinkedList<Command> turn = new LinkedList<>();
    private static Logger logger = LogManager.getLogger(GameLoop.class.getName());

    public void addCommand(Command command) {
        turn.add(command);
    }

    public void turn() {
        logger.debug("Running the following commands: {}", turn.toString());
        while(!turn.isEmpty()) {
            Command command = turn.removeFirst();
            try {
                command.runCommand();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }
}
