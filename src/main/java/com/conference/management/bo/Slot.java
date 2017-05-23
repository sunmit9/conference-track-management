package com.conference.management.bo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by girmes on 22/05/17.
 */
public class Slot {

    private List<Event> events;
    private int remainingDuration;
    private Calendar startTime;

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
        this.remainingDuration -= event.getDurationInMinutes();
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Slot(int duration, Calendar startTime){
        events = new ArrayList<>();
        this.remainingDuration = duration;
        this.startTime = startTime;
    }

    // check if the talk can be accommodated in the current slot.
    public boolean hasRoomFor(Talk talk) {
        return remainingDuration >= talk.getDurationInMinutes();
    }
}
