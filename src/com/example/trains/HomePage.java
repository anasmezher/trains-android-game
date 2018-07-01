package com.example.trains;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePage extends Activity implements OnClickListener {
SharedPreference maysh;
TextView username,score;

	ImageView GoToeasyPage, GoTomediumPage, GoToHardPage, LogOut;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.home);
		maysh=new SharedPreference();
		username=(TextView)findViewById(R.id.tvdrivernameandLVL);
		score=(TextView)findViewById(R.id.tvdriverScore);
		GoToeasyPage = (ImageView) findViewById(R.id.easyimg);
		GoTomediumPage = (ImageView) findViewById(R.id.mediumimg);
		GoToHardPage = (ImageView) findViewById(R.id.hardimg);
		LogOut = (ImageView) findViewById(R.id.driverLogOut);

		GoToeasyPage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent GoTo = new Intent(getApplicationContext(), EasyPage.class);
				startActivity(GoTo);
			}
		});

		GoTomediumPage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent GoTo = new Intent(getApplicationContext(), MediumPage.class);
				startActivity(GoTo);
			}
		});

		GoToHardPage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent GoTo = new Intent(getApplicationContext(), HardPage.class);
				startActivity(GoTo);
			}
		});
		LogOut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreference x = new SharedPreference();
				x.removeValid(getApplicationContext());
				Intent GoTo = new Intent(getApplicationContext(), SignIn.class);
				startActivity(GoTo);
				finish();
			}
		});
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onBackPressed() {
	    AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setMessage("You Really Want To Exit? ")
	           .setCancelable(true)
	           .setPositiveButton("I'm Sure", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	                   //do things
	            	   finish();
	               }
	           }).setNegativeButton("canel", null);
	    AlertDialog alert = builder.create();
	    alert.show();
	} 
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

}
