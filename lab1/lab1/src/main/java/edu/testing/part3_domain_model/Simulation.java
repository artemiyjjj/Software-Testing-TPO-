package edu.testing.part3_domain_model;

import edu.testing.part3_domain_model.objects.AbstractObject;
import edu.testing.part3_domain_model.objects.PhysicalObject;
import edu.testing.part3_domain_model.objects.dimensions.AbstractDimensions;
import edu.testing.part3_domain_model.objects.dimensions.Dimensions;
import edu.testing.part3_domain_model.objects.dimensions.PhysicalDimensions;
import edu.testing.part3_domain_model.objects.utils.Relativity;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Space space;
    /** List of ever invented pribors in simulation. The order of mind incomprehence if defined by ascending order of elements indices.  */
    private List<AbstractObject> everInventedPribors;
    private List<PhysicalObject> uniquePhysicalObjectsInGalaxyHistory;

    public void start() {
        this.everInventedPribors = new ArrayList<>();
        this.uniquePhysicalObjectsInGalaxyHistory = new ArrayList<>();

        PhysicalDimensions simulationDimensions = new PhysicalDimensions(100000, 100000, 100000);
        List<PhysicalObject> objects = new ArrayList<>();
        List<Position> positions = new ArrayList<>();

        PhysicalObject kupol = new PhysicalObject(
                "Kupol",
                new PhysicalDimensions(300, 100, 10),
                PhysicalObject.Color.TRANSPARENT
        );
        objects.add(
                kupol
        );
        Position kupolPosition = new Position(1000, 1000, 1050);
        positions.add(kupolPosition);

        PhysicalObject ship = new PhysicalObject(
                "Star ship 'Zolotoye Serdce'",
                new PhysicalDimensions(150, 30, 10),
                PhysicalObject.Color.WHITE);
        if (ship.isBeautiful()) {
            ship.addSpecialCharacteristics(PhysicalObject.SpecialCharacteristics.INSANELY_BEAUTIFUL);
        }
        ship.addSpecialCharacteristics(PhysicalObject.SpecialCharacteristics.GIANT);
        objects.add(
               ship
        );
        Position shipPosition = new Position(1000, 1000, 1000);
        positions.add(shipPosition);

        PhysicalObject box = new PhysicalObject(
                "Box",
                new PhysicalDimensions(0.5d, 0.4, 0.4),
                PhysicalObject.Color.GOLDEN);
        box.addSpecialCharacteristics(PhysicalObject.SpecialCharacteristics.INVISIBLE);
        objects.add(
                box
        );
        Position boxPosition = new Position(1000, 1000, 1000);
        positions.add(boxPosition);

        AbstractObject priborPrototype = new AbstractObject(
                "Prototype of most mindblowing pribor",
                new AbstractDimensions(3, 0.3, 0.3, 0.2)
        );
        PhysicalObject pribor = new PhysicalObject(
                "Pribor 'Zolotoye Serdce'",
                priborPrototype,
                new PhysicalDimensions(0.3, 0.3, 0.2),
                PhysicalObject.Color.BLACK
        );
        pribor.addSpecialCharacteristics(PhysicalObject.SpecialCharacteristics.MIND_INCOMPREHENSIBLE);
        objects.add(
                pribor
        );
        Position priborPosition = new Position(1000, 1000, 1000);
        positions.add(priborPosition);

        this.space = new Space(simulationDimensions, objects, positions);

        if (Relativity.isInside(ship, pribor, shipPosition, priborPosition)) {
            uniquePhysicalObjectsInGalaxyHistory.add(ship);
        }
        everInventedPribors.add(
                priborPrototype
        );
    }

    public Space getSpace() {
        return space;
    }

    public List<AbstractObject> getEverInventedPribors() {
        return everInventedPribors;
    }

    public List<PhysicalObject> getUniquePhysicalObjectsInGalaxyHistory() {
        return uniquePhysicalObjectsInGalaxyHistory;
    }
}
