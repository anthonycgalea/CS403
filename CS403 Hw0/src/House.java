/**
 * This class takes the Building class and builds off of it to define characteristics of a house.
 * @author Anthony Galea
 */
public class House extends Building {
    private String mOwner;
    private boolean mPool;

    /**
     * Constructor for House using basic parameters
     * @param length Length of house
     * @param width Width of house
     * @param lotLength Length of lot house sits on
     * @param lotWidth Width of lot house sits on
     */
    public House(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
    }

    /**
     * Constructor for House with additional parameters for Owner
     * @param length Length of house
     * @param width Width of house
     * @param lotLength Length of lot house sits on
     * @param lotWidth Width of lot house sits on
     * @param owner Name of the owner of the house
     */
    public House(int length, int width, int lotLength, int lotWidth, String owner) {
        this(length, width, lotLength, lotWidth);
        setOwner(owner);
        setPool(false);
    }

    /**
     * Constructor for House with additional parameters for pool
     * @param length Length of house
     * @param width Width of house
     * @param lotLength Length of lot house sits on
     * @param lotWidth Width of lot house sits on
     * @param owner Name of the owner of the house
     * @param pool Indicates whether the house has a pool
     */
    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool) {
        this(length, width, lotLength, lotWidth, owner);
        setPool(pool);
    }

    /**
     * Getter for the owner of the house
     * @return Name of the owner of the house
     */
    public String getOwner() {
        if (mOwner==null) {
            return "n/a";
        }
        return mOwner;
    }

    /**
     * Getter for whether the house has a pool or not.
     * @return Whether there is a pool.
     */
    public boolean hasPool() {
        return mPool;
    }

    /**
     * Setter for the owner of the house
     * @param mOwner The new name for the owner of the house.
     */
    public void setOwner(String mOwner) {
        this.mOwner = mOwner;
    }

    /**
     * Setter for whether the house has a pool or not
     * @param mPool New value for whether there is a pool or not.
     */
    public void setPool(boolean mPool) {
        this.mPool = mPool;
    }

    /**
     * Checks whether two house objects have the same building area and both have the same pool value
     * @param obj The object to compare
     * @return Whether the two houses are considered equal.
     */
    public boolean equals(Object obj) {
        House house = (House)obj;
        return (calcBuildingArea() == house.calcBuildingArea() && (house.hasPool()==hasPool()));
    }

    /**
     * Creates a string representation of a House
     * @return The string representation
     */
    public String toString() {
        //Done:this
        String s = super.toString()+String.format("; Owner: %s", getOwner());
        if (hasPool()) {
            s+="; has a pool";
        }
        if (calcLotArea()-calcBuildingArea() > calcBuildingArea()) {
            s+="; has a big open space";
        }
        return s;
    }
}
