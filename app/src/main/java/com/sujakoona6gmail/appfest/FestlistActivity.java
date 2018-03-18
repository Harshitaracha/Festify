package com.sujakoona6gmail.appfest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FestlistActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private ListView listview;
    private Button button;
    private ArrayList<String>  eventnames=new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;
    Event ev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festlist);
        ev=new Event();

        databaseReference= FirebaseDatabase.getInstance().getReference("User");
        listview=(ListView)findViewById(R.id.user_list);

         arrayAdapter=new ArrayAdapter<String>(this,R.layout.listitem,R.id.eventitem,eventnames);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position,
                                    long id) {

                Object o = adapter.getItemAtPosition(position);
                String str_text = o.toString();

                Intent intent = new Intent(view.getContext(), EventInfoActivity.class);
                intent.putExtra("StrValue", str_text);
                startActivity(intent);
            }

        });




        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    ev=ds.getValue(Event.class);
                    eventnames.add(ev.getEvenntname());

                }
                 listview.setAdapter(arrayAdapter);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
      /***  AdapterView.OnItemClickListener onListClick= new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(view.getContext(),EventInfoActivity.class);
                String name=listview.getSelectedItem().toString();
                intent.putExtra("Event name",name);
                startActivity(intent);

            }
        };

        listview.setOnItemClickListener(onListClick);*/

       /*** databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getValue(String.class);
                eventnames.add(value);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
    }
}
