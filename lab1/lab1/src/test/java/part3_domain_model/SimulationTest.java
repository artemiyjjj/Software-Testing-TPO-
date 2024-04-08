package part3_domain_model;

import edu.testing.part3_domain_model.Simulation;
import edu.testing.part3_domain_model.objects.PhysicalObject;
import edu.testing.part3_domain_model.objects.utils.Relativity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimulationTest {

    @Test
    public void testSimulation() {
        Simulation simulation = new Simulation();
        simulation.start();
        var space = simulation.getSpace();
        var kupol = space.getContainedObjects().get(0);
        var ship = space.getContainedObjects().get(1);
        var box = space.getContainedObjects().get(2);
        var pribor = space.getContainedObjects().get(3);

        var kupolPos = space.getObjectsPositions().get(0);
        var shipPos = space.getObjectsPositions().get(1);
        var boxPos = space.getObjectsPositions().get(2);
        var priborPos = space.getObjectsPositions().get(3);

        Assertions.assertTrue(kupolPos.isAbove(shipPos));
        Assertions.assertTrue(shipPos.isUnder(kupolPos));

        Assertions.assertEquals(ship.getColor(), PhysicalObject.Color.WHITE);
        Assertions.assertEquals(ship.getDimensions().getLength(), 150d);
        Assertions.assertEquals(ship.getShape(), PhysicalObject.Shape.CROSSOVKA);
        Assertions.assertTrue(ship.getSpecialCharacteristics().contains(PhysicalObject.SpecialCharacteristics.GIANT));
        Assertions.assertTrue(ship.getSpecialCharacteristics().contains(PhysicalObject.SpecialCharacteristics.INSANELY_BEAUTIFUL));

        Assertions.assertTrue(Relativity.isInside(ship, box, shipPos, boxPos));
        Assertions.assertEquals(box.getColor(), PhysicalObject.Color.GOLDEN);
        Assertions.assertTrue(Relativity.isInside(box, pribor, boxPos, priborPos));
        Assertions.assertTrue(simulation.getEverInventedPribors().contains(pribor.getPrototype()));
        Assertions.assertTrue(Relativity.isInside(ship, pribor, shipPos, priborPos));
        Assertions.assertTrue(simulation.getUniquePhysicalObjectsInGalaxyHistory().contains(ship));

        String shipName = ship.getName().substring(ship.getName().indexOf("'")+1, ship.getName().lastIndexOf("'"));
        String priborName = pribor.getName().substring(pribor.getName().indexOf("'")+1, pribor.getName().lastIndexOf("'"));
        Assertions.assertEquals(shipName, priborName);
    }
}
