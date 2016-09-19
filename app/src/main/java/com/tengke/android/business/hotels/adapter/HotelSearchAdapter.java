package com.tengke.android.business.hotels.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tengke.android.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinpeng on 16/9/17.
 */

public class HotelSearchAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mData;
    private LayoutInflater mInflater;

    public HotelSearchAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_hotel_search, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.hotelNameTxt.setText(mData.get(position));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.image_view) ImageView imageView;
        @BindView(R.id.distance) TextView disTxt;
        @BindView(R.id.hotel_name) TextView hotelNameTxt;
        @BindView(R.id.star_name) TextView starNameTxt;
        @BindView(R.id.location) TextView locationTxt;
        @BindView(R.id.price) TextView priceTxt;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
