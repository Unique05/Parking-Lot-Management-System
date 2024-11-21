package Entry;

import java.util.Scanner;

public class AssigningSpot extends ParkingSpot{

    public AssigningSpot(){

        if(!parkingSpotFile.exists() || parkingSpotFile.length() == 0){
            defaultParkingSpot();
        }
        takeParkingSpot();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Chose a letter for car size allocation (S::small, M::medium, B::big): ");
        String carSize = scanner.nextLine().toLowerCase();

        switch (carSize) {
            case "s" -> {
                int smallIndex = 0;
                if (smallIndex < getSmallVehicles().size()) {
                    System.out.println("Drive to parking space number " + getSmallVehicles().get(smallIndex));
                    getSmallVehicles().remove(smallIndex); // removes parking spot from available
                    //System.out.println(getSmallVehicles());
                } else {
                    System.out.println("The parking lot is full");
                }
            }
            case "m" -> {
                int mediumIndex = 0;
                if (mediumIndex < getMediumVehicles().size()) {
                    System.out.println("Drive to parking space number " + getMediumVehicles().get(mediumIndex));
                    getMediumVehicles().remove(mediumIndex); // removes parking spot from available
                    //System.out.println(getMediumVehicles());
                } else {
                    System.out.println("The parking lot is full");
                }
            }
            case "b" -> {
                int bigIndex = 0;
                if (bigIndex < getBigVehicles().size()) {
                    System.out.println("Drive to parking space number " + getBigVehicles().get(bigIndex));;
                    getBigVehicles().remove(bigIndex); // removes parking spot from available
                    //System.out.println(getBigVehicles());
                } else {
                    System.out.println("The parking lot is full");
                }
            }
            default -> System.out.println("Input a valid letter!");
        }

        saveParkingSpot();
    }
}
