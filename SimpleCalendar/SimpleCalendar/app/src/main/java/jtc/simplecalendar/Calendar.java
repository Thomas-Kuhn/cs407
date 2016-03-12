package jtc.simplecalendar;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by Owner on 3/11/2016.
 */


public class Calendar {

    private final String MY_PREFS_NAME = "myPrefs";
    private SharedPreferences prefs;
    private ArrayList<ArrayList<String>> calendarEvents;

    public Calendar(Context context) {
        prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);
        calendarEvents = new ArrayList<ArrayList<String>>();
        System.out.println("populating");

        populate();
    }

    public String getEvents(int month, int day){
        String events;

        events = calendarEvents.get(month).get(day);
        events = events.replace("//", "\n");
        return events;
    }

    public void deleteEvent(int month, int day, int eventNum){
        String temp = calendarEvents.get(month).get(day);
        System.out.println("Removing value " + eventNum + " ");
        System.out.println("old value:" + temp);

        if (!temp.equals(" ")){
            String[] split = temp.split("//");
            temp = "";
            for (int i = 0; i < split.length; i++){
                if (i != eventNum){
                    temp = temp + split[i] + "//";
                }
            }
            if (temp.charAt(0) != '/'){
                temp = "//" + temp;
            }
            calendarEvents.get(month).set(day, temp);
            System.out.println("new value:" + temp);
        }
        updatePrefs();
    }

    public void addEvent(int month, int day, String description){
        System.out.println("month: "+ month +"\nday: " + day);
        String temp = calendarEvents.get(month).get(day);
        temp = temp + description + "//";
        calendarEvents.get(month).set(day, temp);
        updatePrefs();
    }

    private void populate(){

        ArrayList<String> currOn;
        String currMonth;
        String[] split;
        String[] event;
        int day;
        String description;

        for(int i = 0; i < 12; i++){
            calendarEvents.add(new ArrayList<String>());
        }

        currOn = calendarEvents.get(0);

        for (int i = 0; i < 32; i++){
            currOn.add(" ");
        }

        currOn = calendarEvents.get(1);

        for (int i = 0; i < 30; i++){
            currOn.add(" ");
        }

        currOn = calendarEvents.get(2);

        for (int i = 0; i < 32; i++){
            currOn.add(" ");
        }


        currOn = calendarEvents.get(3);

        for (int i = 0; i < 31; i++){
            currOn.add(" ");
        }

        currOn = calendarEvents.get(4);

        for (int i = 0; i < 32; i++){
            currOn.add(" ");
        }

        currOn = calendarEvents.get(5);

        for (int i = 0; i < 31; i++){
            currOn.add(" ");
        }

        currOn = calendarEvents.get(6);

        for (int i = 0; i < 32; i++){
            currOn.add(" ");
        }

        currOn = calendarEvents.get(7);

        for (int i = 0; i < 32; i++){
            currOn.add(" ");
        }

        currOn = calendarEvents.get(8);

        for (int i = 0; i < 31; i++){
            currOn.add(" ");
        }

        currOn = calendarEvents.get(9);

        for (int i = 0; i < 32; i++){
            currOn.add(" ");
        }

        currOn = calendarEvents.get(10);

        for (int i = 0; i < 31; i++){
            currOn.add(" ");
        }

        currOn = calendarEvents.get(11);

        for (int i = 0; i < 32; i++){
            currOn.add(" ");
        }

        System.out.println("everything is blank");


        currMonth =  prefs.getString("January", " ");
        if (!currMonth.equals(" ")) {
            split = currMonth.split("!@#");
            for (int i = 0; i < split.length; i++) {
                event = split[i].split("//");
                try {
                    day = Integer.parseInt(event[0]);
                    description = event[1];
                    calendarEvents.get(0).set(day, description);
                } catch (Exception e) {

                }
            }
        }

        currMonth =  prefs.getString("February", " ");
        if (!currMonth.equals(" ")) {

            split = currMonth.split("!@#");
            for (int i = 0; i < split.length; i++) {
                event = split[i].split("//");
                day = Integer.getInteger(event[0]);
                description = event[1];
                calendarEvents.get(1).set(day, description);
            }
        }

        currMonth =  prefs.getString("March", " ");
        if (!currMonth.equals(" ")) {

            split = currMonth.split("!@#");
            for (int i = 0; i < split.length; i++) {
                event = split[i].split("//");
                day = Integer.getInteger(event[0]);
                description = event[1];
                calendarEvents.get(2).set(day, description);
            }
        }

        currMonth =  prefs.getString("April", " ");
        if (!currMonth.equals(" ")) {

            split = currMonth.split("!@#");
            for (int i = 0; i < split.length; i++) {
                event = split[i].split("//");
                day = Integer.getInteger(event[0]);
                description = event[1];
                calendarEvents.get(3).set(day, description);
            }
        }

        currMonth =  prefs.getString("May", " ");
        if (!currMonth.equals(" ")) {

            split = currMonth.split("!@#");
            for (int i = 0; i < split.length; i++) {
                event = split[i].split("//");
                day = Integer.getInteger(event[0]);
                description = event[1];
                calendarEvents.get(4).set(day, description);
            }
        }

        currMonth =  prefs.getString("June", " ");
        if (!currMonth.equals(" ")) {

            split = currMonth.split("!@#");
            for (int i = 0; i < split.length; i++) {
                event = split[i].split("//");
                day = Integer.getInteger(event[0]);
                description = event[1];
                calendarEvents.get(5).set(day, description);
            }
        }

        currMonth =  prefs.getString("July", " ");
        if (!currMonth.equals(" ")) {

            split = currMonth.split("!@#");
            for (int i = 0; i < split.length; i++) {
                event = split[i].split("//");
                day = Integer.getInteger(event[0]);
                description = event[1];
                calendarEvents.get(6).set(day, description);
            }
        }

        currMonth =  prefs.getString("August", " ");
        if (!currMonth.equals(" ")) {

            split = currMonth.split("!@#");
            for (int i = 0; i < split.length; i++) {
                event = split[i].split("//");
                day = Integer.getInteger(event[0]);
                description = event[1];
                calendarEvents.get(7).set(day, description);
            }
        }

        currMonth =  prefs.getString("September", " ");
        if (!currMonth.equals(" ")) {

            split = currMonth.split("!@#");
            for (int i = 0; i < split.length; i++) {

                event = split[i].split("//");
                day = Integer.getInteger(event[0]);
                description = event[1];
                calendarEvents.get(8).set(day, description);
            }
        }

        currMonth =  prefs.getString("October", " ");
        if (!currMonth.equals(" ")) {

            split = currMonth.split("!@#");
            for (int i = 0; i < split.length; i++) {
                event = split[i].split("//");
                day = Integer.getInteger(event[0]);
                description = event[1];
                calendarEvents.get(9).set(day, description);
            }
        }

        currMonth =  prefs.getString("November", " ");
        if (!currMonth.equals(" ")) {

            split = currMonth.split("!@#");
            for (int i = 0; i < split.length; i++) {
                event = split[i].split("//");
                day = Integer.getInteger(event[0]);
                description = event[1];
                calendarEvents.get(10).set(day, description);
            }
        }

        currMonth =  prefs.getString("December", " ");
        if (!currMonth.equals(" ")) {

            split = currMonth.split("!@#");
            for (int i = 0; i < split.length; i++) {
                event = split[i].split("//");
                day = Integer.getInteger(event[0]);
                description = event[1];
                calendarEvents.get(11).set(day, description);
            }
        }

        System.out.println("finished populating");

    }

    private void updatePrefs(){

        System.out.println("updating preferences");

        String JanString = arrayListToString(calendarEvents.get(0));
        String FebString = arrayListToString(calendarEvents.get(1));
        String MarchString = arrayListToString(calendarEvents.get(2));
        String AprilString = arrayListToString(calendarEvents.get(3));
        String MayString = arrayListToString(calendarEvents.get(4));
        String JuneString = arrayListToString(calendarEvents.get(5));
        String JulyString = arrayListToString(calendarEvents.get(6));
        String AugString = arrayListToString(calendarEvents.get(7));
        String SepString = arrayListToString(calendarEvents.get(8));
        String OctString = arrayListToString(calendarEvents.get(9));
        String NovString = arrayListToString(calendarEvents.get(10));
        String DecString = arrayListToString(calendarEvents.get(11));


        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("January", JanString);
        editor.putString("February", FebString);
        editor.putString("March", MarchString);
        editor.putString("April", AprilString);
        editor.putString("May", MayString);
        editor.putString("June", JuneString);
        editor.putString("July", JulyString);
        editor.putString("August", AugString);
        editor.putString("September", SepString);
        editor.putString("October", OctString);
        editor.putString("November", NovString);
        editor.putString("December", DecString);
        editor.commit();
        editor.apply();

        System.out.println("finished updating preferences");


    }

    private String arrayListToString(ArrayList<String> month){
        String stringRep = "!@#";
        for (int i = 0; i < month.size(); i++){
            String curr = month.get(i);
            if (!curr.equals(" ")){
                stringRep = stringRep + i + " " +  curr + "!@#";
            }
        }

        return stringRep;
    }
}
