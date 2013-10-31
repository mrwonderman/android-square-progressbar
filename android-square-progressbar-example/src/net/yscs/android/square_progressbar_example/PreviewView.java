package net.yscs.android.square_progressbar_example;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class PreviewView extends View {

	private final Paint paintPaint;
	private Align center = Align.CENTER;
	private float size = 150;
	private boolean b = true;

	public PreviewView(Context context) {
		super(context);

		paintPaint = new Paint();
		paintPaint.setColor(context.getResources().getColor(
				android.R.color.black));
		paintPaint.setAntiAlias(true);
		paintPaint.setStyle(Style.STROKE);
	}

	public PreviewView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		paintPaint = new Paint();
		paintPaint.setColor(context.getResources().getColor(
				android.R.color.black));
		paintPaint.setAntiAlias(true);
		paintPaint.setStyle(Style.STROKE);
	}

	public PreviewView(Context context, AttributeSet attrs) {
		super(context, attrs);

		paintPaint = new Paint();
		paintPaint.setColor(context.getResources().getColor(
				android.R.color.black));
		paintPaint.setAntiAlias(true);
		paintPaint.setStyle(Style.STROKE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Path path = new Path();
		path.moveTo(0, 0);
		path.lineTo(0, canvas.getWidth());
		path.lineTo(canvas.getHeight(), canvas.getWidth());
		path.lineTo(canvas.getHeight(), 0);
		path.lineTo(0, 0);
		canvas.drawPath(path, paintPaint);
		paintPaint.setTextAlign(center);
		paintPaint.setTextSize(Float.valueOf(String.valueOf(size)));
		canvas.drawText(b ? "32%" : "32", canvas.getWidth() / 2, (int) ((canvas
				.getHeight() / 2) - ((paintPaint.descent() + paintPaint
				.ascent()) / 2)), paintPaint);
	}

	public void drawText(int size, Align center, boolean b) {
		this.size = size;
		this.center = center;
		this.b = b;
		this.invalidate();
	}

}
