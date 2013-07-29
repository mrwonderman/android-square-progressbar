package net.yscs.android.square_progressbar;

import net.yscs.android.square_progressbar.utils.CalculationUtil;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * The basic {@link SquareProgressBar}. THis class includes all the methods you
 * need to modify your {@link SquareProgressBar}.
 * 
 * @author ysigner
 * @since 1.0
 */
public class SquareProgressBar extends RelativeLayout {

	private ImageView imageView;
	private final SquareProgressView bar;
	private boolean opacity;

	/**
	 * New SquareProgressBar.
	 * 
	 * @param context
	 *            the {@link Context}
	 * @param attrs
	 *            an {@link AttributeSet}
	 * @param defStyle
	 *            a defined style.
	 * @since 1.0
	 */
	public SquareProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.progressbarview, this, true);
		bar = (SquareProgressView) findViewById(R.id.squareProgressBar1);
	}

	/**
	 * New SquareProgressBar.
	 * 
	 * @param context
	 *            the {@link Context}
	 * @param attrs
	 *            an {@link AttributeSet}
	 * @since 1.0
	 */
	public SquareProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.progressbarview, this, true);
		bar = (SquareProgressView) findViewById(R.id.squareProgressBar1);
	}

	/**
	 * New SquareProgressBar.
	 * 
	 * @param context
	 * @since 1.0
	 */
	public SquareProgressBar(Context context) {
		super(context);
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.progressbarview, this, true);
		bar = (SquareProgressView) findViewById(R.id.squareProgressBar1);
	}

	/**
	 * Sets the image of the {@link SquareProgressBar}. Must be a valid
	 * ressourceId.
	 * 
	 * @param image
	 *            the image as a ressourceId
	 * @since 1.0
	 */
	public void setImage(int image) {
		imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setImageResource(image);
	}

	/**
	 * Sets the progress of the {@link SquareProgressBar}. If opacity is
	 * selected then here it sets it. See {@link #setOpacity(boolean)} for more
	 * information.
	 * 
	 * @param progress
	 *            the progress
	 * @since 1.0
	 */
	public void setProgress(double progress) {
		bar.setProgress(progress);
		if (opacity) {
			setOpacity((int) progress);
		} else {
			setOpacity(100);
		}
	}

	/**
	 * Sets the colour of the {@link SquareProgressBar} to a predefined android
	 * holo color. <br/>
	 * <b>Examples:</b>
	 * <ul>
	 * <li>holo_blue_bright</li>
	 * <li>holo_blue_dark</li>
	 * <li>holo_blue_light</li>
	 * <li>holo_green_dark</li>
	 * <li>holo_green_light</li>
	 * <li>holo_orange_dark</li>
	 * <li>holo_orange_light</li>
	 * <li>holo_purple</li>
	 * <li>holo_red_dark</li>
	 * <li>holo_red_light</li>
	 * </ul>
	 * 
	 * @param androidHoloColor
	 * @since 1.0
	 */
	public void setHoloColor(int androidHoloColor) {
		bar.setColor(getContext().getResources().getColor(androidHoloColor));
	}

	/**
	 * Sets the colour of the {@link SquareProgressBar}. YOu can give it a
	 * hex-color string like <i>#C9C9C9</i>.
	 * 
	 * @param colorString
	 *            the colour of the {@link SquareProgressBar}
	 * @since 1.1
	 */
	public void setColor(String colorString) {
		bar.setColor(Color.parseColor(colorString));
	}

	/**
	 * This sets the colour of the {@link SquareProgressBar} with a RGB colour.
	 * 
	 * @param r
	 *            red
	 * @param g
	 *            green
	 * @param b
	 *            blue¨
	 * @since 1.1
	 */
	public void setColorRGB(int r, int g, int b) {
		bar.setColor(Color.rgb(r, g, b));
	}

	/**
	 * This sets the width of the {@link SquareProgressBar}.
	 * 
	 * @param width
	 *            in Dp
	 * @since 1.1
	 */
	public void setWidth(int width) {
		int padding = CalculationUtil.convertDpToPx(width, getContext());
		imageView.setPadding(padding, padding, padding, padding);
		bar.setWidthInDp(width);
	}

	/**
	 * This sets the alpha of the image in the view. Actually I need to use the
	 * deprecated method here as the new one is only available for the API-level
	 * 16. And the min API level o this library is 14.
	 * 
	 * Use this only as private method.
	 * 
	 * @param progress
	 *            the progress
	 */
	private void setOpacity(int progress) {
		imageView.setAlpha((int) (2.55 * progress));
	}

	/**
	 * Switches the opacity state of the image. This forces the
	 * SquareProgressBar to redraw with the current progress. As bigger the
	 * progress is, then more of the image comes to view. If the progress is 0,
	 * then you can't see the image at all. If the progress is 100, the image is
	 * shown full.
	 * 
	 * @param opacity
	 *            true if opacity should be enabled.
	 */
	public void setOpacity(boolean opacity) {
		this.opacity = opacity;
		setProgress(bar.getProgress());
	}
}
