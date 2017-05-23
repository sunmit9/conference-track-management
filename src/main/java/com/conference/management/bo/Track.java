package main.java.com.conference.management.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by girmes on 22/05/17.
 */
public class Track {
    private List<Slot> slots;
    private int trackId;

    public Track(int trackId) {
        this.trackId = trackId;
        slots = new ArrayList<>();
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void addSlot(Slot slot) {
        this.slots.add(slot);
    }

    public int getTrackId() {
        return trackId;
    }

}
