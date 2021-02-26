package hashcode.qualifying;

import java.util.ArrayList;

public class Intersection {
    private final int id;
    private final ArrayList<String> entryStreets = new ArrayList<String>();
    private final ArrayList<String> exitStreets = new ArrayList<String>();

    public Intersection(int id) {
        this.id = id;
    }

    public void addEntryStreet(String streetName){
        entryStreets.add(streetName);
    }

    public void addExitStreet(String streetName) {
        exitStreets.add(streetName);
    }

}
