package com.example.trains;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class SignIn extends Activity implements OnClickListener {
	TextView linksignup;
	EditText email, pass;
	String getemail, getpass;
	String mysavedpss, mysavedemail, valid;
	SharedPreference myf;
	Button LogInNow;
    static int log=0;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.signin);
		linksignup = (TextView) findViewById(R.id.link_signup);
		email = (EditText) findViewById(R.id.input_email);
		pass = (EditText) findViewById(R.id.input_password);
		myf = new SharedPreference();
		mysavedemail = "1";
		mysavedpss = "1";
		valid = "1";
		if(log!=0){
		mysavedemail = myf.getemailValue(getApplicationContext());
		mysavedpss = myf.getpassValue(getApplicationContext());
		valid = myf.getvalidValue(getApplicationContext());
		if(valid.equals("0")){
			Toast.makeText(getApplicationContext(), "Wellcome  "+myf.getnameValue(getApplicationContext()), Toast.LENGTH_LONG).show();
			Intent go = new Intent(getApplicationContext(), HomePage.class);
			startActivity(go);
			finish();
		}
		}
		else{
			
			myf.save(getApplicationContext(), "no", "e@m.com", "123", "1");
			log=15;
		}
		LogInNow = (Button) findViewById(R.id.btn_login);

		LogInNow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				getemail = email.getText().toString();
				getpass = pass.getText().toString();
				if (mysavedemail.equals(getemail) && mysavedpss.equals(getpass)) {
					
					myf.setValid(getApplicationContext());
					Toast.makeText(getApplicationContext(), "THank", Toast.LENGTH_LONG).show();
					Intent go = new Intent(getApplicationContext(), HomePage.class);
					startActivity(go);
					finish();
				} else {
					Toast.makeText(getApplicationContext(),
							"ERROR!!! saved email=" + mysavedemail + "Pass=" + mysavedpss, Toast.LENGTH_LONG).show();

				}
			}
		});
		linksignup.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent signup = new Intent(getApplicationContext(), SignUp.class);
				startActivity(signup);
				finish();
			}
		});
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

}
