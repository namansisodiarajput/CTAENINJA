package com.example.ctaeian;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AttendanceFragment extends Fragment {
    Button firstYearButton,secondYearButton,thirdYearButton,fourthYearButton;

    public AttendanceFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("ATTENDENCE");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);

        firstYearButton = (Button) view.findViewById(R.id.ATTENDENCE_FIRST_YEAR);
        secondYearButton = (Button) view.findViewById(R.id.ATTENDENCE_SECOND_YEAR);
        thirdYearButton = (Button) view.findViewById(R.id.ATTENDENCE_THIRD_YEAR);
        fourthYearButton = (Button) view.findViewById(R.id.ATTENDENCE_FOURTH_YEAR);

        firstYearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonSelection(v.getId());
            }
        });

        secondYearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonSelection(v.getId());
            }
        });

        thirdYearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonSelection(v.getId());
            }
        });

        fourthYearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonSelection(v.getId());
            }
        });


        return view;
    }

    private void onButtonSelection(int id) {

        Fragment fragment = null;
        Class fragmentClass = null;

        if(id == R.id.ATTENDENCE_FIRST_YEAR) {
            fragmentClass = AttendanceFirstYearFragment.class;
        } else if(id == R.id.ATTENDENCE_SECOND_YEAR) {
            fragmentClass = AttendanceFirstYearFragment.class;
        } else if(id == R.id.ATTENDENCE_THIRD_YEAR) {
            fragmentClass = AttendanceFirstYearFragment.class;
        } else  if(id == R.id.ATTENDENCE_FOURTH_YEAR) {
            fragmentClass = AttendanceFirstYearFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

    }





    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
