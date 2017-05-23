package com.conference.management;

import com.conference.management.bo.Conference;
import com.conference.management.bo.Talk;
import com.conference.management.enums.DataOutputEnum;
import com.conference.management.enums.DataSourceEnum;
import com.conference.management.exceptions.UnsupportedDestinationException;
import com.conference.management.exceptions.UnsupportedSourceException;
import com.conference.management.util.ConferenceUtils;

import java.util.List;

/**
 * Created by girmes on 22/05/17.
 */
public class Main {

    public static void main(String[] args) {

        ConferenceManager conferenceManager = new ConferenceManager();
        List<Talk> talkList = null;
        try {
            talkList = conferenceManager.fetchTalksListFromSource(DataSourceEnum.FILE);
        } catch (UnsupportedSourceException e){
            System.err.println(e.getMessage());
        }

        // print talks from the input files.
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
