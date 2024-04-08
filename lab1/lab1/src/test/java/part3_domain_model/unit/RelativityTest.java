package part3_domain_model.unit;

import edu.testing.part3_domain_model.Position;
import edu.testing.part3_domain_model.objects.PhysicalObject;
import edu.testing.part3_domain_model.objects.dimensions.PhysicalDimensions;
import edu.testing.part3_domain_model.objects.utils.Relativity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RelativityTest {
    @Test
    public void testInside() {
        PhysicalObject ship = new PhysicalObject(
                "Star ship 'Zolotoye Serdce'",
                new PhysicalDimensions(150, 30, 10),
                PhysicalObject.Color.WHITE);
        Position shipPosition = new Position(1000, 1000, 1000);


        PhysicalObject box = new PhysicalObject(
                "Box",
                new PhysicalDimensions(0.5d, 0.4, 0.4),
                PhysicalObject.Color.GOLDEN);
        Position boxPosition = new Position(1000, 1000, 1000);

        Assertions.assertTrue(Relativity.isInside(ship, box, shipPosition, boxPosition));
    }

}
