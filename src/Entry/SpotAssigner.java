package Entry;

import java.util.Scanner;

public class SpotAssigner  {

    public SpotAssigner() {

        ParkingSpot parkingSpot = new ParkingSpot();

        if (!parkingSpot.parkingSpotFile.exists() || parkingSpot.parkingSpotFile.length() == 0) {
            parkingSpot.defaultParkingSpot();
        }
        parkingSpot.takeParkingSpot();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Chose a letter for car size allocation (S::small, M::medium, B::big): ");
        String carSize = scanner.nextLine().toLowerCase();

        switch (carSize) {
            case "s" -> {
                int smallIndex = 0;
                if (smallIndex < parkingSpot.getSmallVehicles().size()) {
                    System.out.println("Drive to parking space number " + parkingSpot.getSmallVehicles().get(smallIndex));
                    parkingSpot.getSmallVehicles().remove(smallIndex); // removes parking spot from available
                    //System.out.println(getSmallVehicles());
                } else {
                    System.out.println("The parking lot is full");
                }
            }
            case "m" -> {
                int mediumIndex = 0;
                if (mediumIndex < parkingSpot.getMediumVehicles().size()) {
                    System.out.println("Drive to parking space number " + parkingSpot.getMediumVehicles().get(mediumIndex));
                    parkingSpot.getMediumVehicles().remove(mediumIndex); // removes parking spot from available
                    //System.out.println(getMediumVehicles());
                } else {
                    System.out.println("The parking lot is full");
                }
            }
            case "b" -> {
                int bigIndex = 0;
                if (bigIndex < parkingSpot.getBigVehicles().size()) {
                    System.out.println("Drive to parking space number " + parkingSpot.getBigVehicles().get(bigIndex));
                    parkingSpot.getBigVehicles().remove(bigIndex); // removes parking spot from available
                    //System.out.println(getBigVehicles());
                } else {
                    System.out.println("The parking lot is full");
                }
            }
            default -> System.out.println("Input a valid letter!");
        }

        parkingSpot.saveParkingSpot();
    }
}
