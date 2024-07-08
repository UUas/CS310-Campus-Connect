package com.example.campusconnect10;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.campusconnect10.databinding.FragmentEventListBinding;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class FragmentEventList extends Fragment {

    private static final String TAG = "FragmentEventList";
    private FragmentEventListBinding binding;

    private Handler dataHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            List<Event> data = (List<Event>) msg.obj;
            if (data == null || data.isEmpty()) {
                Log.d(TAG, "No events found.");
            } else {
                Log.d(TAG, "Events found: " + data.size());
            }
            EventAdapter adp = new EventAdapter(data, getActivity());
            binding.recView.setAdapter(adp);
            return true;
        }
    });

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEventListBinding.inflate(getLayoutInflater(), container, false);

        binding.recView.setLayoutManager(new LinearLayoutManager(getActivity()));

        EventRepo repo = new EventRepo();
        ExecutorService srv = ((EventApplication) getActivity().getApplication()).srv;

        Log.d(TAG, "Fetching all events.");
        repo.getAllEvents(srv, dataHandler);

        return binding.getRoot();
    }
}
