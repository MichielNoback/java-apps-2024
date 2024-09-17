package nl.bioinf.nomi.kill_em_all;

public class Ninja extends GameCharacter {
    private double speed = 100;

    public Ninja(String name) {
        super(name);
    }

    void jump() {
        String message = this.getName() + " jumping!";
        this.move(new Coordinate(50, 50));
    }

    @Override
    public void move(Coordinate newCoordinate) {
        //process the move with Ninja speed
        this.setCoordinate(newCoordinate);
    }
}
