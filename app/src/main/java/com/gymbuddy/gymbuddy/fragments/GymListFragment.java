package com.gymbuddy.gymbuddy.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gymbuddy.gymbuddy.R;
import com.gymbuddy.gymbuddy.adapters.GymListAdapter;
import com.gymbuddy.gymbuddy.data.Data;
import com.gymbuddy.gymbuddy.views.Edt;

/**
 * A simple {@link Fragment} subclass.
 */
public class GymListFragment extends Fragment {

    public GymListFragment() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gym_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Data data = new Data();
        final GymListAdapter gymListAdapter = new GymListAdapter(getActivity(), data.gymArrayList());
        ListView listView = (ListView) view.findViewById(R.id.listViewGym);
        listView.setAdapter(gymListAdapter);

        Edt edtSearch = (Edt) view.findViewById(R.id.edtSearchGym);
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gymListAdapter.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
