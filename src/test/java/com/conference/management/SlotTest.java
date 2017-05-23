package test.java.com.conference.management;

import main.java.com.conference.management.bo.Slot;
import main.java.com.conference.management.bo.Talk;
import main.java.com.conference.management.util.ConferenceUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by girmes on 23/05/17.
 */
public class SlotTest {

    @Test
    public void testHasRoomForTalk(){

        Calendar slotStartTime = ConferenceUtils.getCalendarTime(9, 00);
        Slot slot = new Slot(50, slotStartTime);

        Talk talk1 = new Talk("Valid Talk", 45);
        Assert.assertTrue(slot.hasRoomFor(talk1));

        Talk talk2 = new Talk("InValid Talk", 60);
        Assert.assertFalse(slot.hasRoomFor(talk2));

    }
}
