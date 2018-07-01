package com.example.trains;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class EasyPage extends Activity implements OnClickListener{
ImageView Back,levelone,lvltwo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.easy);
		Back=(ImageView)findViewById(R.id.easyback);
		levelone=(ImageView)findViewById(R.id.hala);
		lvltwo=(ImageView)findViewById(R.id.easysecond);
		lvltwo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent c1= new Intent(getApplicationContext(), easyleveltwo.class);
			startActivity(c1);
			}
		});
		
		Back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			finish();	
			}
		});
		levelone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent x =new Intent(getApplicationContext(), easylevelone.class);
			startActivity(x);
			}
		});		
		
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

}
