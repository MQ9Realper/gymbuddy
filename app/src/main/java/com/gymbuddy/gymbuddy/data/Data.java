package com.gymbuddy.gymbuddy.data;

import com.gymbuddy.gymbuddy.R;
import com.gymbuddy.gymbuddy.models.Gym;

import java.util.ArrayList;

/**
 * Created by dennis on 04/11/17.
 */

public class Data {

    public Data() {

    }

    public ArrayList<Gym> gymArrayList() {
        ArrayList<Gym> gyms = new ArrayList<>();
        gyms.add(new Gym(R.drawable.gym, "Body & Soul Health Club", 3.8F, "Al Khan Road - Sharjah ", "Opens at 6:00AM"));
        gyms.add(new Gym(R.drawable.gym, "Fitness 360", 3.2F, "Ground Floor, Arabian Center, Al Khawaneej Road", "Opens at 6:00AM"));
        gyms.add(new Gym(R.drawable.gym, "CrossFit Sands", 5F, "G01 Daytona House Dubai Autodrome, Motor City ", "Opens at 9:00AM"));
        gyms.add(new Gym(R.drawable.gym, "Gold's Gym", 3.9F, "23rd St - Dubai, Al Barsha Mall - Dubai ", "Opens at 9:00AM"));
        gyms.add(new Gym(R.drawable.gym, "Target Gym", 3.6F, "Q Block Sheikh Zayed Rd - Dubai ", "Opens at 5:00AM"));
        gyms.add(new Gym(R.drawable.gym, "Train Strength & Fitness", 4.6F, "6 4th St - Dubai ", "Opens at 6:00AM"));

        return gyms;
    }
}
