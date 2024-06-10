package shapes;

public class TrianglarPrism extends Prism {
	
	double edgeLength;

	public TrianglarPrism(double edgeLength, double height) {
		super(height);
		this.edgeLength = edgeLength;
	}

	@Override
    public double getBaseArea() {
        return (Math.sqrt(3)/4)*this.edgeLength * this.edgeLength;
    }
}
