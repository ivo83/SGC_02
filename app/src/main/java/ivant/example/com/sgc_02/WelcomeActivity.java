package ivant.example.com.sgc_02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    Toast toast;
    SharedPreferences sPref;
    public String reggedUser, reggedPass;

    TextView loginStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);

        //setUser("admin","admin");

        String[] temp = getUser(sPref);

        reggedUser = temp[0].toString();
        reggedPass = temp[1].toString();


        if( (reggedUser == "") || (reggedPass == "") ) {

            Intent intentRegister = new Intent(WelcomeActivity.this, RegistrationActivity.class);
            startActivity(intentRegister);

            // if login or pass is empty then open LoginActivity
            Intent intentLogin = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(intentLogin);

        }else
        {
            // if login or pass is empty then open LoginActivity
            Intent intentLogin = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(intentLogin);
        };



        loginStatus = (TextView) findViewById(R.id.LogInStatus);
        loginStatus.setText("You are logged as " + reggedUser);

        toast = Toast.makeText(WelcomeActivity.this, "Method onCreate in WelcomeActivity executed.", Toast.LENGTH_SHORT);
        toast.show();

    }

    @Override
    protected void onStart() {
        super.onStart();

        toast = Toast.makeText(WelcomeActivity.this, "Method onStart in WelcomeActivity executed.", Toast.LENGTH_SHORT);
        toast.show();

        //start method ToToast();
    }

    @Override
    protected void onStop() {
        super.onStop();

        toast = Toast.makeText(WelcomeActivity.this, "Method onStop in WelcomeActivity executed.", Toast.LENGTH_SHORT);
        toast.show();
        //start method ToToast();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        toast = Toast.makeText(WelcomeActivity.this, "Method onDestroy in WelcomeActivity executed.", Toast.LENGTH_SHORT);
        toast.show();
        //start method ToToast();
    }

    @Override
    protected void onPause() {
        super.onPause();

        toast = Toast.makeText(WelcomeActivity.this, "Method onPause in WelcomeActivity executed.", Toast.LENGTH_SHORT);
        toast.show();
        //start method ToToast();
    }

    @Override
    protected void onResume() {
        super.onResume();

        toast = Toast.makeText(WelcomeActivity.this, "Method onResume in WelcomeActivity executed.", Toast.LENGTH_SHORT);
        toast.show();
        //start method ToToast();
    }

    public void setRememberMeFlag(String s, SharedPreferences sp) {
        sp = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        //saving RememberMeFlag
        ed.putString("RememberMeFlag", s);
        ed.commit();
    }

    public String getRememberMeFlag(SharedPreferences sp) {
        sp = getSharedPreferences("MyPref", MODE_PRIVATE);
        return sp.getString("RememberMeFlag", "").toString();
    }

    public void setUser(String sLogin, String sPass, SharedPreferences sp) {      //

        //sPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        //saving Login
        ed.putString("Login", sLogin);
        ed.commit();
        //saving password
        ed.putString("Password", sPass);
        ed.commit();

        String e = sp.getString("Login","").toString();

        Log.d("lllll", e);
        //Toast toast = Toast.makeText(getBaseContext(), e, Toast.LENGTH_SHORT);
        //toast.show();

    }

    public String[] getUser(SharedPreferences sp){

        String[] t = new String[2];
        t[0] = "";
        t[1] = "";


        String Login = null;
        String Pass = null;

        try {
            //sPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
            Login = sp.getString("Login", "");
            Pass = sp.getString("Password", "");
        } catch (Exception e) {

            //Toast toast = Toast.makeText(getAc(),"Setting empty credentials", Toast.LENGTH_LONG);
            //toast.show();
            //setUser("","");
        }

        //Toast.makeText(LoginActivity.this, "Credentials are got.", Toast.LENGTH_SHORT).show();


        t[0] = Login;
        t[1] = Pass;
        return t;

    }

}
