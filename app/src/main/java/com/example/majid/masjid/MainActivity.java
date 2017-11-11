package com.example.majid.masjid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewSalat;

    List<Salat> salatList;

    DatabaseReference databaseSalat;
    Button mbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseSalat = FirebaseDatabase.getInstance().getReference("Salat");
        listViewSalat = (ListView) findViewById(R.id.listViewSalat);
        salatList=new ArrayList<>();
        mbutton=(Button)findViewById(R.id.button2);

    }

    public void pics(View view) {startActivity(new Intent(this, PicsActivity.class));}

    @Override
    protected void onStart() {
        super.onStart();

        databaseSalat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                salatList.clear();
                for(DataSnapshot salatSnapshot: dataSnapshot.getChildren()){
                    Salat salat=salatSnapshot.getValue(Salat.class);
                    salatList.add(salat);
                }

                SalatList adapter=new SalatList(MainActivity.this, salatList);
                listViewSalat.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
