package Qualifying2021Package;

import java.util.HashMap;
import java.util.Map;

public class Street {
    private String name;
    private int startIntersection;
    private int endIntersection;
    private int timeToTravel;
    private HashMap<Car, Integer> carsPresent = new HashMap<Car, Integer>();

    public Street(String name, int startIntersection, int endIntersection, int timeToTravel) {
        this.name = name;
        this.startIntersection = startIntersection;
        this.endIntersection = endIntersection;
        this.timeToTravel = timeToTravel;
    }

    public String getName() {
        return name;
    }

    public int getStartIntersection() {
        return startIntersection;
    }

    public int getEndIntersection() {
        return endIntersection;
    }

    public int getTimeToTravel() {
        return timeToTravel;
    }

    public void addCar(Car car) {
        carsPresent.put(car, timeToTravel);
    }

    public void advanceCars() {
        for (Map.Entry<Car, Integer> car : carsPresent.entrySet()) {
            Car key = car.getKey();
            carsPresent.put(key, carsPresent.get(key) - 1);
        }
    }

    public boolean carsReachedIntersection() {
        return carsPresent.containsValue(0);
    }

    public boolean getCarAtIntersection() {
        for (Map.Entry<Car, Integer> car : carsPresent.entrySet()) {
            if (car.getValue() = 0) {
                Car car2 = car.getKey();

                carsPresent.remove(car2);

                return car2;
            }
        }
    }
}