package com.example.ctaeian;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class NotesFragment extends Fragment {

    Button firstYearButton,secondYearButton,thirdYearButton,fourthYearButton;

    public NotesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Notes");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        firstYearButton = (Button) view.findViewById(R.id.CS);
        secondYearButton = (Button) view.findViewById(R.id.ELECTRICAL);
        thirdYearButton = (Button) view.findViewById(R.id.AGRICULTURE);
        fourthYearButton = (Button) view.findViewById(R.id.fourthYearNotesButton);

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


        return  view;
    }

    private void onButtonSelection(int id) {

        Fragment fragment = null;
        Class fragmentClass = null;

        if(id == R.id.CS) {
            fragmentClass = FirstYearNotesFragment.class;
        } else if(id == R.id.ELECTRICAL) {
            fragmentClass = SecondYearNotesFragment.class;
        } else if(id == R.id.AGRICULTURE) {
            fragmentClass = ThirdYearNotesFragment.class;
        } else  if(id == R.id.fourthYearNotesButton) {
            fragmentClass = FourthYearNotesFragment.class;
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
