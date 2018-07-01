package com.example.trains;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends Activity implements OnClickListener{
TextView linkLogin;
EditText name,email,pass;
String getname,getemail,getpass;
Button signUp;
SharedPreference myD;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.sign_up);
		linkLogin =(TextView)findViewById(R.id.link_login);
		name=(EditText)findViewById(R.id.input_name);
		email=(EditText)findViewById(R.id.input_email);
		pass=(EditText)findViewById(R.id.input_password);
		signUp=(Button)findViewById(R.id.btn_signup);
		myD=new SharedPreference();
		linkLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent logIn = new Intent(getApplicationContext(), SignIn.class);
			startActivity(logIn);
			finish();
			}
		});
	
		signUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				getemail=email.getText().toString();
				getname=name.getText().toString();
				getpass=pass.getText().toString();
				myD.save(getApplicationContext(), getname, getemail, getpass, "0");
				Toast.makeText(getApplicationContext(), "Successfully registered .. THankYou", Toast.LENGTH_LONG).show();
				Intent toLogin= new Intent(getApplicationContext(), SignIn.class);
				startActivity(toLogin);
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
