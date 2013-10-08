package com.gupta.customseekbar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	public static String TAG = "MainActivity";
	private String answerValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seekbar);

		SeekBar seekBar = (SeekBar) findViewById(R.id.seek_bar);
		TextView leftMarker = (TextView) findViewById(R.id.left_marker);
		TextView rightMarker = (TextView) findViewById(R.id.right_marker);

		leftMarker.setText("Min");
		rightMarker.setText("Max");
		seekBar.setMax(10);
		int initProgress = (5);
		Utility.writeOnDrawable(this, seekBar, initProgress + "", initProgress);

		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromTouch) {
				Utility.writeOnDrawable(MainActivity.this, seekBar,
						String.valueOf(progress), progress);
				answerValue = (progress) + "";
				Log.d(TAG, answerValue);
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
