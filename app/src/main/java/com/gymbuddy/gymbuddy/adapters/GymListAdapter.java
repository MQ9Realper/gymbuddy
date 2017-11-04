package com.gymbuddy.gymbuddy.adapters;

import android.app.Activity;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;

import com.bumptech.glide.Glide;
import com.gymbuddy.gymbuddy.R;
import com.gymbuddy.gymbuddy.models.Gym;
import com.gymbuddy.gymbuddy.views.TxtRegular;
import com.gymbuddy.gymbuddy.views.TxtSemiBold;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dennis on 11/4/17.
 */

public class GymListAdapter extends BaseAdapter {
    private ViewHolder viewHolder;
    private Activity context;
    private List<Gym> originalGymList = null;
    private List<Gym> filteredGymList;
    private LayoutInflater layoutInflater;
    private Filter filter;

    public GymListAdapter(Activity context1, ArrayList<Gym> ridesArrayList) {
        this.context = context1;
        this.originalGymList = ridesArrayList;
        this.layoutInflater = LayoutInflater.from(context1);
        this.filteredGymList = new ArrayList<>();
        this.filteredGymList.addAll(originalGymList);
    }

    private static class ViewHolder {
        private TxtSemiBold txtGymName;
        private TxtRegular txtGymLocation, txtGymTime;
        private CircleImageView imageGym;
        private AppCompatRatingBar ratingBar;
    }

    @Override
    public int getCount() {
        return originalGymList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater layoutInflater = context.getLayoutInflater();
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_gym_list_item, parent, false);
            viewHolder.txtGymName = (TxtSemiBold) convertView.findViewById(R.id.txtGymName);
            viewHolder.txtGymLocation = (TxtRegular) convertView.findViewById(R.id.txtGymLocation);
            viewHolder.txtGymTime = (TxtRegular) convertView.findViewById(R.id.txtGymTime);
            viewHolder.imageGym = (CircleImageView) convertView.findViewById(R.id.imageGym);
            viewHolder.ratingBar = (AppCompatRatingBar) convertView.findViewById(R.id.ratingGymRating);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.ratingBar.setRating(originalGymList.get(position).getGym_rating());
        viewHolder.txtGymName.setText(originalGymList.get(position).getGym_name());
        viewHolder.txtGymLocation.setText(originalGymList.get(position).getGym_location());
        viewHolder.txtGymTime.setText(originalGymList.get(position).getGym_time());
        Glide.with(context).load(originalGymList.get(position).getGym_image()).into(viewHolder.imageGym);

        return convertView;
    }

    public void refresh(List<Gym> rideList) {
        rideList.clear();
        rideList.addAll(rideList);
        notifyDataSetChanged();
    }

    // Filter method
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        originalGymList.clear();
        if (charText.length() == 0) {
            originalGymList.addAll(filteredGymList);
        } else {
            for (Gym gym : filteredGymList) {
                if (gym.getGym_name().toLowerCase(Locale.getDefault()).contains(charText)) {
                    originalGymList.add(gym);
                }
            }
        }
        notifyDataSetChanged();
    }
}
