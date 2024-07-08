package com.example.campusconnect10;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.campusconnect10.databinding.ActivityEventsPageBinding;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class EventsPage extends AppCompatActivity {

    private String userId;

    ActivityEventsPageBinding binding;
    Toolbar toolbar;

    Button btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEventsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView2);
        NavController navController = navHost.getNavController();


        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Events");

        userId = getIntent().getStringExtra("USER_ID");
        btnProfile = findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(v->{
            Intent i = new Intent(EventsPage.this,UserPage.class);
            i.putExtra("USER_ID", userId);
            startActivity(i);
        });

    }

    public Toolbar getToolBar() {
        return toolbar;
    }
}