package com.example.hemal.practical8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.fastaccess.datetimepicker.DatePickerFragmentDialog;
import com.fastaccess.datetimepicker.callback.DatePickerCallback;
import com.fastaccess.datetimepicker.callback.TimePickerCallback;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DatePickerCallback,
        TimePickerCallback {

    EditText et_date, et_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_date = (EditText) findViewById(R.id.et_date);
        et_time = (EditText) findViewById(R.id.et_time);
    }

    public void pickDate(View view) {
        DatePickerFragmentDialog.newInstance()
                .show(getSupportFragmentManager(), "DatePickerFragmentDialog");
    }

    public void pickTime(View view) {
//        TimePickerFragmentDialog.newInstance(true).show(getSupportFragmentManager(),
//                "TimePickerFragmentDialog");
        DatePickerFragmentDialog.newInstance(true).show(getSupportFragmentManager(), "DatePickerFragmentDialog");
    }

    @Override
    public void onDateSet(long date) {
        Date mDate = new Date(date);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        et_date.setText(format.format(mDate));
        Toast.makeText(MainActivity.this, "Date : " + format.format(mDate),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTimeSet(long timeOnly, long dateWithTime) {

        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(timeOnly);
        et_time.setText(mCalendar.get(Calendar.HOUR) + ":" + mCalendar.get(Calendar.MINUTE));
        Toast.makeText(MainActivity.this,
                "Time: " + mCalendar.get(Calendar.HOUR) + ":" + mCalendar.get(Calendar.MINUTE),
                Toast.LENGTH_LONG).show();
    }
}
