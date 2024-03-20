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
    String link,fdetails,fbookname;

    String[] books = {"Book Name: Bhagavad Gita \n\nAuthor name: Vedavyasa",
            "Book Name: The Alchemist \n\nAuthor name: Paulo Coelho",
            "Book Name: The Power of Your Subconscious Mind \n\nAuthor name: Joseph Murphy",
            "Book Name: The Secret \n\nAuthor name: Rhonda Byrne",
            "Book Name: The 5 AM Club \n\nAuthor name: Robin Sharma",
            "Book Name: Atomic Habits \n\nAuthor name: Jamnes clear"};

//    int[] images = {R.drawable.bhagadvadgita, R.drawable.alchemist, R.drawable.powerofmind, R.drawable.secret, R.drawable.amclub, R.drawable.atomichabits};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homefragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mList = new ArrayList<>();

//        mList.add(new Datamodel(books[0],images[0], "Bhagavad Gita"));
//        mList.add(new Datamodel(books[1],images[1], "The Alchemist"));
//        mList.add(new Datamodel(books[2],images[2], "The Power of Your Subconscious Mind"));
//        mList.add(new Datamodel(books[3],images[3], "The Secret"));
//        mList.add(new Datamodel(books[4],images[4], "The 5 AM Club"));
//        mList.add(new Datamodel(books[5],images[5], "Atomic Habits"));

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference("images");

//        DatabaseReference getImage = databaseReference.child("secret");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Data exists, log its value
                    link = dataSnapshot.child("secret").getValue(String.class);
                    fdetails = dataSnapshot.child("details").getValue(String.class);
                    fbookname = dataSnapshot.child("Bookname").getValue(String.class);
                    mList.add(new Datamodel(fdetails, link, fbookname));
                    adapter = new ItemAdapter(mList);
                    recyclerView.setAdapter(adapter);

                } else {
                    Log.d("FirebaseData", "No data found at the specified location");
                }
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