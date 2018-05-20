package com.example.sunggataiymbay.krishakz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CityAdapter extends BaseAdapter {


    private List<City> cities;
    private Context context;
    private LayoutInflater inflater;

    public CityAdapter(Context context, List<City> cities) {
        this.context = context;
        this.cities = cities;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null) {
            view = inflater.inflate(R.layout.row_city_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.cityTitleTextView.setText(cities.get(i).getTitle());
        Glide.with(context).load(cities.get(i).getImage()).centerCrop().into(viewHolder.cityImageView);
        return view;
    }

    private class ViewHolder {
        ImageView cityImageView;
        TextView cityTitleTextView;

        public ViewHolder(View v) {
            cityImageView = v.findViewById(R.id.cityImageView);
            cityTitleTextView = v.findViewById(R.id.cityTitleTextView);
        }

    }
}
