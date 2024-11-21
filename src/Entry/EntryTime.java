package Entry;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EntryTime {
    private static final LocalDateTime entryTime = LocalDateTime.now();
    private static final String ENTRY_TIME_FILE = "Entry_Time.txt";

    EntryTime()
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(ENTRY_TIME_FILE))){
            writer.write(entryTime.toString());
        } catch (IOException e) {
            System.out.println("Error saving time: " + e.getMessage());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy hh:mm a");

        String formattedTime = entryTime.format(formatter);

        System.out.println("Entry time is " + formattedTime);
    }
}
