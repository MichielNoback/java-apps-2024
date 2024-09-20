package nl.bioinf.nomi.kill_em_all;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(top, that.top) == 0 && Double.compare(left, that.left) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(top, left);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "top=" + top +
                ", left=" + left +
                '}';
    }
}