package com.example.campusconnect10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private EditText userNameEditText;
    private EditText nameEditText;
    private EditText surNameEditText;
    private EditText studentClubEditText;
    private EditText passwordEditText;
    private EditText ageEditText;
    private EditText facultyEditText;
    private Button signUpButton;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userNameEditText = findViewById(R.id.userNameEditText);
        nameEditText = findViewById(R.id.nameEditText);
        surNameEditText = findViewById(R.id.surNameEditText);
        studentClubEditText = findViewById(R.id.studentClubEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        ageEditText = findViewById(R.id.ageEditText);
        facultyEditText = findViewById(R.id.facultyEditText);
        signUpButton = findViewById(R.id.signUpButton);

        apiService = RetrofitClient.getClient("http://10.0.2.2:8080/").create(ApiService.class);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        String userName = userNameEditText.getText().toString();
        String name = nameEditText.getText().toString();
        String surName = surNameEditText.getText().toString();
        String studentClub = studentClubEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        int age = Integer.parseInt(ageEditText.getText().toString());
        String faculty = facultyEditText.getText().toString();

        Users user = new Users(userName, name, surName, studentClub, password, age, faculty);

        Call<Id> call = apiService.createUser(user);

        call.enqueue(new Callback<Id>() {
            @Override
            public void onResponse(Call<Id> call, Response<Id> response) {
                if (response.isSuccessful()) {
                    Id userId = response.body();
                    Toast.makeText(SignUpActivity.this, "User created successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, EventsPage.class);
                    intent.putExtra("USER_ID", userId.getId());
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SignUpActivity.this, "Failed to create user", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Id> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "An error occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
