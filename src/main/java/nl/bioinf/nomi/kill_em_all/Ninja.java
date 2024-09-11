package nl.bioinf.nomi.kill_em_all;

public class Ninja extends GameCharacter {
    public Ninja(String name) {
        super(name);
    }

    void jump() {
        this.move(50, 50);
    }

}
