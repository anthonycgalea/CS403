/**
 * This class provides for large scale information collection on buildings.
 * @author Anthony Galea
 */
public class Neighborhood {

    /**
     * This method takes an array of Building objects and converts the buildings to their string representations.
     * @param buildings An array of Building objects
     * @return Returns an array of string representations of the buildings provided
     */
    public static String[] getInfo(Building buildings[]) {
        String[] info = new String[buildings.length];
        for (int i = 0; i < buildings.length; i++) {
            info[i]=buildings[i].toString();
        }
        return info;
    }

    /**
     * This method finds the total amount of land that the lots buildings occupy consume.
     * @param buildings An array of building objects
     * @return The total area consumed.
     */
    public static int calcArea(Building[] buildings) {
        int totArea=0;
        for (int i = 0; i < buildings.length; i++) {
            totArea+=buildings[i].calcLotArea();
        }
        return totArea;
    }
}
