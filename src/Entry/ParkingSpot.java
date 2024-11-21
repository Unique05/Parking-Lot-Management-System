package Entry;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ParkingSpot {

    File parkingSpotFile = new File("Parking_Spot.txt");

    private String[] originalSmallVehicles = new String[50];
    private String[] originalMediumVehicles = new String[30];
    private String[] originalBigVehicles = new String[20];

    private ArrayList<String> smallVehicles = new ArrayList<>(); //Available parking spots for small vehicles
    private ArrayList<String> mediumVehicles = new ArrayList<>(); //Available parking spots for medium vehicles
    private ArrayList<String> bigVehicles = new ArrayList<>(); //Available parking spots for big vehicles

    public ParkingSpot() {
        for (int i = 0; i < originalSmallVehicles.length; i++) { //there are 50 parking spots for small vehicles
            originalSmallVehicles[i] = ("SM" + "00" + (i + 1));
        }

        for (int i = 0; i < originalMediumVehicles.length; i++) { //there are 50 parking spots for small vehicles
            originalMediumVehicles[i] = ("MD" + "00" + (i + 1));
        }

        for (int i = 0; i < originalBigVehicles.length; i++) { //there are 50 parking spots for small vehicles
            originalBigVehicles[i] = ("BG" + "00" + (i + 1));
        }
    }

    public void defaultParkingSpot() {
        smallVehicles.clear();
        mediumVehicles.clear();
        bigVehicles.clear();

        //convert the arrays to an array lists | Note: Wrap the resulting list in an ArrayList so as to possible modify it (add/remove elements).
        smallVehicles = new ArrayList<>(Arrays.asList(originalSmallVehicles));
        mediumVehicles = new ArrayList<>(Arrays.asList(originalMediumVehicles));
        bigVehicles = new ArrayList<>(Arrays.asList(originalBigVehicles));
    }

    public String[] getOriginalSmallVehicles() {
        return this.originalSmallVehicles;
    }

    public String[] getOriginalMediumVehicles(){
        return this.originalMediumVehicles;
    }

    public String[] getOriginalBigVehicles(){
        return  this.originalBigVehicles;
    }

    public ArrayList<String> getSmallVehicles() {
        return smallVehicles;
    }

    public ArrayList<String> getMediumVehicles() {
        return mediumVehicles;
    }

    public ArrayList<String> getBigVehicles() {
        return bigVehicles;
    }

    public void saveParkingSpot() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(parkingSpotFile))) {
            writer.write("Small_Vehicles\n");
            for (String vehicle : smallVehicles) { //saves each smallVehicle element on a new line in the file
                writer.write(vehicle + "\n");
            }
            writer.write("Medium_Vehicles\n");
            for (String vehicle : mediumVehicles) { //saves each mediumVehicle element on a new line in the file
                writer.write(vehicle + "\n");
            }
            writer.write("Big_Vehicles\n");
            for (String vehicle : bigVehicles) { //saves each bigVehicle element on a new line in the file
                writer.write(vehicle + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving Parking spots " + e.getMessage());
        }
    }

    public void takeParkingSpot() {//reads the saved vehicle from the file and saves them to their respective array lists
        try (BufferedReader reader = new BufferedReader(new FileReader(parkingSpotFile))) {
            String line;
            ArrayList<String> currentList = null;
            while ((line = reader.readLine()) != null) {
                switch (line) {
                    case "Small_Vehicles":
                        currentList = smallVehicles;
                        break;
                    case "Medium_Vehicles":
                        currentList = mediumVehicles;
                        break;
                    case "Big_Vehicles":
                        currentList = bigVehicles;
                        break;
                    default:
                        if (currentList != null) {
                            currentList.add(line);
                        }
                        break;

                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

