package edu.testing.part3_domain_model.objects.dimensions;

public class AbstractDimensions extends Dimensions {
    public AbstractDimensions(int dimensionsAmount, Double ... dimensions) throws IllegalArgumentException {
        super(dimensionsAmount, dimensions);
        for (var dimension : dimensions) {
            if (dimension < 0) {
                throw new IllegalArgumentException("Dimensions of abstract object should be >= than zero.");
            }
        }
    }
}
