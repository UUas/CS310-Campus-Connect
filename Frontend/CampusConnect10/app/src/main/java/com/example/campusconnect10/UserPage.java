package com.example.campusconnect10;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPage extends AppCompatActivity {
    private TextView userNameTextView;
    private TextView nameTextView;
    private TextView surNameTextView;
    private TextView studentClubTextView;
    private TextView ageTextView;
    private TextView facultyTextView;
    private ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        userNameTextView = findViewById(R.id.userNameTextView);
        nameTextView = findViewById(R.id.nameTextView);
        surNameTextView = findViewById(R.id.surNameTextView);
        studentClubTextView = findViewById(R.id.studentClubTextView);
        ageTextView = findViewById(R.id.ageTextView);
        facultyTextView = findViewById(R.id.facultyTextView);

        apiService = RetrofitClient.getClient("http://10.0.2.2:8080/").create(ApiService.class);

        String userId = getIntent().getStringExtra("USER_ID");
        fetchUserProfile(userId);
    }

    private void fetchUserProfile(String userId) {
        Call<Users> call = apiService.getUserById(userId);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()) {
                    Users user = response.body();
                    userNameTextView.setText(user.getUserName());
                    nameTextView.setText(user.getName());
                    surNameTextView.setText(user.getSurName());
                    studentClubTextView.setText(user.getStudentClub());
                    ageTextView.setText(String.valueOf(user.getAge()));
                    facultyTextView.setText(user.getFaculty());
                } else {
                    // Handle the error response
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                // Handle failure
            }
        });
    }
}
