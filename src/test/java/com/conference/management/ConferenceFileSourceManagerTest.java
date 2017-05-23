package test.java.com.conference.management;

import main.java.com.conference.management.bo.Talk;
import main.java.com.conference.management.io.ConferenceFileSourceManager;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by girmes on 23/05/17.
 */
public class ConferenceFileSourceManagerTest {

    ConferenceFileSourceManager manager = new ConferenceFileSourceManager();

    @Test(expected = FileNotFoundException.class)
    public void testFetchTalksFileNotFound() throws FileNotFoundException {
        manager.fetchTalks("input-test-talks-random-file.txt");
    }


    @Test
    public void testFetchTalksValidFile() throws FileNotFoundException {
        List<Talk> talks = manager.fetchTalks("input-test-two-talks.txt");
        Assert.assertEquals(2, talks.size());
    }


    @Test
    public void testFetchTalksEmptyFile() throws FileNotFoundException {
        List<Talk> talks = manager.fetchTalks("input-test-talks-empty.txt");
        Assert.assertEquals(0, talks.size());
    }


    @Test(expected = NumberFormatException.class)
    public void testFetchTalksInvalidFile() throws FileNotFoundException {
        List<Talk> talks = manager.fetchTalks("input-test-invalid-talks.txt");
    }

}