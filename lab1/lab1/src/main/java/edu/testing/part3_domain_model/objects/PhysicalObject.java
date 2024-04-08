package edu.testing.part3_domain_model.objects;

import edu.testing.part3_domain_model.Position;
import edu.testing.part3_domain_model.objects.dimensions.Dimensions;
import edu.testing.part3_domain_model.objects.dimensions.PhysicalDimensions;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PhysicalObject {
    private String name;
    private AbstractObject prototype;
    private PhysicalDimensions dimensions;
    private Color color;
    private Set<SpecialCharacteristics> specialCharacteristics = new HashSet<>();

    public PhysicalObject(String name, PhysicalDimensions dimensions, Color color) {
        this.name = name;
        this.dimensions = dimensions;
        this.color = color;
    }

    public PhysicalObject(String name, AbstractObject prototype, PhysicalDimensions dimensions, Color color) {
        this.name = name;
        this.prototype = prototype;
        this.dimensions = dimensions;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhysicalDimensions getDimensions() {
        return dimensions;
    }

    public Color getColor() {
        return color;
    }

    public void setDimensions(PhysicalDimensions dimensions) {
        this.dimensions = dimensions;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public AbstractObject getPrototype() {
        return prototype;
    }

    public Set<SpecialCharacteristics> getSpecialCharacteristics() {
        return this.specialCharacteristics;
    }

    public void addSpecialCharacteristics(SpecialCharacteristics specialCharacteristics) {
        this.specialCharacteristics.add(specialCharacteristics);
    }

    public double getCapacity() {
        return dimensions.getHeight() * dimensions.getWidth() * dimensions.getLength();
    }

    public Shape getShape() {
        if (dimensions.getLength() > dimensions.getWidth() && dimensions.getLength() > dimensions.getHeight()) {
            return Shape.CROSSOVKA;
        }
        return Shape.SPHERE;
    }

    public static enum Shape {
        CUBE,
        SPHERE,
        CROSSOVKA,
    }

    public static enum Color {
        WHITE,
        BLACK,
        BLUE,
        GREEN,
        RED,
        YELLOW,
        GOLDEN,
        TRANSPARENT,
    }

    public static enum SpecialCharacteristics {
        INSANELY_BEAUTIFUL,
        INVISIBLE,
        MIND_INCOMPREHENSIBLE,
        GIANT,

    }

    public boolean isBeautiful() {
        switch (this.getShape()) {
            case CROSSOVKA -> {
                return this.color == Color.WHITE || this.color == Color.BLACK;
            }
            case SPHERE -> { return true; }
            case CUBE -> {
                return this.color == Color.RED || this.color == Color.GREEN;
            }
            default -> { return false; }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhysicalObject that)) return false;
        return getName().equals(that.getName()) && getPrototype().equals(that.getPrototype()) && getDimensions().equals(that.getDimensions()) && getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrototype(), getDimensions(), getColor());
    }
}



