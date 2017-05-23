package main.java.com.conference.management.bo;

import main.java.com.conference.management.ConferenceManagementConfig;

import java.text.SimpleDateFormat;

/**
 * Created by girmes on 22/05/17.
 */
public class Networking extends Event {

    public Networking () {
        super(ConferenceManagementConfig.NETWORKING_START_TIME, "Networking Event", 0);
    }
}
