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
        firstYearButton = (Button) view.findViewById(R.id.firstYearPaperButton);
        secondYearButton = (Button) view.findViewById(R.id.secondYearPaperButton);
        thirdYearButton = (Button) view.findViewById(R.id.thirdYearPaperButton);
        fourthYearButton = (Button) view.findViewById(R.id.fourthYearPaperButton);

        firstYearButton.setOnClickListener(new View.OnClickListener() {
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

        if(id == R.id.firstYearPaperButton) {
            fragmentClass = FirstYearPreviousPaperFragment.class;
        } else if(id == R.id.secondYearPaperButton) {

        } else if(id == R.id.thirdYearPaperButton) {

        } else  if(id == R.id.fourthYearButton) {

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
