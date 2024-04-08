package edu.testing.part3_domain_model;

import edu.testing.part3_domain_model.objects.dimensions.Dimensions;

/**
 * Entity defines central point of an entity PhysicalObject, which it belongs to.
 */
public class Position {
    private double x;
    private double y;
    private double z;

    public Position(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

//    public static Position comparePositions(Position position1, Position position2) {
//
//        return new Position()
//    }

    public boolean isAbove(Position anotherPosition) {
        return this.getZ() > anotherPosition.getZ();
    }

    public boolean isUnder(Position anotherPosition) {
        return this.getZ() < anotherPosition.getZ();
    }

    public boolean isBySide(Position anotherPosition) {
        return this.getX() != anotherPosition.getX() || this.getY() != anotherPosition.getY();
    }
}
