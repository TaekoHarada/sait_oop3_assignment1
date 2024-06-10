package shapes;

public class Pyramid extends ThreeDShape {
    private double height;
    private double edgeLength;

    public Pyramid(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getBaseArea() {
        return edgeLength * edgeLength;
    }

    @Override
    public double getVolume() {
        return (edgeLength * edgeLength * height) / 3;
    }
}