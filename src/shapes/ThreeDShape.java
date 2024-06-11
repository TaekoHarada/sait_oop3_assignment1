package shapes;

public abstract class ThreeDShape implements Comparable<ThreeDShape> {
    public abstract double getHeight();
    public abstract double getBaseArea();
    public abstract double getVolume();

    @Override
    public int compareTo(ThreeDShape other) {
        return Double.compare(this.getHeight(), other.getHeight());
    }
}

