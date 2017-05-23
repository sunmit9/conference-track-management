package main.java.com.conference.management.bo;

import java.util.Comparator;

/**
 * Created by girmes on 22/05/17.
 */
public class TalksCompare implements Comparator<Talk>{

    @Override
    public int compare(Talk t1, Talk t2) {
        if(t1.getDurationInMinutes() < t2.getDurationInMinutes()){
            return 1;
        } else {
            return -1;
        }
    }
}
