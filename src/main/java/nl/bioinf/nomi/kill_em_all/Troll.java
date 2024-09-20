package nl.bioinf.nomi.kill_em_all;

public class Troll extends GameCharacter {
    private double speed = 10;
    public Troll(String name) {
        super(name);
    }

    @Override
    public void move(Coordinate newCoordinate) {
        // Check if character has already been moved
        Coordinate currentPosition = this.getCoordinate();

        // Accept move if player is still at the starting position
        // Reject move if distance to new point is > speed
        if (currentPosition.getTop() == 0.0 & currentPosition.getLeft() == 0.0) {
            this.setCoordinate(newCoordinate);
        } else if (Math.abs(currentPosition.getDistance(newCoordinate)) > speed) {
            System.out.println("Trolls cant move *that* fast!");
        } else {
            this.setCoordinate(newCoordinate);
        }
    }
}
