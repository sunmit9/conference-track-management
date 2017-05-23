package com.conference.management.io;

import com.conference.management.ConferenceManagementConfig;
import com.conference.management.bo.Talk;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by girmes on 22/05/17.
 */
public class ConferenceFileSourceManager {

    public List<Talk> fetchTalks(){
        FileInputStream fstream = null;
        List<Talk> talkList = new ArrayList<>();

        try {
            fstream = new FileInputStream(ConferenceManagementConfig.TALKS_INPUT_FILE);
        } catch (FileNotFoundException e) {
            System.err.println("Input file specified not found : " + ConferenceManagementConfig.TALKS_INPUT_FILE + ". Make sure the file exists");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        int intMinutes;

        //Read Input File Line By Line
        try {
            while ((strLine = br.readLine()) != null) {
                // handle comments or empty lines
                if(strLine.contains("//") || strLine.isEmpty())
                    continue;

                String title = strLine.substring(0, strLine.lastIndexOf(" "));
                String minutesString = strLine.substring(strLine.lastIndexOf(" ") + 1);
                String minutes = strLine.replaceAll("\\D+", "");
                if ("lightning".equals(minutesString)) {
                    intMinutes = ConferenceManagementConfig.LIGHTNING_TALK_DURATION_MINUTES;
                } else {
                    intMinutes = Integer.parseInt(minutes);
                }
                Talk singleTalk = new Talk(title, intMinutes);
                talkList.add(singleTalk);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fstream.close();
                br.close();
            } catch (IOException e){
                System.err.println(e.getMessage());
            }
        }
        return talkList;
    }
}
