package com.example.sunggataiymbay.krishakz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class ApartmentAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context context;
    private List<Apartment> apartments;

    public ApartmentAdapter(Context context, List<Apartment> apartments) {
        this.context = context;
        this.apartments = apartments;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return apartments.size();
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
            view = inflater.inflate(R.layout.row_apartment_item,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.apartmentTitleTextView.setText(apartments.get(i).getTitle());
        viewHolder.apartmentPriceTextView.setText(apartments.get(i).getPrice() + "$");
        Glide.with(context).load(apartments.get(i).getImage()).centerCrop().into(viewHolder.apartmentImageView);
        return view;
    }

    private class ViewHolder {
        ImageView apartmentImageView;
        TextView apartmentPriceTextView;
        TextView apartmentTitleTextView;

        public ViewHolder(View v) {
            apartmentImageView = v.findViewById(R.id.apartmentImageView);
            apartmentPriceTextView = v.findViewById(R.id.apartmentPriceTextView);
            apartmentTitleTextView = v. findViewById(R.id.apartmentTitleTextView);
        }
    }
}
