package nl.bioinf.nomi.kill_em_all;

public class Coordinate {
    private double top;
    private double left;

    public Coordinate() {
    }

    public Coordinate(double top, double left) {
        this.top = top;
        this.left = left;
    }

    public double getTop() {
        return top;
    }

    public double getLeft() {
        return left;
    }

    public double getDistance(Coordinate other) {
        return Math.sqrt(
                Math.pow(other.getLeft() - this.getLeft(), 2) +
                Math.pow(other.getTop() - this.getTop(), 2)
        );
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "top=" + top +
                ", left=" + left +
                '}';
    }
}