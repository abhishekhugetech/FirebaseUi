package com.epiclancers.app.anmio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListViewFirebaseAbh extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_firebase_abh);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        listView =  findViewById(R.id.listView);

        FirebaseListOptions<Boxer> listOptions = new FirebaseListOptions.Builder<Boxer>()
                .setLayout(android.R.layout.simple_list_item_2)
                .setQuery(databaseReference.child("Boxers") , Boxer.class)
                .build();


        FirebaseListAdapter<Boxer> adapter = new FirebaseListAdapter<Boxer>(listOptions) {
            @Override
            protected void populateView(View v, Boxer model, int position) {
                TextView textView = v.findViewById(android.R.id.text1);
                textView.setText(model.getBoxerName());
            }
        };

        adapter.startListening();

        listView.setAdapter(adapter);
    }
}
