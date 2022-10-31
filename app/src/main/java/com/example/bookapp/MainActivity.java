package com.example.bookapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bookapp.Adapters.BookAdapter;
import com.example.bookapp.Models.BookModel;
import com.example.bookapp.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

//    FirebaseFirestore firestore;


    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



//        firestore = FirebaseFirestore.getInstance();


//        Map<String,Object> user = new HasMap <>();
//        user.put("firstname", "Nahin");
//        user.put("lastname", "Ahmed");
//        user.put("description", "DEV");


//        firestore.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//            @Override
//            public void onSuccess(DocumentReference documentReference) {
//                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(getApplicationContext(), "failure", Toast.LENGTH_SHORT).show();
//            }
//        });



        ArrayList<BookModel> list = new ArrayList<>();
//        list.add(new BookModel(R.drawable.book_1,"Death"));
//        list.add(new BookModel(R.drawable.book_2,"Comics"));
//        list.add(new BookModel(R.drawable.book_3,"Woman"));
//        list.add(new BookModel(R.drawable.book_4,"Kids"));
//        list.add(new BookModel(R.drawable.book_5,"Arts"));
//
//        list.add(new BookModel(R.drawable.book_1,"Death"));
//        list.add(new BookModel(R.drawable.book_2,"Comics"));
//        list.add(new BookModel(R.drawable.book_3,"Woman"));
//        list.add(new BookModel(R.drawable.book_4,"Kids"));
//        list.add(new BookModel(R.drawable.book_5,"Arts"));
//
//        list.add(new BookModel(R.drawable.book_1,"Death"));
//        list.add(new BookModel(R.drawable.book_2,"Comics"));
//        list.add(new BookModel(R.drawable.book_3,"Woman"));
//        list.add(new BookModel(R.drawable.book_4,"Kids"));
//        list.add(new BookModel(R.drawable.book_5,"Arts"));

        BookAdapter adapter = new BookAdapter(list , MainActivity.this);
        binding.recyclearView.setAdapter(adapter);

//        LinearLayoutManager linearlayoutmanager = new LinearLayoutManager(this);
//        binding.recyclearView.setLayoutManager(linearlayoutmanager);

        GridLayoutManager gridlayoutmanager = new GridLayoutManager(this,3);
        binding.recyclearView.setLayoutManager(gridlayoutmanager);

        FirebaseDatabase.getInstance().getReference().child("books")
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    BookModel model=snapshot1.getValue(BookModel.class);
                    list.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



}