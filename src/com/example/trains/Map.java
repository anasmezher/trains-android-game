package com.example.trains;


import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Map {
	Context mapContext;
	String reached = "NO";
	int color;
	int maxx,maxy;
	ImageView iv;
	ArrayList<Integer> railWayXpoints, railWayYpoints, waslatXpoint, waslatYpoint, trains, distinationsXpoints,
			distinationsYpoints, startX, startY;
	int nextpointX, nextpointY;
	int level;
	int numberoftrains;

	public Map(Context context, int level, int numboftr) {
		this.mapContext = context;
		this.level = level;
		this.numberoftrains = numboftr;
	}

	public void set_map_dest_xPoints(ArrayList<Integer> xpoints) {
		this.distinationsXpoints = xpoints;
	}

	public void set_map_dest_yPoints(ArrayList<Integer> ypoints) {
		this.distinationsYpoints = ypoints;
	}

	public void setNextPoint(int x, int y) {
		this.nextpointX = x;
		this.nextpointY = y;
	}

	public void generate_AndMove(RelativeLayout rl, float xx, float yy, float endxx, float endyy, int speed) {
        float x,y,endx,endy;
        
        maxy= rl.getWidth();
        maxx=rl.getHeight();
        x=(xx*maxx)/100;
        y=(yy*maxy)/100;
        endx=(endxx*maxx)/100;
        endy=(endyy*maxy)/100;
		final Random rgenerator = new Random();
		int q = rgenerator.nextInt(numberoftrains);
		color = q;
		iv = new ImageView(mapContext);
		if (q == 0) {
			iv.setBackgroundResource(R.drawable.red);
		}
		if (q == 1) {
			iv.setBackgroundResource(R.drawable.green);
		}
		if (q == 2) {
			iv.setBackgroundResource(R.drawable.blue);
		}
		if (q == 3) {
			iv.setBackgroundResource(R.drawable.yellow);
		}
		if (q == 4) {
			iv.setBackgroundResource(R.drawable.happy);
		}
		if (q == 5) {
			iv.setBackgroundResource(R.drawable.angry);
		}
		LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		iv.setLayoutParams(lp);
		rl.addView(iv);
		// move to next point.............................................
		iv.animate().translationX(x).translationY(y).setDuration(0).start();
		iv.animate().translationX(endx).translationY(endy).setDuration(speed).start();
		if (iv.getX() == endx && iv.getY() == endy) {
			reached = "yes";
		}

	}

	public void dellete_Train() {
		iv.setVisibility(View.GONE);
		iv.destroyDrawingCache();

	}

	public String get_train_Color() {
		String Tcolor = "red";
		if (color == 0) {
			Tcolor = "red";
		} else if (color == 1) {
			Tcolor = "green";
		} else if (color == 2) {
			Tcolor = "blue";
		} else if (color == 3) {
			Tcolor = "yellow";
		} else if (color == 4) {
			Tcolor = "happy";
		} else if (color == 5) {
			Tcolor = "angry";
		}
		return Tcolor;

	}

	public void Move(float nextpX, float nextpY, long speed) {
		float x,y;
	        x=(nextpX*maxx)/100;
	        y=(nextpY*maxy)/100;
		iv.animate().translationX(x).translationY(y).setDuration(speed).start();
	}

}
