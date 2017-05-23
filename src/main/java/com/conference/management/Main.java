package main.java.com.conference.management;

import main.java.com.conference.management.bo.Conference;
import main.java.com.conference.management.bo.Talk;
import main.java.com.conference.management.enums.DataOutputEnum;
import main.java.com.conference.management.enums.DataSourceEnum;
import main.java.com.conference.management.exceptions.UnsupportedDestinationException;
import main.java.com.conference.management.exceptions.UnsupportedSourceException;
import main.java.com.conference.management.util.ConferenceUtils;

import java.util.List;

/**
 * Created by girmes on 22/05/17.
 */
public class Main {

    public static void main(String[] args) {

        ConferenceManager conferenceManager = new ConferenceManager();
        List<Talk> talkList = null;
        // Fetch the input talk list.
        try {
            talkList = conferenceManager.fetchTalksListFromSource(DataSourceEnum.FILE);
        } catch (UnsupportedSourceException e){
            System.err.println(e.getMessage());
        }

        if(talkList == null || talkList.size() == 0)
            return;

        // Print talks.
        ConferenceUtils.printTalks(talkList);

        // Process and schedule talks into events and slots.
        Conference conference = conferenceManager.processAndScheduleTalks(talkList);

        // Output the conference events.
        try {
            conferenceManager.outputConferenceSchedule(conference, DataOutputEnum.CONSOLE);
        } catch (UnsupportedDestinationException e){
            System.err.println(e.getMessage());
        }

    }
}
