package com.example.user.recurringapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private LinearLayout startdate,schedule;
    Button everyday,customize,alternateday;
    RadioButton monaday,tuesday,wednesday,thursday,friday,saturday,sunday,secondday,thirdday,fourthday;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addproduct);
        intiallization();
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
        startdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(999);
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SchedulePopup();
            }
        });
    }

    public  void intiallization(){
        dateView=(TextView)findViewById(R.id.dateview);
        startdate=(LinearLayout)findViewById(R.id.start_date);
        schedule=(LinearLayout)findViewById(R.id.schedule);
    }
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
public void SchedulePopup(){
    LayoutInflater inflater = (LayoutInflater) getLayoutInflater();
    final View mView = inflater.inflate(R.layout.schedulepopup, null);

    /*final Dialog customDialog = new Dialog(MainActivity.this);
    customDialog.setContentView(mView);*/
    final BottomSheetDialog dialog = new BottomSheetDialog(MainActivity.this); dialog.setContentView(mView);
    everyday = (Button) mView. findViewById(R.id.everyday);
    customize = (Button) mView. findViewById(R.id.customize);
    alternateday = (Button) mView. findViewById(R.id.alternateday);
    monaday = (RadioButton) mView. findViewById(R.id.monday);
    tuesday = (RadioButton) mView. findViewById(R.id.tues);
    wednesday = (RadioButton) mView. findViewById(R.id.wed);
    thursday = (RadioButton) mView. findViewById(R.id.thurs);
    friday = (RadioButton) mView. findViewById(R.id.fri);
    saturday = (RadioButton) mView. findViewById(R.id.sat);
    sunday = (RadioButton) mView. findViewById(R.id.sun);
    /*secondday = (RadioButton) mView. findViewById(R.id.day2nd);
    thirdday = (RadioButton) mView. findViewById(R.id.thid_day);
    fourthday = (RadioButton) mView. findViewById(R.id.four_day);*/
    back = (ImageView) mView. findViewById(R.id.back);
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    });
    everyday.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /*secondday.setVisibility(View.INVISIBLE);
            thirdday.setVisibility(View.INVISIBLE);
            fourthday.setVisibility(View.INVISIBLE);*/
            monaday.setVisibility(View.VISIBLE);
            tuesday.setVisibility(View.VISIBLE);
            wednesday.setVisibility(View.VISIBLE);
            thursday.setVisibility(View.VISIBLE);
            friday.setVisibility(View.VISIBLE);
            saturday.setVisibility(View.VISIBLE);
            sunday.setVisibility(View.VISIBLE);
            monaday.setText("MONDAY");
            tuesday.setText("TUESDAY");
            wednesday.setText("WEDNESDAY");
            monaday.setChecked(true);
            tuesday.setChecked(true);
            wednesday.setChecked(true);
            thursday.setChecked(true);
            friday.setChecked(true);
            saturday.setChecked(true);
            sunday.setChecked(true);

        }
    });
    customize.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           /* secondday.setVisibility(View.INVISIBLE);
            thirdday.setVisibility(View.INVISIBLE);
            fourthday.setVisibility(View.INVISIBLE);*/
            monaday.setVisibility(View.VISIBLE);
            tuesday.setVisibility(View.VISIBLE);
            wednesday.setVisibility(View.VISIBLE);
            thursday.setVisibility(View.VISIBLE);
            friday.setVisibility(View.VISIBLE);
            saturday.setVisibility(View.VISIBLE);
            sunday.setVisibility(View.VISIBLE);
            monaday.setText("MONDAY");
            tuesday.setText("TUESDAY");
            wednesday.setText("WEDNESDAY");
            monaday.setChecked(false);
            tuesday.setChecked(false);
            wednesday.setChecked(false);
            thursday.setChecked(false);
            friday.setChecked(false);
            saturday.setChecked(false);
            sunday.setChecked(false);

        }
    });
    alternateday.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            monaday.setVisibility(View.VISIBLE);
            tuesday.setVisibility(View.VISIBLE);
            wednesday.setVisibility(View.VISIBLE);
            monaday.setText("2ndday");
            tuesday.setText("2ndday");
            wednesday.setText("2ndday");
            thursday.setVisibility(View.INVISIBLE);
            friday.setVisibility(View.INVISIBLE);
            saturday.setVisibility(View.INVISIBLE);
            sunday.setVisibility(View.INVISIBLE);
            /*secondday.setVisibility(View.VISIBLE);
            thirdday.setVisibility(View.VISIBLE);
            fourthday.setVisibility(View.VISIBLE);*/

        }
    });
    dialog.show();
}
}
