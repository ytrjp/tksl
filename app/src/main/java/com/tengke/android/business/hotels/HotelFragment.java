package com.tengke.android.business.hotels;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tengke.android.R;
import com.tengke.android.base.ui.BaseFragment;
import com.tengke.android.base.utils.CalendarUtil;
import com.tengke.android.base.view.citypicker.CityPickerActivity;
import com.tengke.android.eventbus.SelectCalendarEvent;
import com.tengke.android.eventbus.SelectCityMsgEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HotelFragment extends BaseFragment {

    public static final int PAGE_POSITION = 0;

    @BindView(R.id.city_name_txt) TextView cityNameTxt;
    @BindView(R.id.select_time) TextView selectTimeTxt;
    @BindView(R.id.select_day_container) RelativeLayout selectDayLayout;
    @BindView(R.id.select_days_txt) TextView selectDaysTxt;
    @BindView(R.id.select_hotel_name_txt) TextView selectHotelTxt;
    @BindView(R.id.search_btn) Button searchBtn;
    @BindView(R.id.sub_day) ImageView subBtn;
    @BindView(R.id.add_day) ImageView addBtn;
    @BindView(R.id.day_txt) TextView dayTxt;

    private int currentDays;
    private Calendar currentCalendar;
    private Calendar nextCalendar;

    public HotelFragment() {
        // Required empty public constructor
    }

    public static HotelFragment newInstance(Bundle args) {
        HotelFragment fragment = new HotelFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshCityName(SelectCityMsgEvent event) {
        cityNameTxt.setText(event.getCity());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshDateTime(SelectCalendarEvent event) {
        selectTimeTxt.setText(event.getData());
        currentCalendar = event.getCalendar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotel, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        currentDays = 1;
        setDays();
        cityNameTxt.setOnClickListener(onClickListener);
        selectTimeTxt.setOnClickListener(onClickListener);
        selectDayLayout.setOnClickListener(onClickListener);
        selectHotelTxt.setOnClickListener(onClickListener);
        searchBtn.setOnClickListener(onClickListener);
        addBtn.setOnClickListener(onClickListener);
        subBtn.setOnClickListener(onClickListener);

        initData();
    }

    private void setDays() {
        selectDaysTxt.setText(String.format(getString(R.string.select_days), currentDays));
    }

    private void setTiems(boolean isAdd) {
        if (currentDays - 1 != 0) {

            if (currentCalendar == null) {
                currentCalendar = Calendar.getInstance();
            }
            Calendar calendar = CalendarUtil.getCalendarOfDays(nextCalendar, isAdd ? 1 : -1);
            String days = CalendarUtil.getWeek(calendar);
            dayTxt.setText(days);
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.city_name_txt: {
                    Intent intent = new Intent(getActivity(), CityPickerActivity.class);
                    startActivity(intent);
                }
                    break;
                case  R.id.select_time: {
                    Intent intent = new Intent(getActivity(), CalendarListActivity.class);
                    startActivity(intent);
                }
                    break;
                case R.id.add_day: {
                    currentDays ++;
                    setDays();
                    setTiems(true);
                }
                break;
                case R.id.sub_day: {
                    setTiems(false);
                    currentDays = currentDays == 1 ? 1 : --currentDays;
                    setDays();
                }
                break;
                case R.id.select_day_container:
                    break;
                case R.id.select_hotel_name_txt:
                    break;
                case R.id.search_btn:
                    break;
            }
        }
    };

    private void initData() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String currentDate = CalendarUtil.getWeek(calendar);
        selectTimeTxt.setText(currentDate);

        nextCalendar = CalendarUtil.getCalendarOfDays(calendar, 1);
        String dayData = CalendarUtil.getWeek(nextCalendar);
        dayTxt.setText(dayData);

    }

}
