package Exit;

import Entry.ParkingSpot;

import java.util.Arrays;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class ExitHandler {
    public static void main(String[] args) {
        handleExit();
    }

    public static void handleExit(){

        while(true) {
            System.out.print("Input your parking space serial number (E.g **00**): ");
            Scanner scanner = new Scanner(System.in);
            String parkingSpotSN = scanner.nextLine().toUpperCase().trim();
            ParkingSpot parkingSpot = new ParkingSpot();
            parkingSpot.takeParkingSpot();

            boolean isInOriginalSpots = (Arrays.asList(parkingSpot.getOriginalSmallVehicles()).contains(parkingSpotSN)
                    || Arrays.asList(parkingSpot.getOriginalMediumVehicles()).contains(parkingSpotSN)
                    || Arrays.asList(parkingSpot.getOriginalBigVehicles()).contains(parkingSpotSN));

            boolean isInFreeSpots = (parkingSpot.getSmallVehicles().contains(parkingSpotSN)
                    || parkingSpot.getMediumVehicles().contains(parkingSpotSN)
                    || parkingSpot.getBigVehicles().contains(parkingSpotSN));

            if (isInOriginalSpots && !isInFreeSpots) {
                PriceCalculator calculatePrice = new PriceCalculator();
                TimeCalculator calculateTime = new TimeCalculator();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy hh:mm a");
                System.out.println("Exit time is " + calculateTime.exitTime.format(formatter));
                if (Arrays.asList(parkingSpot.getOriginalSmallVehicles()).contains(parkingSpotSN)) {
                    parkingSpot.getSmallVehicles().add(parkingSpotSN);
                } else if (Arrays.asList(parkingSpot.getOriginalMediumVehicles()).contains(parkingSpotSN)) {
                    parkingSpot.getMediumVehicles().add(parkingSpotSN);
                } else {
                    parkingSpot.getBigVehicles().add(parkingSpotSN);
                }
                parkingSpot.saveParkingSpot();
                break;
            } else {
                System.out.println("Enter a valid serial number! ");
            }
        }
    }
}
