package edu.testing.part3_domain_model;

import edu.testing.part3_domain_model.objects.PhysicalObject;
import edu.testing.part3_domain_model.objects.utils.Relativity;
import edu.testing.part3_domain_model.objects.dimensions.PhysicalDimensions;

import java.util.List;
import java.util.Objects;

public class Space {
    private List<PhysicalObject> containedObjects;
    private List<Position> objectsPositions;
    private PhysicalDimensions dimensions;

    public Space(PhysicalDimensions dimensions, List<PhysicalObject> objects, List<Position> positions) {
        // assume that space is finite and can contain limited amount of objects
        this.dimensions = dimensions;
        this.containedObjects = objects;
        this.objectsPositions = positions;
    }

    public void addObject(PhysicalObject object, Position objectPosition) throws IllegalArgumentException {
        if (Objects.isNull(object) || Objects.isNull(objectPosition)) {
            throw new IllegalArgumentException("Object and position can not be nulls");
        }
        this.containedObjects.add(object);
        this.objectsPositions.add(objectPosition);
    }

    protected boolean isObjectBiggerThanSpace(PhysicalObject obj) {
        return this.dimensions.isCanFit(obj.getDimensions());
    }

    public boolean isObjectInsideAnyObjectInSpace(PhysicalObject possiblyInnerObject, Position possiblyInnerObjectPosition) {
        for (int i = 0; i < this.containedObjects.size(); i++) {
            if (Relativity.isInside(possiblyInnerObject, containedObjects.get(i), possiblyInnerObjectPosition, objectsPositions.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void addObject(PhysicalObject object) throws IllegalArgumentException {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException("Object can not be null");
        }
        this.containedObjects.add(object);
        Position objPosition = new Position(0, 0, 0);
        while (!isObjectInsideAnyObjectInSpace(object, objPosition)) {
            objPosition.setX(Math.random() * this.dimensions.getLength());
            objPosition.setY(Math.random() * this.dimensions.getWidth());
            objPosition.setX(Math.random() * this.dimensions.getHeight());
        }
        this.objectsPositions.add(objPosition);
    }

    public void removeObjectFromSpace(PhysicalObject object) throws IllegalArgumentException {
        Integer objIndex = null;
        for (int i = 0; i < this.containedObjects.size(); i++) {
            if (this.containedObjects.get(i).equals(object)) {
                objIndex = i;
                break;
            }
        }
        if (Objects.isNull(objIndex)) {
            throw new IllegalArgumentException("Searched object is not in this space");
        }
        this.containedObjects.remove(objIndex.intValue());
        this.objectsPositions.remove(objIndex.intValue());
    }

    public List<PhysicalObject> getContainedObjects() {
        return containedObjects;
    }

    public List<Position> getObjectsPositions() {
        return objectsPositions;
    }

    public PhysicalDimensions getDimensions() {
        return dimensions;
    }
}
