package com.gupta.customseekbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.SeekBar;

public class Utility {
	/**
	 * @param context Context
	 * @param seek SeekBar
	 * @param text Text above the thumb
	 * @param progress progress of SeekBar
	 */
	public static void writeOnDrawable(Context context, SeekBar seek,
			String text, int progress) {
		Bitmap bm = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.thumb).copy(Bitmap.Config.ARGB_8888, true);
		Paint paint = new Paint();
		paint.setStyle(Style.FILL);
		paint.setColor(Color.BLACK);
		paint.setColor(Color.parseColor("#8E8581"));
		paint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.BOLD));
		int textLeftPosition = 0;
		int textSize = context.getResources().getInteger(
				R.integer.slider_text_size_normal);
		switch (text.length()) {
		case 1:
			textLeftPosition = (bm.getWidth() / 2) - 4;
			break;
		case 2:
			textLeftPosition = (bm.getWidth() / 3) + 4;
			break;
		case 3:
			textLeftPosition = (bm.getWidth() / 3);
			break;
		case 4:
			textLeftPosition = (bm.getWidth() / 3) - 4;
			break;
		case 5:
			textLeftPosition = (bm.getWidth() / 4) - 1;
			break;
		case 6:
			textLeftPosition = (bm.getWidth() / 5);
			textSize = context.getResources().getInteger(
					R.integer.slider_text_size_high);
			break;
		case 7:
			textLeftPosition = (bm.getWidth() / 4) - 2;
			textSize = context.getResources().getInteger(
					R.integer.slider_text_size_high);
			break;
		case 8:
			textLeftPosition = (bm.getWidth() / 4) - 2;
			textSize = context.getResources().getInteger(
					R.integer.slider_text_size_medium);
			break;
		default:
			textSize = context.getResources().getInteger(
					R.integer.slider_text_size_low);
			break;
		}
		paint.setTextSize(textSize);
		Canvas canvas = new Canvas(bm);
		canvas.drawText("" + text, textLeftPosition, bm.getHeight() / 4, paint);

		double seekWidth = seek.getMeasuredWidth()
				- context.getResources().getInteger(
						R.integer.slider_unit_reduction);
		double seekMax = seek.getMax();
		double basicUnit = (seekWidth / seekMax);
		double move = basicUnit * progress;

		Drawable myThumb = new BitmapDrawable(bm);
		myThumb.setBounds(new Rect((int) move, 0, (int) (myThumb
				.getMinimumWidth() + move), myThumb.getMinimumHeight()));
		seek.setThumb(myThumb);
		seek.setProgress(progress);
	}
	

}
