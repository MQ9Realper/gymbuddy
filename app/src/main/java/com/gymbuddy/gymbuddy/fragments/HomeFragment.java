package com.gymbuddy.gymbuddy.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gymbuddy.gymbuddy.R;
import com.gymbuddy.gymbuddy.adapters.TabLayoutAdapter;
import com.gymbuddy.gymbuddy.views.SlidingTabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        CharSequence[] tabTitles = {"LIST", "MAP"};

        GymListFragment gymListFragment = new GymListFragment();
        GymMapFragment gymMapFragment = new GymMapFragment();
        Fragment[] fragments = new Fragment[]{gymListFragment, gymMapFragment};

        /** Views **/
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPagerMain);
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.slidingTabLayoutMain);

        TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(getChildFragmentManager(), tabTitles, 2, fragments);
        viewPager.setAdapter(tabLayoutAdapter);

        slidingTabLayout.setDistributeEvenly(true);

        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorPrimaryDark);
            }

            @Override
            public int getDividerColor(int position) {
                // TODO Auto-generated method stub
                return getResources().getColor(R.color.colorBlackLight);
            }

        });
        slidingTabLayout.setViewPager(viewPager);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }
}
