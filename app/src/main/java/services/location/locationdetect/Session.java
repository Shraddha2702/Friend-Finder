package services.location.locationdetect;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by SHRADDHA on 01-08-2016.
 */
public class Session {
    Context myContext;
    Boolean isLoggedIn=false;
    SharedPreferences pref;
    SharedPreferences.Editor edit;

    Session(Context myContext){
        this.myContext=myContext;
        pref=myContext.getSharedPreferences("AppLogin",0);
        edit= pref.edit();
    }

    public Boolean getLoggedIn() {

        return pref.getBoolean("isLoggedIn",isLoggedIn);
    }

    public void setLoggedIn(Boolean loggedIn) {
        isLoggedIn = loggedIn;
        edit.putBoolean("isLoggedIn",loggedIn);
        edit.commit();
    }
}
