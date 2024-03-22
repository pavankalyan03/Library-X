package com.example.library_x;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class homefragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Datamodel> mList;
    private ItemAdapter adapter;
    String link, fbookname, fduedate, fpublishdate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homefragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mList = new ArrayList<>();

        String userUsername = getArguments().getString("username");
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("users").child(userUsername).child("books");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mList.clear(); // Clear list before adding new data

                for (DataSnapshot books : dataSnapshot.getChildren()) {
                    for (DataSnapshot book : books.getChildren()) {
                        if (book.getKey().equals("bookname")) {
                            fbookname = book.getValue(String.class);
                        } else if (book.getKey().equals("bookpic")) {
                            link = book.getValue(String.class);
                        } else if (book.getKey().equals("due")) {
                            fduedate = book.getValue(String.class);
                        } else if (book.getKey().equals("publish")) {
                            fpublishdate = book.getValue(String.class);
                        }
                    }
                    // Add data to the list inside the loop
                    mList.add(new Datamodel(fduedate, fpublishdate, link, fbookname));
                }

                // Initialize adapter and set it to the RecyclerView after fetching data
                adapter = new ItemAdapter(mList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle onCancelled
                Log.e("FirebaseData", "Error: " + databaseError.getMessage());
            }
        });

        return view;
    }

}