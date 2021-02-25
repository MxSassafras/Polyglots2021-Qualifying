package Qualifying2021Package;

import java.util.ArrayList;

public class Intersection {
    private int id;
    private ArrayList<String> entryStreets = new ArrayList<String>();
    private ArrayList<String> exitStreets = new ArrayList<String>();
    private ArrayList<Light> lights = new ArrayList<Light>();

    public Intersection(int id) {
        this.id = id;
    }

    public void addEntryStreet(String streetName) {
        entryStreets.add(streetName);

        //Light light = new Light(streetName);

        //lights.add(light);
    }

    public void addExitStreet(String streetName) {
        exitStreets.add(streetName);
    }
}