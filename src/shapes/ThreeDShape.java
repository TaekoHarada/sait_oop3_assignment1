package shapes;

/**
 * An abstract class representing a three-dimensional shape.
 * This class provides methods to get the height, base area, and volume of the shape.
 * It also implements the Comparable interface to compare shapes based on their height.
 */
public abstract class ThreeDShape implements Comparable<ThreeDShape> {

    /**
     * Returns the height of the shape.
     *
     * @return the height of the shape
     */
    public abstract double getHeight();

    /**
     * Returns the base area of the shape.
     *
     * @return the base area of the shape
     */
    public abstract double getBaseArea();

    /**
     * Returns the volume of the shape.
     *
     * @return the volume of the shape
     */
    public abstract double getVolume();

    /**
     * Compares this shape with the specified shape for order based on height.
     *
     * @param other the shape to be compared
     * @return a negative integer, zero, or a positive integer as this shape is less than,
     *         equal to, or greater than the specified shape
     */
    @Override
    public int compareTo(ThreeDShape other) {
        return Double.compare(this.getHeight(), other.getHeight());
    }
}
