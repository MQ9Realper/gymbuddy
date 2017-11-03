package com.gymbuddy.gymbuddy.models;

/**
 * Created by dennis on 04/11/17.
 */

public class Gym {
    private int gym_image;
    private String gym_name;
    private float gym_rating;
    private String gym_location;
    private String gym_time;

    public Gym(int gym_image, String gym_name, float gym_rating, String gym_location, String gym_time){
        this.gym_image = gym_image;
        this.gym_name = gym_name;
        this.gym_rating = gym_rating;
        this.gym_location = gym_location;
        this.gym_time = gym_time;
    }

    public int getGym_image() {
        return gym_image;
    }

    public String getGym_name() {
        return gym_name;
    }

    public float getGym_rating() {
        return gym_rating;
    }

    public String getGym_location() {
        return gym_location;
    }

    public String getGym_time() {
        return gym_time;
    }
}
