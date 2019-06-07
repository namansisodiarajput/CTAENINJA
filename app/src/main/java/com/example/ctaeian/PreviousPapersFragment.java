package com.example.ctaeian;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class PreviousPapersFragment extends Fragment {

    Button firstYearButton,secondYearButton,thirdYearButton,fourthYearButton;

    public PreviousPapersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Previous Year Paper");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_previous_papers, container, false);
        firstYearButton = (Button) view.findViewById(R.id.firstYearPapersButton);
        secondYearButton = (Button) view.findViewById(R.id.secondYearPapersButton);
        thirdYearButton = (Button) view.findViewById(R.id.thirdYearPapersButton);
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


        return view;
    }


    private void onButtonSelection(int id) {

        Fragment fragment = null;
        Class fragmentClass = null;

        if(id == R.id.firstYearPapersButton) {
            fragmentClass = FirstYearPreviousPaperFragment.class;
        } else if(id == R.id.secondYearPapersButton) {
            fragmentClass = SecondYearPreviousPaperFragment.class;
        } else if(id == R.id.thirdYearPapersButton) {
            fragmentClass = ThirdYearPreviousPaperFragment.class;
        } else  if(id == R.id.firstYearPapersButton) {
            fragmentClass = FourthYearPreviousPaperFragment.class;
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
