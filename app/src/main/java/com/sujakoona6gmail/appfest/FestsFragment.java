package com.sujakoona6gmail.appfest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class FestsFragment extends Fragment {




    public FestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fests, container, false);



        Toast toast=Toast.makeText(getActivity(),"Welcome to Fests Bonanza",Toast.LENGTH_SHORT);
        toast.show();
Button b=(Button)rootView.findViewById(R.id.user_button);
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(getActivity(),FestlistActivity.class);
        startActivity(intent);

    }
});


        return rootView;



    }


}