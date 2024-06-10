package shapes;

public class SquarePrism extends Prism {
	
	double edgeLength;

	public SquarePrism(double edgeLength, double height) {
		super(height);
		this.edgeLength = edgeLength;
	}

	@Override
    public double getBaseArea() {
        return this.edgeLength * this.edgeLength;
    }


}
