package services.location.locationdetect;

import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MainActivity extends AppCompatActivity {
    private BottomBar bottomBar;
    NestedScrollView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBar=BottomBar.attachShy((CoordinatorLayout)findViewById(R.id.myCoordinator),
                findViewById(R.id.myScrollingContent),savedInstanceState);

        sv = (NestedScrollView) findViewById(R.id.myScrollingContent);

        bottomBar.noTabletGoodness();

        Log.d("Height",""+bottomBar.getHeight());

        bottomBar.setItems(R.menu.bottombar_menu);
        bottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bb_menu_location) {
                    LocationFragment f=new LocationFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                }
                else if(menuItemId == R.id.bb_menu_notification){
                    NotificationFragment f = new NotificationFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                }
                else if(menuItemId == R.id.bb_menu_profile){
                    ProfileFragment f = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                }
                else if(menuItemId == R.id.bb_menu_settings){
                    SettingsFragment f = new SettingsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                }
                else
                {
                    Log.d("Incorrect Choice","NIL");
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }

        });

        bottomBar.mapColorForTab(0,"#3b5998");
        bottomBar.mapColorForTab(1,"#3b5998");
        bottomBar.mapColorForTab(2,"#3b5998");
        bottomBar.mapColorForTab(3,"#3b5998");

        bottomBar.setActiveTabColor("#3b5998");

       bottomBar.makeBadgeForTabAt(1, RelativeLayout.ALIGN_RIGHT, 4);
55
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        bottomBar.onSaveInstanceState(outState);
    }
}
