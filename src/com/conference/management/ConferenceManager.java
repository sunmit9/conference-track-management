package com.conference.management;

import com.conference.management.bo.*;
import com.conference.management.enums.DataOutputEnum;
import com.conference.management.enums.DataSourceEnum;
import com.conference.management.exceptions.UnsupportedDestinationException;
import com.conference.management.exceptions.UnsupportedSourceException;
import com.conference.management.io.ConferenceFileSourceManager;
import com.conference.management.io.ConsoleOutputManager;
import com.conference.management.util.ConferenceUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by girmes on 22/05/17.
 */
public class ConferenceManager {

    public List<Talk> fetchTalksListFromSource(DataSourceEnum dataSourceEnum) throws UnsupportedSourceException{

        // Not exactly a factory. This will create an instance of the required SourceManager
        if (dataSourceEnum.equals(DataSourceEnum.FILE)) {
            ConferenceFileSourceManager sourceManager = new ConferenceFileSourceManager();
            return sourceManager.fetchTalks();
        } else {
            throw new UnsupportedSourceException("Source type not valid");
        }
    }

    public void outputConferenceSchedule(Conference conference, DataOutputEnum dataOutputEnum) throws UnsupportedDestinationException {

        // Not exactly a factory. This will create an instance of the required OutputManager
        if (dataOutputEnum.equals(DataOutputEnum.CONSOLE.CONSOLE)) {
            ConsoleOutputManager outputManager = new ConsoleOutputManager();
            outputManager.printSchedule(conference);
        } else {
            throw new UnsupportedDestinationException("Destination not valid.");
        }
    }


    public Conference processAndScheduleTalks(List<Talk> talkList){
        Conference conference = new Conference();

        // sort all the talks in descending order
        Collections.sort(talkList, new TalksCompare());
        int trackCount = 0;

        // run this loop till all the talks are scheduled.
        while (0 != talkList.size()) {

            // create and fill morning slot.
            Slot morningSlot = new Slot(ConferenceManagementConfig.MORNING_SLOT_DURATION_MINUTES, ConferenceManagementConfig.TRACK_START_TIME);
            fillSlot(morningSlot, talkList);

            // create and fill lunch slot.
            Slot lunchSlot = new Slot(ConferenceManagementConfig.LUNCH_DURATION_MINUTES, ConferenceManagementConfig.LUNCH_START_TIME);
            lunchSlot.addEvent(new Lunch());

            // create and fill afternoon slot.
            Slot afternoonSlot = new Slot(ConferenceManagementConfig.AFTERNOON_SLOT_DURATION_MINUTES,
                    ConferenceManagementConfig.POST_LUNCH_SLOT_START_TIME);
            fillSlot(afternoonSlot, talkList);

            // create and fill networking slot.
            Slot networkingSlot = new Slot(ConferenceManagementConfig.NETWORKING_DURATION_MINUTES,
                    ConferenceManagementConfig.NETWORKING_START_TIME);
            networkingSlot.addEvent(new Networking());

            // add all the slots for the day into the track.
            Track track = new Track(++trackCount);
            track.addSlot(morningSlot);
            track.addSlot(lunchSlot);
            track.addSlot(afternoonSlot);
            track.addSlot(networkingSlot);
            // add track to the conference.
            conference.addTrack(track);
        }

        return conference;
    }

    private void fillSlot(Slot slot, List<Talk> talks) {
        // initialize the slot start time.
        Calendar currentStartTime = slot.getStartTime();
        for (Iterator<Talk> talksIterator = talks.iterator(); talksIterator.hasNext();) {
            Talk talk = talksIterator.next();
            if (slot.hasRoomFor(talk)) {
                // add an event to the slot at the currentStartTime calculated.
                slot.addEvent(new Event(currentStartTime, talk.getTitle(), talk.getDurationInMinutes()));
                // calculate the next start time based on the current start time and current talk duration.
                currentStartTime = ConferenceUtils.getNextStartTime(currentStartTime, talk);
                // remove the talk from the list. This means that the talk has been scheduled in the conference.
                talksIterator.remove();
            }
        }
    }

}
