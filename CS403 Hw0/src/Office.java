/**
 * The office class builds off of building, and provides for parking spaces and counts for total offices.
 * @author Anthony Galea
 */
public class Office extends Building {

    private String mBusinessName;
    private int mParkingSpaces;
    public static int sTotalOffices=0;

    /**
     * Constructor for an Office object, using the Building superclass.
     * @param length Length of the office building
     * @param width Width of the office building
     * @param lotLength Length of the lot the office building sits on
     * @param lotWidth Width of the lot the office building sits on
     */
    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        setBusinessName(null);
        setParkingSpaces(0);
        sTotalOffices++;
    }

    /**
     * Constructor for an Office object, using the Building superclass, implementing the name of the business as well.
     * @param length Length of the office building
     * @param width Width of the office building
     * @param lotLength Length of the lot the office building sits on
     * @param lotWidth Width of the lot the office building sits on
     * @param businessName Name of the business that operates out of the office
     */
    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        this(length, width, lotLength, lotWidth);
        setBusinessName(businessName);
    }

    /**
     * Constructor for an Office object, using the Building superclass, implementing the amount of parking spaces at the office available.
     * @param length Length of the office building
     * @param width Width of the office building
     * @param lotLength Length of the lot the office building sits on
     * @param lotWidth Width of the lot the office building sits on
     * @param businessName Name of the business that operates out of the office
     * @param parkingSpaces Number of parking spaces available at the office
     */
    public Office(int length, int width, int lotLength, int lotWidth, String businessName, int parkingSpaces) {
        this(length, width, lotLength, lotWidth, businessName);
        setParkingSpaces(parkingSpaces);
    }

    /**
     * Getter for the name of the business
     * @return Name of the business
     */
    public String getBusinessName() {
        return this.mBusinessName;
    }

    /**
     * Getter for the parking spaces variable
     * @return Number of parking spaces available
     */
    public int getParkingSpaces() {
        return this.mParkingSpaces;
    }

    /**
     * Setter for the name of the business
     * @param name Name of the business
     */
    public void setBusinessName(String name) {
        this.mBusinessName=name;
    }

    /**
     * Setter for the number of parking spaces at the business
     * @param spaces Number of parking spaces at the office
     */
    public void setParkingSpaces(int spaces) {
        this.mParkingSpaces=spaces;
    }

    /**
     * Retrieves static variable sTotalOffices and returns it to user
     * @return Number of Office objects created.
     */
    public static int getTotalOffices() {
        return Office.sTotalOffices;
    }

    /**
     * Overrides Building toString method and adds onto the building toString method to add more information.
     * @return String representation of Office building
     */
    public String toString() {
        String s = super.toString() + "; ";
        s+="Business: ";
        if (getBusinessName()==null) {
            s+="unoccupied ";
        } else {
            s+=getBusinessName();
        }
        if (getParkingSpaces()!=0) {
            s+="; has " + getParkingSpaces() + " parking spaces ";
        }

        s+="(total offices: " + getTotalOffices() + ")";
        return s;
    }

    /**
     * Checks whether two office buildings have the same square footage and amount of parking spaces.
     * @param obj Object being passed in (may be Office)
     * @return Whether the object passed in is considered "equal" to this office.
     */
    public boolean equals(Object obj) {
        Office off = (Office)obj;
        return ((calcBuildingArea()==off.calcBuildingArea()) && (off.getParkingSpaces()==getParkingSpaces()));
    }

}
