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
    String link,fdetails,fdue,fpublish;

//    String[] books = {"Book Name: Bhagavad Gita \n\nAuthor name: Vedavyasa",
//            "Book Name: The Alchemist \n\nAuthor name: Paulo Coelho",
//            "Book Name: The Power of Your Subconscious Mind \n\nAuthor name: Joseph Murphy",
//            "Book Name: The Secret \n\nAuthor name: Rhonda Byrne",
//            "Book Name: The 5 AM Club \n\nAuthor name: Robin Sharma",
//            "Book Name: Atomic Habits \n\nAuthor name: Jamnes clear"};

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

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("users");
        String Userusername = getArguments().getString("username");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(Userusername);

        checkUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DatabaseReference books = FirebaseDatabase.getInstance().getReference().child("Userusername/Books");
                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String key = snapshot.getKey();
                        Log.d("FirebaseData", "Key: " + key);
                    }
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