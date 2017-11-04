package com.gymbuddy.gymbuddy.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by dennis on 10/24/17.
 */

public class TabLayoutAdapter extends FragmentStatePagerAdapter {
    private CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    private int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    private Fragment fragments[];

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public TabLayoutAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb, Fragment fragments[]) {
        super(fm);
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        this.fragments = fragments;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}

