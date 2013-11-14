package com.hipmob.gifanimationdrawable.sample;

import java.io.IOException;

import com.hipmob.gifanimationdrawable.GifAnimationDrawable;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class DisplayGIF extends Activity implements OnClickListener 
{
	private ImageView imageview;
	private ImageButton imagebutton;
	private GifAnimationDrawable little, big;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_gif);
		
		imageview = (ImageView)findViewById(R.id.imageview);
		imagebutton = (ImageButton)findViewById(R.id.imagebutton);
		
		imagebutton.setOnClickListener(this);
		
		// and add the GifAnimationDrawable
		try{
			android.util.Log.v("GifAnimationDrawable", "===>One");
			little = new GifAnimationDrawable(getResources().openRawResource(R.raw.anim1));
			little.setOneShot(true);
			android.util.Log.v("GifAnimationDrawable", "===>Two");
			imagebutton.setImageDrawable(little);
			android.util.Log.v("GifAnimationDrawable", "===>Three");
			big = new GifAnimationDrawable(getResources().openRawResource(R.raw.anim2));
			big.setOneShot(true);
			android.util.Log.v("GifAnimationDrawable", "===>Four");
		}catch(IOException ioe){
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_gi, menu);
		return true;
	}

	@Override
	public void onClick(View arg0)
	{
		//((GifAnimationDrawable)imagebutton.getDrawable()).setVisible(true, true);
		((GifAnimationDrawable)imagebutton.getDrawable()).setVisible(true, true);
		if(imageview.getDrawable() == null) imageview.setImageDrawable(big);
		big.setVisible(true, true);
	}
}
