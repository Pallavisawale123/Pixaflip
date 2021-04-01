package com.example.pixaflip.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.pixaflip.ActivityPdf;
import com.example.pixaflip.Data.MyDbHandler;
import com.example.pixaflip.DisplayCovidActivity;
import com.example.pixaflip.DisplayPdfActivity;
import com.example.pixaflip.DisplayVideoActivity;
import com.example.pixaflip.MainActivity;
import com.example.pixaflip.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.example.pixaflip.ShowStates;
import com.spark.submitbutton.SubmitButton;

public class HomeFragment extends Fragment{

    private HomeViewModel homeViewModel;
private Button addCourseBtn;
    private MyDbHandler dbHandler;
    private String getDateTime()
    {
        SimpleDateFormat sd=new SimpleDateFormat ("yyyy-MM-ddcHH:mm:ss", Locale.getDefault ());
        Date d=new Date ();
        return sd.format(d);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

      final   Button playVideo=root.findViewById(R.id.playVideo);
        //MyDbHandler db=new MyDbHandler ( HomeFragment.this );
       final Button showPdf=root.findViewById(R.id.showPdf);
        final Button viewReport=root.findViewById(R.id.Report);

     //  addCourseBtn = root.findViewById(R.id.playVideo);
      // dbHandler = new MyDbHandler(getContext ());

      // addCourseBtn = root.findViewById(R.id.playVideo);
        //dbHandler = new MyDbHandler (HomeFragment.this);

        //bach preesed
       // public void onBackPressed

        //SubmitButton viewStatewise=root.findViewById(R.id.Statewise);
        

       playVideo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //String courseName= getPackageName () ;
               // String courseTracks=getLocalClassName ();
               // String courseDuration=getDateTime ();
                // String courseDescription = courseDescriptionEdt.getText().toString();

                dbHandler = new MyDbHandler(getContext ());
                dbHandler.adduseract ( "DisplayVideoActivity", "", getDateTime () );
                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                //dbHandler.adduseract(courseName, courseTracks,courseDuration);
                //play video in landscape mode.
                Intent intent=new Intent(MainActivity.context, DisplayVideoActivity.class);
                startActivity(intent);
                // Toast.makeText(MainActivity.context,"Play video available in Assets folder",Toast.LENGTH_LONG).show();

            }
        });


        showPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler = new MyDbHandler(getContext ());
              dbHandler.adduseract ( "DisplayPdfActivity" ,getClass ().toString (),getDateTime ());
                Intent intent=new Intent(MainActivity.context, DisplayPdfActivity.class);
                startActivity(intent);
            }
        });

        viewReport.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dbHandler = new MyDbHandler(getContext ());
                dbHandler.adduseract ("DisplayCovidActivity" ,getClass ().toString (),getDateTime ());
                Intent intent=new Intent(MainActivity.context,DisplayCovidActivity.class);
                startActivity(intent);
            }

        });
/*
        viewStatewise.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.context, ShowStates.class);
                startActivity(intent);
            }

        });

*/
        return root;
    }
}