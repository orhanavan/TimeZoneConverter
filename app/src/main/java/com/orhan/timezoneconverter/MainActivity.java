package com.orhan.timezoneconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        TimeZone tz = TimeZone.getDefault();
        String ourZone = tz.getDisplayName(false, TimeZone.SHORT);

        Calendar calendarTurkey = new GregorianCalendar(TimeZone.getTimeZone("GMT+03:00"));
        calendarTurkey.set(Calendar.HOUR, 4);
        calendarTurkey.set(Calendar.MINUTE, 30);
        calendarTurkey.set(Calendar.SECOND, 0);

        Calendar calendarOur = new GregorianCalendar(TimeZone.getTimeZone(ourZone));
        calendarOur.setTimeInMillis(calendarTurkey.getTimeInMillis());

        textView.setText(calendarOur.get(Calendar.HOUR) + " " + calendarOur.get(Calendar.MINUTE));


    }
}
