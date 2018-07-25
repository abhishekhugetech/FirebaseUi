package com.epiclancers.app.anmio;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText boxerName;
    EditText boxerAge;
    RecyclerView recyclerView;

    public void addData( View view ){

        Boxer boxer = new Boxer(boxerName.getText().toString(),
                boxerAge.getText().toString());

        databaseReference.child("Boxers").child(databaseReference.push().getKey())
                .setValue(boxer);

    }

    public void listView(View view){

        Intent intent = new Intent(getApplicationContext() , ListViewFirebaseAbh.class);

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        boxerName = findViewById(R.id.boxerName);
        boxerAge = findViewById(R.id.boxerAge);

        recyclerView = findViewById(R.id.recyclerView);

        FirebaseRecyclerOptions<Boxer> boxerFirebaseRecyclerOptions =
                new FirebaseRecyclerOptions.Builder<Boxer>()
                        .setQuery(databaseReference.child("Boxers") , Boxer.class)
                        .build();

        final FirebaseRecyclerAdapter<Boxer, BoxerViewHolder> adapter =
                new FirebaseRecyclerAdapter<Boxer, BoxerViewHolder>(boxerFirebaseRecyclerOptions) {
            @Override
            protected void onBindViewHolder(@NonNull BoxerViewHolder holder, final int position, @NonNull final Boxer model) {
                holder.boxerAge.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "The age is "  + model.getBoxerAge(), Toast.LENGTH_SHORT).show();
                    }
                });
                holder.boxerName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "" , Toast.LENGTH_SHORT).show();
                    }
                });
                holder.boxerName.setText(model.getBoxerName());
                holder.boxerAge.setText(model.getBoxerAge());
            }
            @NonNull
            @Override
            public BoxerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.boxer,parent ,false);

                return new BoxerViewHolder(view);
            }
        };

        adapter.startListening();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }
}
