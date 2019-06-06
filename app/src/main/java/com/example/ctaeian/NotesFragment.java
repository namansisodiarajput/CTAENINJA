package com.example.ctaeian;

import android.app.Application;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

import static android.os.Environment.DIRECTORY_DOWNLOADS;


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

        firstYearButton = (Button) view.findViewById(R.id.firstYearButton);
        secondYearButton = (Button) view.findViewById(R.id.secondYearButton);
        thirdYearButton = (Button) view.findViewById(R.id.thirdYearButton);
        fourthYearButton = (Button) view.findViewById(R.id.fourthYearButton);

        firstYearButton.setOnClickListener(new View.OnClickListener() {
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

        if(id == R.id.firstYearButton) {
            fragmentClass = FirstYearNotesFragment.class;
        } else if(id == R.id.secondYearButton) {

        } else if(id == R.id.thirdYearButton) {

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
