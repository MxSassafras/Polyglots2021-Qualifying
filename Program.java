import Qualifying2021Package.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
import java.util.Comparator;
import java.util.Collections;

public class Program {
    private static int stopSignCount = 1;

    private static int duration;
    private static int numberOfIntersections;
    private static int numberOfStreets;
    private static int numberOfCars;
    private static int bonusPoints;

    private static ArrayList<Street> inputStreets = new ArrayList<Street>();
    private static ArrayList<Car> inputCars = new ArrayList<Car>();
    private static ArrayList<ArrayList<String>> intersections = new ArrayList<ArrayList<String>>();
    private static ArrayList<ArrayList<String>> usedIntersections = new ArrayList<ArrayList<String>>();
    private static HashMap<String, String> usedStreets = new HashMap<String, String>();

    public static void main (String[] args) {
        String fileName = args[0];
        ReadInput(fileName);
        Calculation();
        String outputString = BuildOutputString();
        WriteOutput(fileName, outputString);
    }

    public static void Calculation() {
//        Collections.sort(pizzas, new Comparator<Pizza>() {
//            @Override public int compare(Pizza p1, Pizza p2) {
//                return p2.getIngredients().size() - p1.getIngredients().size();
//            }
//        });
        for (int i = 0; i < intersections.size(); i++) {
            for (int j = 0; j < intersections.get(i).size(); j++) {
                String streetName = intersections.get(i).get(j);
                if (usedStreets.containsKey(streetName)) {
                    usedIntersections.get(i).add(streetName);
                }
            }
        }
    }

    private static String BuildOutputString() {
        String outputString = "";

        int countUsedIntersections = 0;

        for (int i = 0; i < usedIntersections.size(); i++) {
            if (!(usedIntersections.get(i).size() == 0)) {
                countUsedIntersections += 1;
            }
        }

        outputString += String.valueOf(countUsedIntersections) + "\n";

        for (int i = 0; i < usedIntersections.size(); i++) {
            if (usedIntersections.get(i).size() > 0) {
                outputString += String.valueOf(i) + "\n";

                int intersectionStreetCount = usedIntersections.get(i).size();
                outputString += String.valueOf(intersectionStreetCount) + "\n";

                for (int j = 0; j < intersectionStreetCount; j++) {
                    outputString += intersections.get(i).get(j) + " " + String.valueOf(stopSignCount);
                    if (j < intersectionStreetCount) {
                        outputString += "\n";
                    }
                }
            }
        }

//        int numberOfOrders = orders.size();
//
//        outputString += String.valueOf(numberOfOrders) + "\n";

//        for (int i = 0; i < orders.size(); i++) {
//            outputString += String.valueOf(orders.get(i).getTeamSize()) + " ";
//            for (int j = 0; j < orders.get(i).getPizzas().size(); j++) {
//                outputString += String.valueOf(orders.get(i).getPizzas().get(j).getId());
//
//                if (j < orders.get(i).getPizzas().size() - 1) {
//                    outputString += " ";
//                }
//            }
//            if (i < orders.size() - 1) {
//                outputString += "\n";
//            }
//        }

        return outputString;
    }

    private static void ReadInput(String name) {
        String inputPath = "InputFiles\\" + name + ".txt";
        System.out.println(inputPath);

        try {
            File myObj = new File(inputPath);
            Scanner myReader = new Scanner(myObj);

            // Gather first line data
            String firstRow = myReader.nextLine();

            duration = Integer.parseInt(firstRow.split(" ")[0]);
            numberOfIntersections = Integer.parseInt(firstRow.split(" ")[1]);
            numberOfStreets = Integer.parseInt(firstRow.split(" ")[2]);
            numberOfCars = Integer.parseInt(firstRow.split(" ")[3]);
            bonusPoints = Integer.parseInt(firstRow.split(" ")[4]);

            for (int i = 0; i < numberOfIntersections; i++) {
                intersections.add(new ArrayList<String>());
                usedIntersections.add(new ArrayList<String>());
            }

            for (int i = 0; i < numberOfStreets; i++) {
                String data = myReader.nextLine();

                int startingIntersection = Integer.parseInt(data.split(" ")[0]);
                int endingIntersection = Integer.parseInt(data.split(" ")[1]);
                String streetName = data.split(" ")[2];
                int timeToTravel = Integer.parseInt(data.split(" ")[3]);

                Street street = new Street(streetName, startingIntersection, endingIntersection, timeToTravel);

                intersections.get(endingIntersection).add(streetName);

                //inputStreets.add(street);
            }

            for (int i = 0; i < numberOfCars; i++) {
                String data = myReader.nextLine();

                ArrayList<String> path = new ArrayList<String>();

                int numberOfStreetsToTravel = Integer.parseInt(data.split(" ")[0]);

                for (int j = 1; j <= numberOfStreetsToTravel; j++) {
                    String streetName = data.split(" ")[j];
                    usedStreets.put(streetName, "");
                    path.add(streetName);
                }

                Car car = new Car(path);
                inputCars.add(car);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    private static String CreateFileName(String name) {
        int count = 1;
        boolean exists;

        String stringCount;

        do {
            stringCount = String.valueOf(count);

            if (stringCount.length() == 1) {
                stringCount = "0" + stringCount;
            }

            File tempFile = new File("OutputFiles\\" + name + stringCount + ".txt");
            exists = tempFile.exists();

            if (exists) {
                count += 1;
            }
        } while (exists);

        return "OutputFiles\\" + name + stringCount + ".txt";
    }

    private static void WriteOutput(String name, String str) {
        String outputPath = CreateFileName(name);

        try {
            File file = new File(outputPath);

            try(FileWriter writer = new FileWriter(outputPath)) {
                writer.write(str);
                writer.flush();
            } catch (Exception e) {
                System.out.println("An error occured.");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}