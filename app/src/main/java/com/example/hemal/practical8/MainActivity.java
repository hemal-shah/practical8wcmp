package com.example.hemal.practical8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.fastaccess.datetimepicker.DatePickerFragmentDialog;
import com.fastaccess.datetimepicker.TimePickerFragmentDialog;
import com.fastaccess.datetimepicker.callback.DatePickerCallback;
import com.fastaccess.datetimepicker.callback.TimePickerCallback;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DatePickerCallback,
        TimePickerCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pickDate(View view) {
        DatePickerFragmentDialog.newInstance()
                .show(getSupportFragmentManager(), "DatePickerFragmentDialog");
    }

    public void pickTime(View view) {
        TimePickerFragmentDialog.newInstance().show(getSupportFragmentManager(),
                "TimePickerFragmentDialog");
    }

    @Override
    public void onDateSet(long date) {
        Date mDate = new Date(date);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        Toast.makeText(MainActivity.this, "Date : " + format.format(mDate),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTimeSet(long timeOnly, long dateWithTime) {

        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(timeOnly);
        Toast.makeText(MainActivity.this,
                "Time: " + mCalendar.get(Calendar.HOUR) + ":" + mCalendar.get(Calendar.MINUTE),
                Toast.LENGTH_LONG).show();
    }
}
