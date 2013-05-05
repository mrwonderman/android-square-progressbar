package net.yscs.android.square_progressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class SquareProgressView extends View {

	private final Paint backgroundPaint;
	private int progress;

	public SquareProgressView(Context context) {
		super(context);
		backgroundPaint = new Paint();
		backgroundPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_light));
		backgroundPaint.setAntiAlias(true);
		backgroundPaint.setStyle(Style.FILL);
	}

	public SquareProgressView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		backgroundPaint = new Paint();
		backgroundPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_light));
		backgroundPaint.setAntiAlias(true);
		backgroundPaint.setStyle(Style.FILL);
	}

	public SquareProgressView(Context context, AttributeSet attrs) {
		super(context, attrs);
		backgroundPaint = new Paint();
		backgroundPaint.setColor(context.getResources().getColor(
				android.R.color.holo_green_light));
		backgroundPaint.setAntiAlias(true);
		backgroundPaint.setStyle(Style.FILL);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// if (progress <= 10) {
		// int scope = canvas.getWidth() + canvas.getHeight();
		// int i = (scope / 50) * progress;
		// canvas.drawRect(canvas.getWidth() / 2, 0, (canvas.getWidth() / 2)
		// + i, convertDpToPixel(10, getContext()), backgroundPaint);
		// }

		switch (progress) {
		case 25:
			canvas.drawRect(canvas.getWidth() / 2, 0, canvas.getWidth(),
					canvas.getHeight() / 2, backgroundPaint);
			break;
		case 50:
			canvas.drawRect(canvas.getWidth() / 2, 0, canvas.getWidth(),
					canvas.getHeight(), backgroundPaint);
			break;
		case 75:
			canvas.drawRect(canvas.getWidth() / 2, 0, canvas.getWidth(),
					canvas.getHeight() / 2, backgroundPaint);
			canvas.drawRect(0, canvas.getHeight() / 2, canvas.getWidth(),
					canvas.getHeight(), backgroundPaint);
			break;
		case 100:
			canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(),
					backgroundPaint);
			break;
		default:
			break;
		}
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
		this.invalidate();
	}

	/**
	 * This method converts dp unit to equivalent pixels, depending on device
	 * density.
	 * 
	 * @param dp
	 *            A value in dp (density independent pixels) unit. Which we need
	 *            to convert into pixels
	 * @param context
	 *            Context to get resources and device specific display metrics
	 * @return A float value to represent px equivalent to dp depending on
	 *         device density
	 */
	public static float convertDpToPixel(float dp, Context context) {
		Resources resources = context.getResources();
		DisplayMetrics metrics = resources.getDisplayMetrics();
		float px = dp * (metrics.densityDpi / 160f);
		return px;
	}

	/**
	 * This method converts device specific pixels to density independent
	 * pixels.
	 * 
	 * @param px
	 *            A value in px (pixels) unit. Which we need to convert into db
	 * @param context
	 *            Context to get resources and device specific display metrics
	 * @return A float value to represent dp equivalent to px value
	 */
	public static float convertPixelsToDp(float px, Context context) {
		Resources resources = context.getResources();
		DisplayMetrics metrics = resources.getDisplayMetrics();
		float dp = px / (metrics.densityDpi / 160f);
		return dp;
	}

}
