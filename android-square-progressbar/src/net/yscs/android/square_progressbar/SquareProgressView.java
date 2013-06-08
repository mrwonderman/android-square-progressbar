package net.yscs.android.square_progressbar;

import net.yscs.android.square_progressbar.utils.CalculationUtil;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class SquareProgressView extends View {

	private double progress;
	private final Paint progressBarPaint;

	private float widthInDp = 0;
	private float strokewidth = 0;

	public SquareProgressView(Context context) {
		super(context);
		progressBarPaint = new Paint();
		progressBarPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_dark));
		progressBarPaint.setStrokeWidth(CalculationUtil.convertDpToPx(
				widthInDp, getContext()));
		progressBarPaint.setAntiAlias(true);
		progressBarPaint.setStyle(Style.STROKE);
	}

	public SquareProgressView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		progressBarPaint = new Paint();
		progressBarPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_dark));
		progressBarPaint.setStrokeWidth(CalculationUtil.convertDpToPx(
				widthInDp, getContext()));
		progressBarPaint.setAntiAlias(true);
		progressBarPaint.setStyle(Style.STROKE);
	}

	public SquareProgressView(Context context, AttributeSet attrs) {
		super(context, attrs);
		progressBarPaint = new Paint();
		progressBarPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_dark));
		progressBarPaint.setStrokeWidth(CalculationUtil.convertDpToPx(
				widthInDp, getContext()));
		progressBarPaint.setAntiAlias(true);
		progressBarPaint.setStyle(Style.STROKE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		strokewidth = CalculationUtil.convertDpToPx(widthInDp, getContext());
		float scope = canvas.getWidth() + canvas.getHeight()
				+ canvas.getHeight() + canvas.getWidth();
		float percent = (scope / 100) * Float.valueOf(String.valueOf(progress));
		float halfOfTheImage = canvas.getWidth() / 2;
		Path path = new Path();
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
							path.moveTo(strokewidth, (strokewidth / 2));
							path.lineTo(strokewidth + fifth, (strokewidth / 2));
							canvas.drawPath(path, progressBarPaint);
						}
					} else {
						path.moveTo((strokewidth / 2), canvas.getHeight()
								- strokewidth);
						path.lineTo((strokewidth / 2), canvas.getHeight()
								- forth);
						canvas.drawPath(path, progressBarPaint);
					}

				} else {
					path.moveTo(canvas.getWidth() - strokewidth,
							canvas.getHeight() - (strokewidth / 2));
					path.lineTo(canvas.getWidth() - third, canvas.getHeight()
							- (strokewidth / 2));
					canvas.drawPath(path, progressBarPaint);
				}
			} else {
				path.moveTo(canvas.getWidth() - (strokewidth / 2), strokewidth);
				path.lineTo(canvas.getWidth() - (strokewidth / 2), strokewidth
						+ second);
				canvas.drawPath(path, progressBarPaint);
			}

		} else {
			path.moveTo(halfOfTheImage, strokewidth / 2);
			path.lineTo(halfOfTheImage + percent, strokewidth / 2);
			canvas.drawPath(path, progressBarPaint);
		}
	}

	public void paintFirstHalfOfTheTop(Canvas canvas) {
		Path path = new Path();
		path.moveTo(canvas.getWidth() / 2, strokewidth / 2);
		path.lineTo(canvas.getWidth() + strokewidth, strokewidth / 2);
		canvas.drawPath(path, progressBarPaint);
	}

	public void paintRightSide(Canvas canvas) {
		Path path = new Path();
		path.moveTo(canvas.getWidth() - (strokewidth / 2), strokewidth);
		path.lineTo(canvas.getWidth() - (strokewidth / 2), canvas.getHeight());
		canvas.drawPath(path, progressBarPaint);
	}

	public void paintBottomSide(Canvas canvas) {
		Path path = new Path();
		path.moveTo(canvas.getWidth() - strokewidth, canvas.getHeight()
				- (strokewidth / 2));
		path.lineTo(0, canvas.getHeight() - (strokewidth / 2));
		canvas.drawPath(path, progressBarPaint);
	}

	public void paintLeftSide(Canvas canvas) {
		Path path = new Path();
		path.moveTo((strokewidth / 2), canvas.getHeight() - strokewidth);
		path.lineTo((strokewidth / 2), 0);
		canvas.drawPath(path, progressBarPaint);
	}

	public void paintSecondHalfOfTheTop(Canvas canvas) {
		Path path = new Path();
		path.moveTo(strokewidth, (strokewidth / 2));
		path.lineTo(canvas.getWidth() / 2, (strokewidth / 2));
		canvas.drawPath(path, progressBarPaint);
	}

	public double getProgress() {
		return progress;
	}

	public void setProgress(double progress) {
		this.progress = progress;
		this.invalidate();
	}

	public void setColor(int color) {
		progressBarPaint.setColor(color);
		this.invalidate();
	}

	/**
	 * @return the border
	 */
	public float getWidthInDp() {
		return widthInDp;
	}

	/**
	 * @return the border
	 */
	public void setWidthInDp(int width) {
		this.widthInDp = width;
		progressBarPaint.setStrokeWidth(CalculationUtil.convertDpToPx(
				widthInDp, getContext()));
		this.invalidate();
	}

}
