package com.tengke.android.business.hotels;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.tengke.android.R;
import com.tengke.android.base.ui.BaseActivity;
import com.tengke.android.business.hotels.adapter.HotelSearchAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HotelSearchActivity extends BaseActivity {
    @BindView(R.id.list_view) ListView listView;
    @BindView(R.id.recommend) TextView recommendTxt;
    @BindView(R.id.price_star) TextView priceStarTxt;
    @BindView(R.id.more) TextView moreText;

    private HotelSearchAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search);

        ButterKnife.bind(this);

        recommendTxt.setOnClickListener(onClickListener);
        recommendTxt.setOnClickListener(onClickListener);
        recommendTxt.setOnClickListener(onClickListener);

        List<String> list = new ArrayList<>();
        for (int i=0; i<10; i++) {
            list.add("酒店" + i);
        }
        mAdapter = new HotelSearchAdapter(this, list);
        listView.setAdapter(mAdapter);
    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.recommend:
                    break;
                case R.id.price_star:
                    break;
                case R.id.more:
                    break;
            }
        }
    };
}
