package com.example.campusconnect10;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private static final String TAG = "EventAdapter";
    private List<Event> events;
    private Context context;

    public EventAdapter(List<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Event event = events.get(position);
        holder.nameTextView.setText(event.getEventName());  // This is line 37
        holder.clubTextView.setText(event.getClub());

        holder.itemView.setOnClickListener(v -> {
            Log.d(TAG, "Event clicked: " + event.getEventName());

            Bundle bundle = new Bundle();
            bundle.putString("eventId", event.getEventId());

            EventDetails eventDetails = new EventDetails();
            eventDetails.setArguments(bundle);

            FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            if (fragmentManager.findFragmentById(R.id.fragmentContainerView2) != null) {
                Log.d(TAG, "Fragment container found, replacing fragment.");
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, eventDetails)
                        .addToBackStack(null)
                        .commit();
            } else {
                Log.e(TAG, "Fragment container not found.");
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView clubTextView;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.event_name);
            clubTextView = view.findViewById(R.id.event_club);
        }
    }
}
