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

	private float borderInDP = 10;

	public SquareProgressView(Context context) {
		super(context);
		progressBarPaint = new Paint();
		progressBarPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_dark));
		progressBarPaint.setStrokeWidth(convertDpToPx(borderInDP));
		progressBarPaint.setAntiAlias(true);
		progressBarPaint.setStyle(Style.STROKE);
	}

	public SquareProgressView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		progressBarPaint = new Paint();
		progressBarPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_dark));
		progressBarPaint.setStrokeWidth(convertDpToPx(borderInDP));
		progressBarPaint.setAntiAlias(true);
		progressBarPaint.setStyle(Style.STROKE);
	}

	public SquareProgressView(Context context, AttributeSet attrs) {
		super(context, attrs);
		progressBarPaint = new Paint();
		progressBarPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_dark));
		progressBarPaint.setStrokeWidth(convertDpToPx(borderInDP));
		progressBarPaint.setAntiAlias(true);
		progressBarPaint.setStyle(Style.STROKE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		float scope = canvas.getWidth() + canvas.getHeight()
				+ canvas.getHeight() + canvas.getWidth();
		float percent = (scope / 100) * progress;
		float halfOfTheImage = canvas.getWidth() / 2;

		if (percent > halfOfTheImage) {
			paintFirstHalfOfTheTop(canvas);
			float second = percent - halfOfTheImage;

			if (second > canvas.getHeight()) {
				paintRightSide(canvas);
				float third = second - canvas.getHeight();

				if (third > canvas.getWidth()) {
					paintBottomSide(canvas);
					float forth = third - canvas.getWidth();

					if (forth > canvas.getHeight()) {
						paintLeftSide(canvas);
						float fifth = forth - canvas.getHeight();

						if (fifth == halfOfTheImage) {
							paintSecondHalfOfTheTop(canvas);
						} else {
							Path path = new Path();
							path.moveTo(convertDpToPx(5), convertDpToPx(10));
							if (fifth > 10) {
								path.lineTo(fifth, convertDpToPx(10));
							} else {
								path.lineTo(30, convertDpToPx(10));
							}
							canvas.drawPath(path, progressBarPaint);
						}
					} else {
						Path path = new Path();
						path.moveTo(convertDpToPx(10), canvas.getHeight()
								- convertDpToPx(5));
						if (forth > 20) {
							path.lineTo(convertDpToPx(10), canvas.getHeight()
									- forth);
						} else {
							path.lineTo(convertDpToPx(10),
									canvas.getHeight() - 40);

						}
						canvas.drawPath(path, progressBarPaint);
					}

				} else {
					Path path = new Path();
					path.moveTo(canvas.getWidth() - convertDpToPx(10),
							canvas.getHeight() - convertDpToPx(10));
					path.lineTo(canvas.getWidth() - third, canvas.getHeight()
							- convertDpToPx(10));
					canvas.drawPath(path, progressBarPaint);
				}
			} else {
				Path path = new Path();
				path.moveTo(canvas.getWidth() - convertDpToPx(10),
						convertDpToPx(10));
				path.lineTo(canvas.getWidth() - convertDpToPx(10), second);
				canvas.drawPath(path, progressBarPaint);
			}

		} else {
			Path path = new Path();
			path.moveTo(halfOfTheImage, convertDpToPx(10));
			path.lineTo(halfOfTheImage + percent, convertDpToPx(10));
			canvas.drawPath(path, progressBarPaint);
		}
	}

	public void paintFirstHalfOfTheTop(Canvas canvas) {
		Path path = new Path();
		path.moveTo(canvas.getWidth() / 2, convertDpToPx(10));
		path.lineTo(canvas.getWidth() - convertDpToPx(5), convertDpToPx(10));
		canvas.drawPath(path, progressBarPaint);
	}

	public void paintRightSide(Canvas canvas) {
		Path path = new Path();
		path.moveTo(canvas.getWidth() - convertDpToPx(10), convertDpToPx(10));
		path.lineTo(canvas.getWidth() - convertDpToPx(10), canvas.getHeight()
				- convertDpToPx(5));
		canvas.drawPath(path, progressBarPaint);
	}

	public void paintBottomSide(Canvas canvas) {
		Path path = new Path();
		path.moveTo(canvas.getWidth() - convertDpToPx(10), canvas.getHeight()
				- convertDpToPx(10));
		path.lineTo(convertDpToPx(10), canvas.getHeight() - convertDpToPx(10));
		canvas.drawPath(path, progressBarPaint);
	}

	public void paintLeftSide(Canvas canvas) {
		Path path = new Path();
		path.moveTo(convertDpToPx(10), canvas.getHeight() - convertDpToPx(5));
		path.lineTo(convertDpToPx(10), convertDpToPx(10));
		canvas.drawPath(path, progressBarPaint);
	}

	public void paintSecondHalfOfTheTop(Canvas canvas) {
		Path path = new Path();
		path.moveTo(convertDpToPx(5), convertDpToPx(10));
		path.lineTo(canvas.getWidth() / 2, convertDpToPx(10));
		canvas.drawPath(path, progressBarPaint);
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
		this.invalidate();
	}

	/**
	 * Just copied this method from sirius ;D. Thanks for that =).
	 * 
	 * @param dp
	 *            the dp to convert
	 * @return the amount of pixels as an integer
	 */
	private int convertDpToPx(float dp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
				getContext().getResources().getDisplayMetrics());
	}

	public void setColor(int androidHoloColor) {
		progressBarPaint.setColor(androidHoloColor);
	}

	/**
	 * @return the border
	 */
	public float getBorderInDp() {
		return borderInDP;
	}

	/**
	 * @return the border
	 */
	public void setBorderInDp(int border) {
		this.borderInDP = border;
		this.invalidate();
	}

	public float getRemainingBorder() {
		return convertDpToPx(20) - convertDpToPx(getBorderInDp());
	}
}
