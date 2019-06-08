package com.example.ctaeian;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;

import static android.os.Environment.DIRECTORY_DOWNLOADS;


public class ResultFragment extends Fragment {

    Button firstYearButton,secondYearButton,thirdYearButton,fourthYearButton;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("RESULT");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        firstYearButton = (Button) view.findViewById(R.id.RESULT_FIRST_YEAR);
        secondYearButton = (Button) view.findViewById(R.id.RESULT_SECOND_YEAR);
        thirdYearButton = (Button) view.findViewById(R.id.RESULT_THIRD_YEAR);
        fourthYearButton = (Button) view.findViewById(R.id.RESULT_FOURTH_YEAR);

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

        if(id == R.id.RESULT_FIRST_YEAR) {
            fragmentClass = ResultFirstYearFragment.class;
        } else if(id == R.id.RESULT_SECOND_YEAR) {
            fragmentClass = ResultFirstYearFragment.class;
        } else if(id == R.id.RESULT_THIRD_YEAR) {
            fragmentClass = ResultFirstYearFragment.class;
        } else  if(id == R.id.RESULT_FOURTH_YEAR) {
            fragmentClass = ResultFirstYearFragment.class;
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
