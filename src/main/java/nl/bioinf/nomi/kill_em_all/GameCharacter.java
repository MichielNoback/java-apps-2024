package nl.bioinf.nomi.kill_em_all;

public class GameCharacter {
    private double topCoordinate;
    private double leftCoordinate;
    private String name;
    private int energyLevel = 100;

    public GameCharacter(String name) {
        this.name = name;
    }

    public double getTopCoordinate() {
        return topCoordinate;
    }

    public double getLeftCoordinate() {
        return leftCoordinate;
    }

    void move(double top, double left) {
        this.topCoordinate += top;
        this.leftCoordinate += left;
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
        return "Ninja{" +
                "name='" + name + '\'' +
                ", energyLevel=" + energyLevel +
                ", topCoordinate=" + topCoordinate +
                ", leftCoordinate=" + leftCoordinate +
                '}';
    }

}
