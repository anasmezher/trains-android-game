package com.example.trains;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class easyleveltwo extends Activity implements OnClickListener,OnTouchListener{
ImageView Back;
Map myLevel;
int [] xpoints,ypoints;
private int[] Railxpoints;
private int[] Railypoints;
private int elspedTime;
private int hitcount;
private int misscount;
private int bounusnumber;
ImageView myMap;
int result;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.easyleveltwo);
		
		myMap=(ImageView)findViewById(R.id.imageView2);
		myMap.setOnTouchListener(new OnTouchListener() {
			
			

			@Override
			public boolean onTouch(View arg0, MotionEvent mm) {
				// TODO Auto-generated method stub
				if (mm.getAction()==MotionEvent.ACTION_DOWN){
					float myX=mm.getX();
					float myY=mm.getY();
					Log.d("my touched point =", "x="+myX+",  Y="+myY);
				}
				return false;
			}
		});
		
		
		
//		myLevel=new Map(getApplicationContext(), 1);
//	
//		myLevel.set_map_Start_xPoints(xpoints);
//		myLevel.set_map_Start_yPoints(ypoints);
//		myLevel.set_map_railway_xPoints(Railxpoints);
//		myLevel.set_map_railway_yPoints(Railypoints);
//		String rechend=myLevel.generate_AndMove_ToFirst_Wasla();
//		if(rechend.equals("reached")){// read connection		
//		}
//		//if connection
//		myLevel.Move();
//		//if reached dist 
//		result = myLevel.ComputeResult(elspedTime, hitcount, misscount, bounusnumber);
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
