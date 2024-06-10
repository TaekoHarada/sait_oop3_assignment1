package shapes;

import java.util.Comparator;

public class ShapeComparator {
    public static Comparator<ThreeDShape> getComparator(String type) {
        switch (type) {
            case "v":
                return new VolumeComparator();
            case "a":
                return new BaseAreaComparator();
            case "h":
            default:
                return Comparator.naturalOrder(); // Uses the compareTo method
        }
    }
}

class VolumeComparator implements Comparator<ThreeDShape> {
    @Override
    public int compare(ThreeDShape shape1, ThreeDShape shape2) {
        return Double.compare(shape1.getVolume(), shape2.getVolume());
    }
}

class BaseAreaComparator implements Comparator<ThreeDShape> {
    @Override
    public int compare(ThreeDShape shape1, ThreeDShape shape2) {
        return Double.compare(shape1.getBaseArea(), shape2.getBaseArea());
    }
}

