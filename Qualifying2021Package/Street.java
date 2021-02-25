package Qualifying2021Package;

import java.util.HashMap;

public class Street {
    private string name;
    private int startIntersection;
    private int endIntersection;
    private int timeToTravel;
    private HashMap<Car, int> carsPresent = new HashMap<Car, int>();

    public Street(string name, int startIntersection, int endIntersection, int timeToTravel) {
        this.name = name;
        this.startIntersection = startIntersection;
        this.endIntersection = endIntersection;
        this.timeToTravel = timeToTravel;
    }

    public string getName() {
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
        for (Map.Entry<Car, int> car : carsPresent.entrySet()) {
            Car key = car.getKey();
            map.put(key, map.get(key) - 1);
        }
    }

    public boolean carsReachedIntersection() {
        for (Map.Entry<Car, int> car : carsPresent.entrySet()) {
            car.value = car.value - 1;
        }
    }
}