package com.conference.management.bo;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Calendar;

/**
 * Created by girmes on 22/05/17.
 */
public class Talk {

    private int durationInMinutes;
    private String title;

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

    public Talk(String title, int durationInMinutes)
    {
        this.durationInMinutes = durationInMinutes;
        this.title = title;
    }

}
