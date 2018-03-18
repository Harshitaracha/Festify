package com.sujakoona6gmail.appfest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EventFormActivity extends AppCompatActivity {
    private EditText event_name_info, college_name_info, state_info,
            district_info, locality_info, event_co_name_info, event_co_phno_info,
            event_co_emailid_info, event_reg_link_info, description_info;
    private RadioButton techfest,cultfest,workshop,competition;
    private Button btcontinue;
    private RadioGroup radioGroup;

    public DatabaseReference mDatabase;
    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_form);

        event_name_info = (EditText) findViewById(R.id.event_name_info);
        college_name_info = (EditText) findViewById(R.id.college_name_info);
        state_info = (EditText) findViewById(R.id.state_info);
        district_info = (EditText) findViewById(R.id.district_info);
        locality_info = (EditText) findViewById(R.id.locality_info);
        event_co_name_info = (EditText) findViewById(R.id.event_co_name_info);
        event_co_phno_info = (EditText) findViewById(R.id.event_co_phno_info);
        event_co_emailid_info = (EditText) findViewById(R.id.event_co_emailid_info);
        event_reg_link_info = (EditText) findViewById(R.id.event_reg_link_info);
        description_info = (EditText) findViewById(R.id.description_info);

        techfest = (RadioButton) findViewById(R.id.technical_fest);
        cultfest = (RadioButton) findViewById(R.id.cultural_fest);
        workshop = (RadioButton) findViewById(R.id.workshops);
        competition = (RadioButton) findViewById(R.id.competitions);
        btcontinue = (Button) findViewById(R.id.btcontinue);
        mDatabase = FirebaseDatabase.getInstance().getReference("User");
        event = new Event();
    }

 private void getvalues(){
     String event_name = event_name_info.getText().toString().trim();
     String college_name = college_name_info.getText().toString().trim();
     String state_name = state_info.getText().toString().trim();
     String district_name = district_info.getText().toString().trim();
     String localty_name = locality_info.getText().toString().trim();
     String coordinator_name = event_co_name_info.getText().toString().trim();
     String coordinator_phone = event_co_phno_info.getText().toString().trim();
     String link_name = event_reg_link_info.getText().toString().trim();
     String coordinator_mail = event_co_emailid_info.getText().toString().trim();
     String event_description = description_info.getText().toString().trim();
     event.setEvenntname(event_name);
     event.setCollegename(college_name);
     event.setState(state_name);
     event.setDistrict(district_name);
     event.setLocalty(localty_name);
     event.setCoordinatorname(coordinator_name);
     event.setContactno(coordinator_phone);
     event.setEmail_id(coordinator_mail);
     event.setUrl(link_name);
     event.setDescription(event_description);

    }


public void btninsert(View view){
     mDatabase.addValueEventListener(new ValueEventListener() {
         @Override
         public void onDataChange(DataSnapshot dataSnapshot) {
             getvalues();
             mDatabase.child("User02").setValue(event);
             Toast.makeText(EventFormActivity.this,"Data inserted successfully...",Toast.LENGTH_LONG).show();
             

         }

         @Override
         public void onCancelled(DatabaseError databaseError) {

         }
     });
}



 /**btcontinue.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
                   String event_name = event_name_info.getText().toString().trim();
                   String college_name = college_name_info.getText().toString().trim();
                   String state_name = state_info.getText().toString().trim();
                   String district_name = district_info.getText().toString().trim();
                   String localty_name = locality_info.getText().toString().trim();
                   String coordinator_name = event_co_name_info.getText().toString().trim();
                   String coordinator_phone = event_co_phno_info.getText().toString().trim();
                   String link_name = event_reg_link_info.getText().toString().trim();
                   String coordinator_mail = event_co_emailid_info.getText().toString().trim();
                   String event_description = description_info.getText().toString().trim();


                  /*** HashMap<String,String> datamap=new HashMap<String,String>();
                   datamap.put("Event name:",event_name);
                   datamap.put("College name:",college_name);
                   datamap.put("State name:",state_name);
                   datamap.put("District name:",district_name);
                   datamap.put("Localty name:",localty_name);
                   datamap.put("Co-ordinator name:",coordinator_name);
                   datamap.put("Coordinator Phone no:",coordinator_phone);
                   datamap.put("Registration link:",link_name);
                   datamap.put("Co-ordinator mail:",coordinator_mail);
                   datamap.put("Event Description",event_description);
                   mDatabase.push().setValue(datamap);



/***                  mDatabase.child("Event name:").setValue(event_name);
                    mDatabase.child("College name:").setValue(college_name);
                    mDatabase.child("State name:").setValue(state_name);
                    mDatabase.child("District name:").setValue(district_name);
                    mDatabase.child("Localty name:").setValue(localty_name);
                    mDatabase.child("Co-ordinator name:").setValue(coordinator_name);
                    mDatabase.child("Coordinator Phone no:").setValue(coordinator_phone);
                    mDatabase.child("Registration link:").setValue(link_name);
                    mDatabase.child("Co-ordinator mail:").setValue(coordinator_mail);
                    mDatabase.child("Event Description").setValue(event_description);

*/











        }




