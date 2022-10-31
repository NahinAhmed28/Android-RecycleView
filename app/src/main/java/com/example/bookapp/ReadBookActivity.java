package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bookapp.databinding.ActivityReadBookBinding;

public class ReadBookActivity extends AppCompatActivity {

    ActivityReadBookBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReadBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}