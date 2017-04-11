package services.location.locationdetect;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by SHRADDHA on 01-08-2016.
 */
public class UserInformation {
    String Username;
    String Email;
    String Password;

    SharedPreferences sp;
    SharedPreferences.Editor edit;
    Context myContext;

    UserInformation(Context myContext){
        this.myContext=myContext;
        sp=myContext.getSharedPreferences("UserInfo",0);
        edit=sp.edit();
    }

    public String getUsername() {
        return sp.getString("USERNAME","");
    }

    public void setUsername(String username) {
        Username = username;
        edit.putString("USERNAME",Username);
        edit.commit();
    }

    public String getEmail() {
        return sp.getString("EMAIL"," ");
    }

    public void setEmail(String email) {
        Email = email;
        edit.putString("EMAIL",Email);
        edit.commit();
    }

    public String getPassword() {
        return sp.getString("PASSWORD"," ");
    }

    public void setPassword(String password) {
        Password = password;
        edit.putString("PASSWORD",Password);
        edit.commit();
    }
}
