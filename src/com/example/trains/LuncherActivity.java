package com.example.trains;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class LuncherActivity extends Activity implements Runnable {
	ImageView a;
	Animation fadein;

	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.firstpage);
		super.onCreate(savedInstanceState);
		if (Integer.valueOf(android.os.Build.VERSION.SDK) > 14) {
			final MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.sparrow );
			mp.start();
			a=(ImageView)findViewById(R.id.himg);
			final TextView tv =(TextView)findViewById(R.id.textView1);
			tv.setText("Loading.");
			final int x=180;
			a.animate().setDuration(1000).rotation(x).start();
		
			Handler mHandler1 = new Handler();
			mHandler1.postDelayed(new Runnable() {

				@Override
				public void run() {
					a.animate().setDuration(1000).rotation(90).start();
					tv.setText("Loading..");
				}

			}, 1000L);
			Handler mHandler2 = new Handler();
			mHandler2.postDelayed(new Runnable() {

				@Override
				public void run() {
					a.animate().setDuration(1000).rotation(x*2).start();
					tv.setText("Loading...");
				}

			}, 2000L);
			Handler mHandler3 = new Handler();
			mHandler3.postDelayed(new Runnable() {

				@Override
				public void run() {
					a.animate().setDuration(1000).rotation(x*3).start();
					tv.setText("Loading...");
				}

			}, 3000L);
			Handler mHandler4 = new Handler();
			mHandler4.postDelayed(new Runnable() {

				@Override
				public void run() {
					a.animate().setDuration(1000).rotation(x*4).start();
				}

			}, 4000L);
			Handler mHandler5 = new Handler();
			mHandler5.postDelayed(new Runnable() {

				@Override
				public void run() {
					a.animate().setDuration(1000).rotation(x*5).start();
					tv.setText("Loading......");
				}

			}, 5000L);
			fadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);

			//float x = 45;
		Handler mHandler = new Handler();
			mHandler.postDelayed(new Runnable() {

				@Override
				public void run() {
					// start your activity here
					Intent homeIntent = new Intent(getApplicationContext(), SignIn.class);
					mp.stop();
					startActivity(homeIntent);
					finish();
				}

			}, 6000L);
		} else {

			Intent homeIntent = new Intent(getApplicationContext(), SignIn.class);
			startActivity(homeIntent);
			finish();
		}

	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
	
	}

}
