package services.location.locationdetect;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by SHRADDHA on 06-04-2017.
 */

public class AbtFragment extends android.support.v4.app.Fragment {
    Button goback;
    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        text = (TextView)v.findViewById(R.id.text);
        goback = (Button)v.findViewById(R.id.gobackset);

        text.setText("The world has seen an immense transformation in the last few decades in terms\n" +
                "of Technology, from self-driving cars to manipulating Big Data, human beings\n" +
                "have gone to an extend which makes even an illiterate capable enough to bring\n" +
                "about a big change for the generations to come. It has given a person power to\n" +
                "access the data from across the globe on his miniature device.\n" +
                "Everyone in the modern times has utilized this technology in their own fine\n" +
                "way. People crave to be a socially active for some sake, from Facebook to\n" +
                "Instagram and Twitter, everyone is trying to stay connected with the loved and\n" +
                "close ones in every possible way. With this Android application, the user gets to\n" +
                "keep a track of all their friends and family through their mobile phones. It's an\n" +
                "exciting feeling to always know where your friends are. And the chances are\n" +
                "that you might be strolling around in a particular locality and we to know that\n" +
                "one of your friends is in the same space then we could just catch him up for\n" +
                "some surprise.\n" +
                "The application would also have a special feature through which you can send\n" +
                "in notifications to people you are connected to. It gives an high level of security\n" +
                "to the users, as they would always have someone who could keep a track of\n" +
                "their location and in case of an Emergency user could just notify all his\n" +
                "connections for the help. It's an appealing concept for the masses as well as the\n" +
                "aged and some cool features in it would add much more interactivity from the\n" +
                "user point of view.");


        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                SettingsFragment st = new SettingsFragment();
                ft.replace(R.id.frame,st);
                ft.commit();
            }
        });
        return v;
    }

}
