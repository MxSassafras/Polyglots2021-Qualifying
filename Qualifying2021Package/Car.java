package Qualifying2021Package;

import java.util.ArrayList;

public class Car {
    private int id;
    private static int nextId = 1;

    private ArrayList<String> path;

    public Car() {
        this.id = nextId;
        nextId++;
    }

    public Car(ArrayList<String> path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getPath() {
        return path;
    }

    public void setPath(ArrayList<String> path) {
        this.path = path;
    }
}