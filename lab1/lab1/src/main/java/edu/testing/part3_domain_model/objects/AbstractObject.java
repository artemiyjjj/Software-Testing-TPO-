package edu.testing.part3_domain_model.objects;

import edu.testing.part3_domain_model.objects.dimensions.AbstractDimensions;

public class AbstractObject {
    private String name;
    private AbstractDimensions dimensions;

    public AbstractObject(String name, AbstractDimensions dimensions) {
        this.name = name;
        this.dimensions = dimensions;
    }
}
