package services.location.locationdetect;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.vision.text.Line;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends android.support.v4.app.Fragment   {

    LinearLayout setAbout;
    LinearLayout setProfile;
    LinearLayout logout;
    LinearLayout showMap;
    LinearLayout showLocation;
    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_settings,container,false);
        setAbout = (LinearLayout)view.findViewById(R.id.setcontact);
        setProfile = (LinearLayout) view.findViewById(R.id.setprofile);
        showMap = (LinearLayout) view.findViewById(R.id.setgoal);
        showLocation = (LinearLayout)view.findViewById(R.id.setmonthly);
        logout = (LinearLayout)view.findViewById(R.id.setLogout);

        setAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                AbtFragment sm = new AbtFragment();
                ft.replace(R.id.frame,sm);
                ft.commit();
            }
        });

        setProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ProfileFragment pm = new ProfileFragment();
                ft.replace(R.id.frame, pm);
                ft.commit();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                final Dialog d = new Dialog(getActivity());
                d.setContentView(R.layout.logout_main);
                d.setTitle("Log Out");

                Button yes = (Button) d.findViewById(R.id.yeslogout);
                Button no = (Button) d.findViewById(R.id.nologout);
                d.show();

                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Session s = new Session(getActivity());
                        s.setLoggedIn(false);


                        d.dismiss();

                        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                        homeIntent.addCategory( Intent.CATEGORY_HOME );
                        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(homeIntent);
                        getActivity().finish();
                        System.exit(0);
            }
        });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });
            }
        });

        showMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                MapsActivity pm = new MapsActivity();
                ft.replace(R.id.frame, pm);
                ft.commit();
            }
        });

        showLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                LocationActivity pm = new LocationActivity();
                ft.replace(R.id.frame, pm);
                ft.commit();
            }
        });
        return view;
    }
}
