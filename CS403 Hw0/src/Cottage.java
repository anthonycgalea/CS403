/**
 * The Cottage class builds off of the House class, requiring square dimensions with additional option for a second floor.
 * @author Anthony Galea
 */
public class Cottage extends House{
    private boolean mSecondFloor;

    /**
     * Constructor for Cottage
     * @param dimension Length and width of the Cottage
     * @param lotLength Length of the lot the cottage sits on
     * @param lotWidth Width of the lot the cottage sits on
     */
    public Cottage(int dimension, int lotLength, int lotWidth) {
        super(dimension, dimension, lotLength, lotWidth);
        this.mSecondFloor=false;
    }

    /**
     * Constructor for Cottage
     * @param dimension Length and width of the Cottage
     * @param lotLength Length of the lot the cottage sits on
     * @param lotWidth Width of the lot the cottage sits on
     * @param owner Name of the owner of the cottage
     * @param secondFloor Indicator for whether the cottage has a second floor
     */
    public Cottage(int dimension, int lotLength, int lotWidth, String owner, boolean secondFloor) {
        super(dimension, dimension, lotLength, lotWidth, owner);
        this.mSecondFloor=secondFloor;
    }

    /**
     * Getter for whether the cottage has a second floor.
     * @return True or false, whether the cottage has a second floor.
     */
    public boolean hasSecondFloor() {
        return this.mSecondFloor;
    }

    /**
     * ToString method creating a string representation of the cottage.
     * @return String representation of the cottage
     */
    public String toString() {
        String s = super.toString();
        if (hasSecondFloor()) {
            s+="; is a two story cottage";
        } else {
            s+="; is a cottage";
        }
        return s;
    }
}
