package com.example.campusconnect10;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.concurrent.ExecutorService;

public class EventDetails extends Fragment {
    private static final String TAG = "EventDetails";
    private TextView nameTextView;
    private TextView dateTextView;
    private TextView topicTextView;
    private TextView clubTextView;
    private TextView locationTextView;

    private Handler handler = new Handler(new Handler.Callback() {
        final String nullity = "404 NOT FOUND";
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            Event event = (Event) msg.obj;
            if (event != null) {
                nameTextView.setText(event.getEventName());
                topicTextView.setText(event.getTopic());
                dateTextView.setText(event.getDate());
                clubTextView.setText(event.getClub());
                locationTextView.setText(event.getLocation());
            }else{
                nameTextView.setText(nullity);
            }
            return true;
        }
    });


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_details, container, false);

        nameTextView = view.findViewById(R.id.event_detail_name);
        dateTextView = view.findViewById(R.id.event_detail_date);
        topicTextView = view.findViewById(R.id.event_detail_topic);
        clubTextView = view.findViewById(R.id.event_detail_club);
        locationTextView = view.findViewById(R.id.event_detail_location);


        String eventId = getArguments().getString("eventId");

        EventRepo repo = new EventRepo();
        ExecutorService srv = ((EventApplication) getActivity().getApplication()).srv;
        repo.findEventById(srv, handler, eventId);

        return view;
    }

}
