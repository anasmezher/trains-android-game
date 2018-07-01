package com.example.trains;


import java.nio.channels.ReadableByteChannel;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class easylevelone extends Activity implements OnClickListener, OnTouchListener {
	ImageView Back;
	MediaPlayer backGroundSound;
	RelativeLayout mymaplayout;
	int hitcount = 0, misscount = 0;
	int[] xpoints, ypoints;
	int starttunnelpointX = 58, starttunnelpointY = 115;
	int numboftrains = 3;
	int wasle1state, wasle2state;
	ImageView myMap;
	ImageView wasleone, wasletwo;
	TextView myTime,hittext,misstext,mscore;
	int result;
	float maxx,maxy;
	private Timer myTimer;
	long starttime;
	String score;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.easylevelone);
		myTime = (TextView) findViewById(R.id.timeinl1easy);
		hittext = (TextView) findViewById(R.id.hitinl1easy);
		misstext = (TextView) findViewById(R.id.missinl1easy);
		mscore = (TextView) findViewById(R.id.scoreinl1easy);
		misstext.setText(misscount+" ");
		hittext.setText(hitcount+" ");
		starttime = System.currentTimeMillis();
		myTimer = new Timer();
		myTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				TimerMethod();

			}

		}, 0, 100);
		backGroundSound = MediaPlayer.create(getApplicationContext(), R.raw.back2);
		backGroundSound.start();
		mymaplayout = (RelativeLayout) findViewById(R.id.rl);
		wasleone = new ImageView(getApplicationContext());
		wasleone.setBackgroundResource(R.drawable.wasl1lvl1easy);
		wasle1state = 1;
		LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		wasleone.setLayoutParams(lp);
		mymaplayout.addView(wasleone);
		maxy=mymaplayout.getMeasuredHeight();
		maxx=mymaplayout.getWidth();
		Toast.makeText(getApplicationContext(), maxx+"+"+maxy, Toast.LENGTH_LONG).show();
		
		// x=25, Y=357
		wasleone.animate().translationX(35).translationY(380).setDuration(0).start();
		wasleone.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (wasle1state == 1) {
					wasle1state = 2;
					wasleone.setBackgroundResource(R.drawable.wasl1state2lvl1easy);
				} else if (wasle1state == 2) {
					wasle1state = 1;
					wasleone.setBackgroundResource(R.drawable.wasl1lvl1easy);
				}
			}
		});

		wasletwo = new ImageView(getApplicationContext());
		wasletwo.setBackgroundResource(R.drawable.wasle2state1easy1);
		wasle2state = 1;
		wasletwo.setLayoutParams(lp);
		mymaplayout.addView(wasletwo);
		// x=25, Y=357
		wasletwo.animate().translationX(240).translationY(385).setDuration(1).start();
		wasletwo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (wasle2state == 1) {
					wasle2state = 2;
					wasletwo.setBackgroundResource(R.drawable.wasle2state2easy1);
				} else if (wasle2state == 2) {
					wasle2state = 1;
					wasletwo.setBackgroundResource(R.drawable.wasle2state1easy1);
				}
			}
		});

		myMap = (ImageView) findViewById(R.id.imageView1);
		myMap.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent mm) {
				// TODO Auto-generated method stub
				if (mm.getAction() == MotionEvent.ACTION_DOWN) {
	
					maxx=arg0.getHeight();
					maxy=arg0.getWidth();
					
					float myX = mm.getX();
					float myY = mm.getY();
					Log.d("my touched point =", "x=" + (float)(myX/maxx)*100 + ",  Y=" + (float)(myY/maxy)*100);
				}
				return false;
			}
		});

		for (int i = 0; i < 90; i++) {
			final long delay = i * 5000;
			Handler mHandler1 = new Handler();
			mHandler1.postDelayed(new Runnable() {

				@Override
				public void run() {
					final Map myLevel;
					myLevel = new Map(getApplicationContext(), 1, 3);
					myLevel.generate_AndMove(mymaplayout, (float)(starttunnelpointX/maxx)*100, (float)(starttunnelpointY/maxy)*100, starttunnelpointX, (float)(380/maxy)*100,
							5000);
					Handler mHandler1 = new Handler();
					mHandler1.postDelayed(new Runnable() {

						@Override
						public void run() {
							if (wasle1state == 1) {
								myLevel.Move(starttunnelpointX, 729, 7000);
								Handler mHandler1 = new Handler();
								mHandler1.postDelayed(new Runnable() {

									@Override
									public void run() {
										// TODO Auto-generated method stub
										myLevel.Move(186, 750, 3500);
										Handler mHandler1 = new Handler();
										mHandler1.postDelayed(new Runnable() {

											@Override
											public void run() {
												// TODO Auto-generated method
												// stub
												myLevel.Move(356, 651, 3500);
												Handler mHandler1 = new Handler();
												mHandler1.postDelayed(new Runnable() {

													@Override
													public void run() {
														// TODO Auto-generated
														// method stub
														String mColor = myLevel.get_train_Color();
														if (mColor.equals("blue")) {
															hitcount++;

														} else if (mColor.equals("happy")) {
															hitcount += 2;

														} else if (mColor.equals("angry")) {
															misscount += 2;

														} else {
															misscount += 1;

														}
														myLevel.dellete_Train();
														misstext.setText(misscount+" ");
														hittext.setText(hitcount+" ");
													}
												}, 3500);

											}
										}, 3500);
									}
								}, 7000);

							}

							if (wasle1state == 2) {
								myLevel.Move(270, 380, 7000);
								Handler mHandler1 = new Handler();
								mHandler1.postDelayed(new Runnable() {

									@Override
									public void run() {
										// TODO Auto-generated method stub
										if (wasle2state == 1) {
											myLevel.Move(360, 135, 7000);
											Handler mHandler1 = new Handler();
											mHandler1.postDelayed(new Runnable() {

												@Override
												public void run() {
													// TODO Auto-generated
													// method stub
													String mColor = myLevel.get_train_Color();
													if (mColor.equals("red")) {
														hitcount++;

													} else if (mColor.equals("happy")) {
														hitcount += 2;

													} else if (mColor.equals("angry")) {
														misscount += 2;

													} else {
														misscount += 1;

													}
													myLevel.dellete_Train();
													misstext.setText(misscount+" ");
													hittext.setText(hitcount+" ");
												}
											}, 7000);
										}

										if (wasle2state == 2) {
											myLevel.Move(365, 480, 3500);
											Handler mHandler1 = new Handler();
											mHandler1.postDelayed(new Runnable() {

												@Override
												public void run() {
													// TODO Auto-generated
													// method stub
													myLevel.Move(444, 410, 2000);
													Handler mHandler1 = new Handler();
													mHandler1.postDelayed(new Runnable() {

														@Override
														public void run() {
															// TODO
															// Auto-generated
															// method stub
															myLevel.Move(460, 428, 2000);
															String mColor = myLevel.get_train_Color();
															if (mColor.equals("green")) {
																hitcount++;

															} else if (mColor.equals("happy")) {
																hitcount += 2;

															} else if (mColor.equals("angry")) {
																misscount += 2;

															} else {
																misscount += 1;

															}
															myLevel.dellete_Train();
															misstext.setText(misscount+" ");
															hittext.setText(hitcount+" ");
														}
													}, 2000);
												}
											}, 3500);

										}

									}
								}, 7000);

							}

						}

					}, 5000);
				}

			}, delay);

		}

		// //if reached dist
		// result = myLevel.ComputeResult(elspedTime, hitcount, misscount,
		// bounusnumber);
		super.onCreate(savedInstanceState);
	}

	private void TimerMethod() {
		// This method is called directly by the timer
		// and runs in the same thread as the timer.

		// We call the method that will work with the UI
		// through the runOnUiThread method.
		this.runOnUiThread(Timer_Tick);
	}

	private Runnable Timer_Tick = new Runnable() {
		public void run() {

			// This method runs in the same thread as the UI.

			// Do something to the UI thread here
			
			long millis = System.currentTimeMillis() - starttime;
			int seconds = (int) (millis / 1000);
			int minutes = seconds / 60;
			seconds = seconds % 60;
			myTime.setText(minutes + ":" + seconds+":"+(millis-seconds*1000));
			score=ComputeResult(millis, hitcount, misscount);
			mscore.setText(score);

		}
	};

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onBackPressed() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("You Really Want To Cancel? ").setCancelable(true)
				.setPositiveButton("I'm Sure", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// do things
						backGroundSound.stop();
						finish();
					}
				}).setNegativeButton("canel", null);
		AlertDialog alert = builder.create();
		alert.show();
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	public String ComputeResult(long millis, int hitcount, int misscount) {
		int result = 0;
		result = (int) (millis * (hitcount) - misscount*50 / 3);
		return result+" ";

	}

}
