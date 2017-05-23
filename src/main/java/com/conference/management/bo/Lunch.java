package main.java.com.conference.management.bo;

import main.java.com.conference.management.ConferenceManagementConfig;

import java.text.SimpleDateFormat;

/**
 * Created by girmes on 22/05/17.
 */
public class Lunch extends Event {
    public Lunch() {
        super(ConferenceManagementConfig.LUNCH_START_TIME, "Lunch", ConferenceManagementConfig.LUNCH_DURATION_MINUTES);
    }
}
