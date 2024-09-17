package nl.bioinf.nomi.kill_em_all;

public abstract class GameCharacter implements Movable {
    //implements Movable, but is abstract itself.
    //Only subclasses are
    //required to implement the interface
    private final Coordinate coordinate = new Coordinate();
    private String name;
    private int energyLevel = 100;

    public GameCharacter(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate(){
            return coordinate;
    }

    public String getName() {
        return name;
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


    void attack(int power, GameCharacter opponent) {
        if (drainEnergy(power)) {
            //but has double effect on its opponent
            opponent.drainEnergy(power * 2);
        }
    }

    public boolean drainEnergy(int power) {
        if (this.energyLevel - power < 0) return false;

        //energy is drawn from its own reserve for an attack
        this.energyLevel -= power;
        return true;
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
