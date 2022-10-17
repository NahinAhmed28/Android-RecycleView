package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.bookapp.Adapters.BookAdapter;
import com.example.bookapp.Models.BookModel;
import com.example.bookapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        binding.recyclearView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        ArrayList<BookModel> list = new ArrayList<>();
        list.add(new BookModel(R.drawable.book_1,"Death"));
        list.add(new BookModel(R.drawable.book_2,"Business"));
        list.add(new BookModel(R.drawable.book_3,"Hijab"));
        list.add(new BookModel(R.drawable.book_4,"Kids"));
        list.add(new BookModel(R.drawable.book_5,"Arts"));

        BookAdapter adapter = new BookAdapter(list , MainActivity.this);
        binding.recyclearView.setAdapter(adapter);

        LinearLayoutManager linearlayoutmanager = new LinearLayoutManager(this);
        binding.recyclearView.setLayoutManager(linearlayoutmanager);
    }



}