package ivant.example.com.sgc_02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegistrationActivity extends AppCompatActivity {

    EditText etNewLogin;
    EditText etNewPass;
    EditText etConfirmNewPass;
    EditText etNewEmail;
    TextView tvRegStatus;
    Button btRegister;
    Button btCancel;

    SharedPreferences sPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);

        etNewLogin          = (EditText) findViewById(R.id.etNewLogin);
        etNewPass           = (EditText) findViewById(R.id.etNewPass);
        etConfirmNewPass    = (EditText) findViewById(R.id.etConfirmNewPass);
        etNewEmail          = (EditText) findViewById(R.id.etNewEmail);
        tvRegStatus         = (TextView) findViewById(R.id.tvRegStatus);

        btRegister          = (Button) findViewById(R.id.btRegister);
        btCancel            = (Button) findViewById(R.id.btCancel);

        Intent intent = getIntent();

        View.OnClickListener onClickListener  = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btRegister :
                        Registration();
                        break;
                    case R.id.btCancel :
                        CancelRegistration();
                        break;

                }
            }
        };

        btRegister.setOnClickListener(onClickListener);
        btCancel.setOnClickListener(onClickListener);


    }

    public void CancelRegistration() {
        tvRegStatus.setText("Cancelling registration...");
        finish();
    }

    public void Registration() {

        String login = etNewLogin.getText().toString();
        String pass  = etNewPass.getText().toString();
        String pass2 = etConfirmNewPass.getText().toString();

        if((!login.equals("")) && (!pass.equals("")) && (!pass2.equals("")) && (pass.equals(pass2))) {
            //if((pass == pass2)) {
            WelcomeActivity w = new WelcomeActivity();
            w.setUser(login,pass, sPref);

            Toast.makeText(RegistrationActivity.this, "Login and password are set", Toast.LENGTH_LONG).show();
            tvRegStatus.setText("Login and password are set");
            // }
            //else
            //{tvRegStatus.setText("Passwors are not equal!!!");}
        }
        else
        {tvRegStatus.setText("Shoud be no blank fields!!!");}



        //tvRegStatus.setText("Registration process in progress...");
    }
}
