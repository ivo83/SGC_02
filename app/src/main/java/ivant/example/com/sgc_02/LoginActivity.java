package ivant.example.com.sgc_02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etLogin;
    EditText etPass;
    Button btLogin;
    Button btExit;
    CheckBox cbRememberMe;
    TextView tvStatus;
    TextView tvRegister;

    SharedPreferences sPref;

    Methods methods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = (EditText) findViewById(R.id.etLogin);
        etPass  = (EditText) findViewById(R.id.etPass);
        btLogin = (Button) findViewById(R.id.btLogin);
        btExit  = (Button) findViewById(R.id.btExit);
        cbRememberMe    = (CheckBox) findViewById(R.id.cbRememberMe);
        tvStatus        = (TextView) findViewById(R.id.tvStatus);
        tvRegister      = (TextView) findViewById(R.id.tvRegister);

        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btLogin :
                        userLogin();
                        break;
                    case R.id.btExit :
                        userExit();
                        break;
                    case R.id.cbRememberMe :
                        clickRememberMe();
                        break;
                    case R.id.tvRegister :
                        startRegistration();
                        break;
                }
            }
        };

        btLogin.setOnClickListener(onClickListener);
        btExit.setOnClickListener(onClickListener);
        cbRememberMe.setOnClickListener(onClickListener);
        tvRegister.setOnClickListener(onClickListener);
    }

    private void startRegistration() {
        Intent intentRegister = new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(intentRegister);
    }

    private void clickRememberMe() {

        if(cbRememberMe.isChecked()) {
            //this.setRememberMeFlag("true");
        }

        tvStatus.setText("Status of Remember Me changed. Functionality not implemented ");
    }

    private void userExit() {

        tvStatus.setText("Exiting application...");
        System.exit(0);
    }

    public void userLogin() {
        tvStatus.setText("Checking credentials...");

        String enteredLogin = (String) etLogin.getText().toString();
        String enteredPassw = (String) etPass.getText().toString();



        if( (!enteredLogin.equals("")) && (!enteredPassw.equals(""))){

            WelcomeActivity w = new WelcomeActivity();

            String[] temp = w.getUser(sPref);


            if( (enteredLogin.equals(temp[0])) && (enteredPassw.equals(temp[1])) ) {

                tvStatus.setText("You've logged in successfully!");

                finish();

               }
            else
            {
                tvStatus.setText("Bad credentials! Try again");

            }

        }else
        {
            tvStatus.setText("Bad credentials! Try again");
        }


    }




}
