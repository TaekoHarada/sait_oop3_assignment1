package shapes;

public class OctagonalPrism extends Prism {
	
	double edgeLength;

	public OctagonalPrism(double edgeLength, double height) {
		super(height);
		this.edgeLength = edgeLength;
	}

	@Override
    public double getBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * this.edgeLength * this.edgeLength;
    }
}
