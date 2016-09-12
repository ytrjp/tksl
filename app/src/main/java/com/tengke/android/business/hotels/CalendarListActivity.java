package com.tengke.android.business.hotels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.andexert.calendarlistview.library.DatePickerController;
import com.andexert.calendarlistview.library.DayPickerView;
import com.andexert.calendarlistview.library.SimpleMonthAdapter;
import com.tengke.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CalendarListActivity extends AppCompatActivity implements DatePickerController{

    @BindView(R.id.pickerView) DayPickerView dayPickerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_list);

        ButterKnife.bind(this);

        dayPickerView.setController(this);

    }

    @Override
    public int getMaxYear() {
        return 2020;
    }

    @Override
    public void onDayOfMonthSelected(int year, int month, int day) {
        Log.e("Day Selected", day + " / " + month + " / " + year);
    }

    @Override
    public void onDateRangeSelected(SimpleMonthAdapter.SelectedDays<SimpleMonthAdapter.CalendarDay> selectedDays) {

    }
}
