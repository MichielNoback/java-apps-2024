package nl.bioinf.nomi.kill_em_all;

import java.util.Objects;

public abstract class GameCharacter implements Movable {
    //implements Movable, but is abstract itself.
    //Only subclasses are
    //required to implement the interface
    private Coordinate coordinate = new Coordinate();
    private String name;
    private int energyLevel = 100;
    private double attackRange = 5.0;

    public GameCharacter(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate(){
            return coordinate;
    }

    public String getName() {
        return name;
    }

    public void setCoordinate(Coordinate newCoordinate) {
        if (newCoordinate.getTop() < 0)
            throw new IllegalArgumentException("coordinates must be positive");
        if (newCoordinate.getLeft() < 0)
            throw new IllegalArgumentException("coordinates must be positive");
        this.coordinate = newCoordinate;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        if (energyLevel > 100 || energyLevel <= 0) {
            throw new IllegalArgumentException("Illegal energy level: " + energyLevel);
        }
        this.energyLevel = energyLevel;
    }

    public void setAttackRange(double range) {
        this.attackRange = range;
    }

    void attack(int power, GameCharacter opponent) {
        if (this.equals(opponent)) {
            System.out.println("Not allowed to attack yourself!");
            return;
        }
        double distance = this.getDistanceToCharacter(opponent);
        // Check if opponent is within attack range and enough power is remaining
        if (distance <= this.attackRange & drainEnergy(power)) {
            //but has double effect on its opponent
            opponent.drainEnergy(power * 2);
        } else if (distance > this.attackRange) {
            System.out.println(opponent.getName() + " is out of range!");
        } else if (this.energyLevel - power < 0) {
            System.out.println(this.getName() + " has not enough power left!");
        }
    }

    public double getDistanceToCharacter(GameCharacter character) {
        return this.coordinate.getDistance(character.getCoordinate());
    }

    public boolean drainEnergy(int power) {
        if (this.energyLevel - power < 0) return false;

        //energy is drawn from its own reserve for an attack
        this.energyLevel -= power;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCharacter that = (GameCharacter) o;
        return Objects.equals(coordinate, that.coordinate) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, name);
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "coordinate=" + coordinate +
                ", name='" + name + '\'' +
                ", energyLevel=" + energyLevel +
                '}';
    }
}
