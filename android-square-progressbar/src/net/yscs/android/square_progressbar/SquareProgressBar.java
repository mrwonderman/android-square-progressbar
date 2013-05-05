package net.yscs.android.square_progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class SquareProgressBar extends View {

	private final Paint backgroundPaint;

	public SquareProgressBar(Context context) {
		super(context);
		backgroundPaint = new Paint();
		backgroundPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_light));
		backgroundPaint.setAntiAlias(true);
		backgroundPaint.setStyle(Style.FILL);
		// TODO Auto-generated constructor stub
	}

	public SquareProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		backgroundPaint = new Paint();
		backgroundPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_light));
		backgroundPaint.setAntiAlias(true);
		backgroundPaint.setStyle(Style.FILL);
	}

	public SquareProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		backgroundPaint = new Paint();
		backgroundPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_light));
		backgroundPaint.setAntiAlias(true);
		backgroundPaint.setStyle(Style.FILL);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawRect(100, 100, 200, 200, backgroundPaint);
	}

}
