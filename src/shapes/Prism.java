package shapes;

public abstract class Prism extends ThreeDShape {
    private double height;

    public Prism(double height) {
        this.height = height;
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

	@Override
	public double getHeight() {
		return this.height;
	}

}