package edu.testing.part3_domain_model.objects.dimensions;

public class PhysicalDimensions extends Dimensions {
    protected static final int PHYSICAL_DIMENSIONS_NUMBER = 3;
    public PhysicalDimensions(double length, double width, double height) throws IllegalArgumentException {
        super(PHYSICAL_DIMENSIONS_NUMBER, length, width, height);
        if (length <= 0 || height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Dimensions of physical object should be greater than zero.");
        }
    }

    public double getLength() {
        return this.getDimension(0);
    }

    public double getWidth() {
        return this.getDimension(1);
    }

    public double getHeight() {
        return this.getDimension(2);
    }
}
