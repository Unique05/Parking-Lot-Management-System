package Exit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Duration;


public class TimeCalculator {
    private static final String EntryTimeFile = "Entry_Time.txt";
    LocalDateTime entryTime;
    LocalDateTime exitTime;
    public long timeDifferenceInMinutes;

    TimeCalculator(){

        try(BufferedReader reader = new BufferedReader(new FileReader(EntryTimeFile))){ //gets the time of entry from Entry_Time file
           String timeString = reader.readLine();
           entryTime = LocalDateTime.parse(timeString);// convert string back to LocalTime
        } catch (IOException e) {
            System.out.println("Error reading saved time: " + e.getMessage());
        }

        exitTime = LocalDateTime.now();

        if(entryTime == null){
            System.out.println("Entry time is Null");
        }

        Duration differenceInTime = Duration.between(entryTime, exitTime);
        timeDifferenceInMinutes = differenceInTime.toMinutes();
  }
}
