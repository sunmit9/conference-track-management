package com.conference.management.bo;

import java.util.Calendar;

/**
 * Created by girmes on 22/05/17.
 */
public class Event {

    private Calendar startTime;
    private int durationInMinutes;
    private String title;

    public Event(Calendar startTime, String title, int durationInMinutes){
        this.startTime = startTime;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
