package com.spungkyb.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void datePicker(View view) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(),"date");
    }

    public void setDate(final Calendar calendar){
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView)findViewById(R.id.txt_date_picker)).setText(dateFormat.format(calendar.getTime()));
    }

    /*public void setDatePlus(final Calendar calendar){
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView)findViewById(R.id.txt_date_plus)).setText(dateFormat.format(calendar.getTime()));
    }*/

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar cal = new GregorianCalendar(year, month,day);
        //Calendar cal2 = new GregorianCalendar(year, month,day+5);
        setDate(cal);
        //setDatePlus(cal2);

    }



    public static class DatePickerFragment extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
         final Calendar c=Calendar.getInstance();
         int year =c.get(Calendar.YEAR);
         int month = c.get(Calendar.MONTH);
         int day= c.get(Calendar.DAY_OF_MONTH);

         return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener)getActivity(),year,month,day);
        }

    }
}
