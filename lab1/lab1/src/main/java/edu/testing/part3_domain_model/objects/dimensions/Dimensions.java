package edu.testing.part3_domain_model.objects.dimensions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition of capacity measurement for an Object.
 * Units of measure are meters.
 */
public abstract class Dimensions {
    private final List<Double> dimensionsList;

    protected Dimensions(int dimensionsAmount, Double ... dimensions) throws IllegalArgumentException {
        if (dimensionsAmount < 0) {
            throw new IllegalArgumentException("Number of dimensions can not be negative.");
        }
        this.dimensionsList = Arrays.asList(dimensions);
    }

    public List<Double> getDimensions() {
        return new ArrayList<>(dimensionsList);
    }

    public Double getDimension(int dimensionN) throws IndexOutOfBoundsException {
        if (dimensionN < 0 || dimensionN > dimensionsList.size()) throw new IndexOutOfBoundsException("Dimension ");
        return dimensionsList.get(dimensionN);
    }

    public void setDimension(int dimensionN, Double dimension) throws IndexOutOfBoundsException {
        if (dimensionN < 0 || dimensionN > dimensionsList.size()) throw new IndexOutOfBoundsException("Dimension ");
        this.dimensionsList.set(dimensionN, dimension);
    }

    /**
     * Determines if a given dimensions can fit into this dimensions
     */
    public boolean isCanFit(Dimensions otherDimensions) throws IllegalArgumentException {
        if (this.dimensionsList.size() != otherDimensions.getDimensions().size()) {
            throw new IllegalArgumentException("Comparing dimensions have different amount of dimensions");
        }
        for (int i = 0; i < this.getDimensions().size(); i++) {
            if (this.dimensionsList.get(i) < otherDimensions.getDimensions().get(i)) {
                return false;
            }
        }
        return true;
    }
}

