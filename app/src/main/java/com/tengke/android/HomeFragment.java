package com.tengke.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tengke.android.base.ui.BaseFragment;
import com.tengke.android.business.aircraft.AircraftMainActivity;
import com.tengke.android.business.car.CarMainActivity;
import com.tengke.android.business.hotels.HotelMainActivity;
import com.tengke.android.business.train.TrainMainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment {
    public static final int PAGE_POSITION = 0;
    @BindView(R.id.hotel_txt) TextView hotleTxt;
    @BindView(R.id.air_ticket_txt) TextView airTicketTxt;
    @BindView(R.id.railway_ticket_txt) TextView railwayTicketTxt;
    @BindView(R.id.rent_car) TextView rentCarTxt;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(Bundle args) {
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hotleTxt.setOnClickListener(onClickListener);
        airTicketTxt.setOnClickListener(onClickListener);
        railwayTicketTxt.setOnClickListener(onClickListener);
        rentCarTxt.setOnClickListener(onClickListener);
    }

    public void onButtonPressed(Uri uri) {
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.hotel_txt:
                    startActivity(new Intent(getActivity(), HotelMainActivity.class));
                    break;
                case R.id.air_ticket_txt:
                    startActivity(new Intent(getActivity(), AircraftMainActivity.class));
                    break;
                case R.id.railway_ticket_txt:
                    startActivity(new Intent(getActivity(), TrainMainActivity.class));
                    break;
                case R.id.rent_car:
                    startActivity(new Intent(getActivity(), CarMainActivity.class));
                    break;
            }
            Toast.makeText(getActivity(), ".....", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
