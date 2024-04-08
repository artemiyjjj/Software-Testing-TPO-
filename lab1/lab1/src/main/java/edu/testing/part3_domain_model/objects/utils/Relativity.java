package edu.testing.part3_domain_model.objects.utils;

import edu.testing.part3_domain_model.Position;
import edu.testing.part3_domain_model.objects.PhysicalObject;

public class Relativity {

    /**
     * Defines if obj1 contains obj2
     */
    public static boolean isInside(PhysicalObject obj1, PhysicalObject obj2, Position pos1, Position pos2) {
//        if (!obj2.getDimensions().isCanFit(obj1.getDimensions())) {
//            return false;
//        }
        double pos1LengthMin = pos1.getX() - obj1.getDimensions().getLength() / 2;
        double pos1LengthMax = pos1.getX() + obj1.getDimensions().getLength() / 2;
        double pos1WidthMin = pos1.getY() - obj1.getDimensions().getWidth() / 2;
        double pos1WidthMax = pos1.getY() + obj1.getDimensions().getWidth() / 2;
        double pos1HeightMin = pos1.getZ() - obj1.getDimensions().getHeight() / 2;
        double pos1HeightMax = pos1.getZ() + obj1.getDimensions().getHeight() / 2;

        double pos2LengthMin = pos2.getX() - obj2.getDimensions().getLength() / 2;
        double pos2LengthMax = pos2.getX() + obj2.getDimensions().getLength() / 2;
        double pos2WidthMin = pos2.getY() - obj2.getDimensions().getWidth() / 2;
        double pos2WidthMax = pos2.getY() + obj2.getDimensions().getWidth() / 2;
        double pos2HeightMin = pos2.getZ() - obj2.getDimensions().getHeight() / 2;
        double pos2HeightMax = pos2.getZ() + obj2.getDimensions().getHeight() / 2;

        boolean isPartlyInside = ((pos2LengthMin >= pos1LengthMin && pos2LengthMin < pos1LengthMax) || (pos2LengthMax <= pos1LengthMax && pos2LengthMax > pos1LengthMin))
                && ((pos2WidthMin >= pos1WidthMin && pos2WidthMin < pos1WidthMax) || (pos2WidthMax <= pos1WidthMax && pos2WidthMax > pos1WidthMin))
                && ((pos2HeightMin >= pos1HeightMin && pos2HeightMin < pos1HeightMax) || (pos2HeightMax <= pos1HeightMax && pos2HeightMax > pos1HeightMin));
        return isPartlyInside;
    }
}
