package net.yscs.android.square_progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class SquareProgressView extends View {

	private int progress;
	private final Paint progressBarPaint;

	private static final float GRAPH_STROKE_WIDTH = 20;

	public SquareProgressView(Context context) {
		super(context);

		progressBarPaint = new Paint();
		progressBarPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_dark));
		progressBarPaint.setStrokeWidth(convertDpToPx(GRAPH_STROKE_WIDTH));
		progressBarPaint.setAntiAlias(true);
		progressBarPaint.setStyle(Style.STROKE);
	}

	public SquareProgressView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		progressBarPaint = new Paint();
		progressBarPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_dark));
		progressBarPaint.setStrokeWidth(convertDpToPx(GRAPH_STROKE_WIDTH));
		progressBarPaint.setAntiAlias(true);
		progressBarPaint.setStyle(Style.STROKE);
	}

	public SquareProgressView(Context context, AttributeSet attrs) {
		super(context, attrs);

		progressBarPaint = new Paint();
		progressBarPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_dark));
		progressBarPaint.setStrokeWidth(convertDpToPx(GRAPH_STROKE_WIDTH));
		progressBarPaint.setAntiAlias(true);
		progressBarPaint.setStyle(Style.STROKE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// int scope = canvas.getWidth() + canvas.getHeight() +
		// canvas.getHeight()
		// + canvas.getWidth();
		// float d = scope * (progress / 100);
		//
		// System.out.println(d);
		//
		// Path path = new Path();
		// path.moveTo(canvas.getWidth() / 2, (canvas.getWidth() / 2) + d);
		// canvas.drawPath(path, progressBarPaint);

		// complete path (100%)
		Path path = new Path();
		path.moveTo(canvas.getWidth() / 2, 0);
		path.lineTo(canvas.getWidth(), 0);
		path.lineTo(canvas.getWidth(), canvas.getHeight());
		path.lineTo(0, canvas.getHeight());
		path.lineTo(0, 0);
		path.lineTo(canvas.getWidth() / 2, 0);
		canvas.drawPath(path, progressBarPaint);
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
		this.invalidate();
	}

	private int convertDpToPx(float dp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
				getContext().getResources().getDisplayMetrics());
	}

}
