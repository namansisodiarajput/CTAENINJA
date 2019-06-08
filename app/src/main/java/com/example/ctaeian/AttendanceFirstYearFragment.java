package com.example.ctaeian;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.os.Environment.DIRECTORY_DOWNLOADS;


public class AttendanceFirstYearFragment extends Fragment {

    FirebaseStorage storage;
    // Create a storage reference from our app
    StorageReference storageRef;

    Button FIRST_YEAR_SECTIONA,FIRST_YEAR_SECTIONB;
    private ProgressDialog progressDialog;


    public AttendanceFirstYearFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("ATTENDENCE");

        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

        progressDialog = new ProgressDialog(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attendance_first_year, container, false);
        FIRST_YEAR_SECTIONA = (Button) view.findViewById(R.id.FIRST_YEAR_ATTENDENCE_SECTIONA);
        FIRST_YEAR_SECTIONB = (Button) view.findViewById(R.id.FIRST_YEAR_ATTENDENCE_SECTIONB);

        FIRST_YEAR_SECTIONA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadFileFromFirebaseStroage();
            }
        });

        FIRST_YEAR_SECTIONB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadFileFromFirebaseStroage();
            }
        });

        return view;
    }

    public void downloadFileFromFirebaseStroage() {

        progressDialog.setMessage("downloading.....");
        progressDialog.show();

        StorageReference childRef = storageRef.child("images.zip");
        childRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                progressDialog.dismiss();
                String url = uri.toString();
                downloadfile(getContext(),"images","zip",DIRECTORY_DOWNLOADS,url);
                Toast.makeText(getContext(),"File is downloading",Toast.LENGTH_LONG).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(getContext(),"Error Occured : "+e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public void downloadfile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {

        DownloadManager downloadManager = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);

        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context,destinationDirectory,fileName+fileExtension);

        downloadManager.enqueue(request);


    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
