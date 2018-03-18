package com.sujakoona6gmail.appfest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EventInfoActivity extends AppCompatActivity {
    TextView event_name_info, college_name_info, state_info,
            district_info, locality_info, event_co_name_info, event_co_phno_info,
            event_co_emailid_info, event_reg_link_info, description_info;
    private DatabaseReference databaseReference;


    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);
        event = new Event();
        event_name_info = (TextView) findViewById(R.id.eventinfotext);

        college_name_info = (TextView) findViewById(R.id.rcollege_name_info);
        state_info = (TextView) findViewById(R.id.rstate_info);
        district_info = (TextView) findViewById(R.id.rdistrict_info);
        locality_info = (TextView) findViewById(R.id.rlocality_info);
        event_co_name_info = (TextView) findViewById(R.id.revent_co_name_info);
        event_co_phno_info = (TextView) findViewById(R.id.revent_co_phno_info);
        event_co_emailid_info = (TextView) findViewById(R.id.revent_co_emailid_info);
        event_reg_link_info = (TextView) findViewById(R.id.revent_reg_link_info);
        description_info = (TextView) findViewById(R.id.rdescription_info);

        databaseReference= FirebaseDatabase.getInstance().getReference("User");
        event_name_info.setText(getIntent().getExtras().getString("StrValue"));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    event = ds.getValue(Event.class);
                    String name = event.getEvenntname();
                    if (name.equalsIgnoreCase(event_name_info.getText().toString())) {
                        college_name_info.setText(event.getCollegename());
                        state_info.setText(event.getState());
                        district_info.setText(event.getDistrict());
                        locality_info.setText(event.getLocalty());
                        event_co_name_info.setText(event.getCoordinatorname());
                        event_co_phno_info.setText(event.getContactno());
                        event_co_emailid_info.setText(event.getEmail_id());
                        event_reg_link_info.setText(event.getUrl());
                        description_info.setText(event.getDescription());
                        break;
                    }

                }

            }

            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}