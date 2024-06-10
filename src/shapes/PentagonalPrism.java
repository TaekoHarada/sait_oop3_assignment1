package shapes;

public class PentagonalPrism extends Prism {
	
	double edgeLength;

	public PentagonalPrism(double edgeLength, double height) {
		super(height);
		this.edgeLength = edgeLength;
	}

	@Override
    public double getBaseArea() {
        return (1.0 / 4.0) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * this.edgeLength * this.edgeLength;
    }
}
