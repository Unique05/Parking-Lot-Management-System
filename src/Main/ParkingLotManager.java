package Main;// Simulates a parking lot management system

import Entry.EntryHandler;
import Exit.ExitHandler;

import java.util.Scanner;

public class ParkingLotManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println();
            System.out.println("Press Q anytime to quit ");
            System.out.print("Driving in(IN) OR Driving out(OUT) : ");
            String inOrOut = scanner.nextLine().toUpperCase().trim();

            if (inOrOut.equals("IN")) {
                EntryHandler.handleEntry();
            } else if (inOrOut.equals("OUT")) {
                ExitHandler.handleExit();
            } else if (inOrOut.equals("Q")) {
                System.out.println("GoodBye :) ");
                break;
            } else {
                System.out.println("Enter a valid input (IN/OUT)");
            }

        }
        scanner.close();
    }
}
