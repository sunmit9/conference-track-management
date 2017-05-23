package main.java.com.conference.management.io;

import main.java.com.conference.management.ConferenceManagementConfig;
import main.java.com.conference.management.bo.*;
import main.java.com.conference.management.bo.Event;
import main.java.com.conference.management.bo.Track;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by girmes on 22/05/17.
 */
public class ConsoleOutputManager {

    public void printSchedule (Conference conference) {

        SimpleDateFormat sdf = ConferenceManagementConfig.DATE_FORMAT;
        System.out.println("Output: Conference Schedule :");
        System.out.println("--------------------------------------------------------");
        for(Track track : conference.getTracks()){
            System.out.println("Track " + track.getTrackId());
            List<Slot> slots = track.getSlots();
            System.out.println("");

            // Output the talks into tracks based on the totalTalks and the count of Talks.
            for (Slot slot : slots) {

                for (Event event : slot.getEvents()) {
                    // Print the prepared talk's title for this Track
                    System.out.println(sdf.format(event.getStartTime().getTime()) + " " + event.getTitle()
                            + " " + event.getDurationInMinutes());
                }
            }
            System.out.println("--------------------------------------------------------");
        }
    }

}
