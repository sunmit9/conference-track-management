package main.java.com.conference.management.util;

import main.java.com.conference.management.bo.Talk;

import java.util.Calendar;
import java.util.List;

/**
 * Created by girmes on 22/05/17.
 */
public class ConferenceUtils {

    public static Calendar getCalendarTime(int hours, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
        return cal;
    }

    public static Calendar getNextStartTime(Calendar currentStartTime, Talk currentTalk) {
        Calendar newTime = Calendar.getInstance();
        newTime.set(Calendar.HOUR_OF_DAY, currentStartTime.get(Calendar.HOUR_OF_DAY));
        newTime.set(Calendar.MINUTE, currentStartTime.get(Calendar.MINUTE));
        newTime.add(Calendar.MINUTE, currentTalk.getDurationInMinutes());
        return newTime;
    }

    public static void printTalks(List<Talk> talkList) {
        System.out.println("--------------------------------------------------------");
        System.out.println("Input talks:");
        for (Talk talk : talkList) {
            // Print the prepared talk's title for this Track
            System.out.println(talk.getTitle() + " " + talk.getDurationInMinutes());
        }
        System.out.println("--------------------------------------------------------");
    }

}
