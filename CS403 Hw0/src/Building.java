/**
 * This class provides a framework for constructing building Objects, including getters and setters.
 * @author Anthony Galea
 */
public class Building {
    private int mLength;
    private int mWidth;
    private int mLotLength;
    private int mLotWidth;

    /**
     * Getter for length.
     * @return Length of building
     */
    public int getLength() {
        return mLength;
    }

    /**
     * Getter for width
     * @return Width of building
     */
    public int getWidth() {
        return mWidth;
    }

    /**
     * Getter for Lot Length
     * @return Length of the lot the building sits on.
     */
    public int getLotLength() {
        return mLotLength;
    }

    /**
     * Getter for lot width
     * @return Width of the lot the building sits on.
     */
    public int getLotWidth() {
        return mLotWidth;
    }

    /**
     * Setter/Modifier for the length of the building.
     * @param mLength New building length
     */
    public void setLength(int mLength) {
        this.mLength = mLength;
    }

    /**
     * Setter/Modifier for the width of the building
     * @param mWidth New building width
     */
    public void setWidth(int mWidth) {
        this.mWidth = mWidth;
    }

    /**
     * Setter/Modifier for the length of the lot the building sits on
     * @param mLotLength New building lot length
     */
    public void setLotLength(int mLotLength) {
        this.mLotLength = mLotLength;
    }

    /**
     * Setter/Modifier for the width of the lot the building sits on
     * @param mLotWidth New building lot width
     */
    public void setLotWidth(int mLotWidth) {
        this.mLotWidth = mLotWidth;
    }

    /**
     * Calculates the square footage of the building
     * @return The building's square feet.
     */
    public int calcBuildingArea() {
        return getLength()*getWidth();
    }

    /**
     * Calculates the square footage of the lot the building sits on
     * @return The lot's square feet.
     */
    public int calcLotArea() {
        return getLotWidth()*getLotLength();
    }


    /**
     * Overrides toString method for Object, creating a string representation of the building.
     * @return String representation of the building
     */
    public String toString() {
       // DONE: this
        return String.format("A %dX%d Building", getLength(), getWidth());
    }

    /**
     * Constructor for a Building object
     * @param length Length of the building
     * @param width Width of the building
     * @param lotLength Length of the lot
     * @param lotWidth Width of the lot
     */
    public Building(int length, int width, int lotLength, int lotWidth) {
        setLength(length);
        setWidth(width);
        setLotLength(lotLength);
        setLotWidth(lotWidth);
    }

}
