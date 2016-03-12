package jtc.simplecalendar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView events;
    Calendar storage;
    EditText editMonth;
    EditText editDay;
    EditText addEvent;
    EditText removeEvent;
    TextView eventList;
    int day;
    int month;
    boolean daysValid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        events = (TextView)findViewById(R.id.ListEvents);
        storage = new Calendar(this);

        System.out.println("created storage");

        storage.addEvent(0, 10, "Do things");
        storage.deleteEvent(0, 10, 0);

        System.out.println("added and removed an event");

        editDay = (EditText)findViewById(R.id.dayText);
        editMonth = (EditText)findViewById(R.id.monthText);
        addEvent = (EditText)findViewById(R.id.addText);
        removeEvent = (EditText)findViewById(R.id.removeText);

        daysValid = false;

    }

    private void updateEvents(){
        String temp = storage.getEvents(month, day);
        if (temp.equals(" ")){
            events.setText("There are no Events to show.");
        } else {
            events.setText(temp);
        }
    }

    public void findEvents(View v){
        translateIntoDayMonth();
        if (month == -1 || day < 0 || day > 31){
            daysValid = false;
            events.setText("I'm sorry, I couldn't understand that date.\n" +
                    "           For a month, put a number or spell it out.\n" +
                    "           For a day, please put the day number.");
        } else {
            daysValid = true;
            String temp = storage.getEvents(month, day);
            if (temp.equals(" ")){
                events.setText("There are no Events to show.");
            } else {
                events.setText(temp);
            }
        }
    }

    public void addEvent(View v){

        if (daysValid) {
            storage.addEvent(month, day, addEvent.getText().toString());
            updateEvents();
        } else {
            Toast.makeText(this, "You must be looking at a valid date", Toast.LENGTH_SHORT).show();
        }

    }

    public void removeEvent(View v) {
        if (daysValid) {

            try {
                int toRemove = Integer.parseInt(removeEvent.getText().toString());
                storage.deleteEvent(month, day, toRemove);
                updateEvents();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "That was not a valid number", Toast.LENGTH_SHORT).show();

            }
        } else {
            Toast.makeText(this, "You must be looking at a valid date", Toast.LENGTH_SHORT).show();
        }

    }

    private void translateIntoDayMonth(){
        String dayEdit = editDay.getText().toString();
        String monthEdit = editMonth.getText().toString().toLowerCase();

        editDay.setText("Enter Day");
        editMonth.setText("Enter Month");
        try {
             day = Integer.parseInt(dayEdit);
        } catch (NumberFormatException e){
            day = -1;
        }

       if (monthEdit.equals("1")){
           month = 0;


       } else  if (monthEdit.equals("2")){
           month = 1;

       } else if (monthEdit.equals("3")){
           month = 2;

       } else if (monthEdit.equals("4")){
           month = 3;

       } else if (monthEdit.equals("5")){
           month = 4;

       } else if (monthEdit.equals("6")){
           month = 5;

       } else if (monthEdit.equals("7")){
           month = 6;

       } else if (monthEdit.equals("8")){
           month = 7;

       } else if (monthEdit.equals("9")){
           month = 8;

       } else if (monthEdit.equals("10")){
           month = 9;

       } else if (monthEdit.equals("11")){
           month = 10;

       } else if (monthEdit.equals("12")){
           month = 11;

       } else if (monthEdit.equals("january")){
           month = 0;

       } else if (monthEdit.equals("february")){
           month = 1;

       } else if (monthEdit.equals("march")){
           month = 2;

       } else if (monthEdit.equals("april")){
           month = 3;

       } else if (monthEdit.equals("may")){
           month = 4;

       } else if (monthEdit.equals("june")){
           month = 5;

       } else if (monthEdit.equals("july")){
           month = 6;

       } else if (monthEdit.equals("august")){
           month = 7;

       } else if (monthEdit.equals("september")){
           month = 8;

       } else if (monthEdit.equals("october")){
           month = 9;

       } else if (monthEdit.equals("november")){
           month = 10;

       } else if (monthEdit.equals("december")){
           month = 11;

       } else {
            month = -1;
       }

    }



}
