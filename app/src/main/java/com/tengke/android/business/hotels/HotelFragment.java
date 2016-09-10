package com.tengke.android.business.hotels;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tengke.android.R;
import com.tengke.android.base.ui.BaseFragment;
import com.tengke.android.base.view.citypicker.CityPickerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotelFragment extends BaseFragment {

    public static final int PAGE_POSITION = 0;

    @BindView(R.id.city_name_txt) TextView cityNameTxt;
    @BindView(R.id.select_time) TextView selectTimeTxt;
    @BindView(R.id.select_day_container) RelativeLayout selectDayLayout;
    @BindView(R.id.select_hotel_name_txt) TextView selectHotelTxt;
    @BindView(R.id.search_btn) Button searchBtn;

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
        cityNameTxt.setOnClickListener(onClickListener);
        selectTimeTxt.setOnClickListener(onClickListener);
        selectDayLayout.setOnClickListener(onClickListener);
        selectHotelTxt.setOnClickListener(onClickListener);
        searchBtn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.city_name_txt:
                    Intent intent = new Intent(getActivity(), CityPickerActivity.class);
                    startActivity(intent);
                    break;
                case  R.id.select_time:
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
}
