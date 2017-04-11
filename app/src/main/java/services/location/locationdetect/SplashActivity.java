package services.location.locationdetect;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    private static final int sec = 3000;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                session=new Session(getApplicationContext());

                if(session.getLoggedIn().equals(true))
                {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);

                }
                else
                {
                    Intent i=new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(i);
                }

                finish();
            }
        }, sec);

    }
}
