package ch.halcyon.squareprogressbar;

import ch.halcyon.squareprogressbar.utils.CalculationUtil;
import ch.halcyon.squareprogressbar.utils.PercentStyle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

/**
 * The basic {@link SquareProgressBar}. This class includes all the methods you
 * need to modify your {@link SquareProgressBar}.
 * 
 * @author ysigner
 * @since 1.0.0
 */
public class SquareProgressBar extends RelativeLayout {

	private ImageView imageView;
	private final SquareProgressView bar;
	private boolean opacity = false;
	private boolean greyscale;
	private boolean isFadingOnProgress = false;

	/**
	 * New SquareProgressBar.
	 * 
	 * @param context
	 *            the {@link Context}
	 * @param attrs
	 *            an {@link AttributeSet}
	 * @param defStyle
	 *            a defined style.
	 * @since 1.0.0
	 */
	public SquareProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.progressbarview, this, true);
		bar = (SquareProgressView) findViewById(R.id.squareProgressBar1);
        imageView = (ImageView) findViewById(R.id.imageView1);
		bar.bringToFront();
	}

	/**
	 * New SquareProgressBar.
	 * 
	 * @param context
	 *            the {@link Context}
	 * @param attrs
	 *            an {@link AttributeSet}
	 * @since 1.0.0
	 */
	public SquareProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.progressbarview, this, true);
		bar = (SquareProgressView) findViewById(R.id.squareProgressBar1);
        imageView = (ImageView) findViewById(R.id.imageView1);
		bar.bringToFront();
	}

	/**
	 * New SquareProgressBar.
	 * 
	 * @param context the context
	 * @since 1.0.0
	 */
	public SquareProgressBar(Context context) {
		super(context);
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.progressbarview, this, true);
		bar = (SquareProgressView) findViewById(R.id.squareProgressBar1);
        imageView = (ImageView) findViewById(R.id.imageView1);
		bar.bringToFront();
	}

    /**
     * Sets the image of the {@link SquareProgressBar}. Must be a valid
     * ressourceId.
     *
     * @param image the image as a ressourceId
     * @since 1.0
     */
    public void setImageResource(int image) {
        imageView.setImageResource(image);

    }

    /**
     * Sets the image of the {@link SquareProgressBar}. Must be a valid
     * Drawable.
     *
     * @param image the image as a Drawable
     * @since 1.0
     */
    public void setImage(Drawable image) {
        imageView.setImageDrawable(image);

    }

    /**
     * Sets the image of the {@link SquareProgressBar}. Must be a valid
     * Drawable.
     *
     * @param imageDrawable the image as a Drawable
     * @since 1.6.1
     * @author erikswed
     */
    public void setImageDrawable(Drawable imageDrawable) {
        imageView.setImageDrawable(imageDrawable);
    }


	/**
	 * Sets the image scale type according to {@link ScaleType}.
	 * 
	 * @param scale
	 *            the image ScaleType
	 * @since 1.3.0
	 * @author thiagokimo
	 */
	public void setImageScaleType(ScaleType scale) {
		imageView.setScaleType(scale);
	}

	/**
	 * Sets the progress of the {@link SquareProgressBar}. If opacity is
	 * selected then here it sets it. See {@link #setOpacity(boolean)} for more
	 * information.
	 * 
	 * @param progress
	 *            the progress
	 * @since 1.0.0
	 */
	public void setProgress(double progress) {
		bar.setProgress(progress);
		if (opacity) {
			if (isFadingOnProgress) {
				setOpacity(100 - (int) progress);
			} else {
				setOpacity((int) progress);
			}
		} else {
			setOpacity(100);
		}
	}

	/**
	 * Sets the colour of the {@link SquareProgressBar} to a predefined android
	 * holo color.
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
	 * @param androidHoloColor holo color value
	 * @since 1.0.0
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
	 * @since 1.1.0
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
	 *            blue
	 * @since 1.1.0
	 */
	public void setColorRGB(int r, int g, int b) {
		bar.setColor(Color.rgb(r, g, b));
	}

	/**
	 * This sets the colour of the {@link SquareProgressBar} with a RGB colour.
	 * Works when used with
	 * <code>android.graphics.Color.rgb(int)</code>
	 * 
	 * @param rgb the rgb color
	 * @since 1.4.0
	 */
	public void setColorRGB(int rgb) {
		bar.setColor(rgb);
	}

	/**
	 * This sets the width of the {@link SquareProgressBar}.
	 * 
	 * @param width
	 *            in Dp
	 * @since 1.1.0
	 */
	public void setWidth(int width) {
		int padding = CalculationUtil.convertDpToPx(width, getContext());
		imageView.setPadding(padding, padding, padding, padding);
		bar.setWidthInDp(width);
	}

	/**
	 * This sets the alpha of the image in the view. Actually I need to use the
	 * deprecated method here as the new one is only available for the API-level
	 * 16. And the min API level of this library is 14.
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
	 * @since 1.2.0
	 */
	public void setOpacity(boolean opacity) {
		this.opacity = opacity;
		setProgress(bar.getProgress());
	}

	/**
	 * Switches the opacity state of the image. This forces the
	 * SquareProgressBar to redraw with the current progress. As bigger the
	 * progress is, then more of the image comes to view. If the progress is 0,
	 * then you can't see the image at all. If the progress is 100, the image is
	 * shown full.
	 * 
	 * You can also set the flag if the fading should get inverted so the image
	 * disappears when the progress increases.
	 * 
	 * @param opacity
	 *            true if opacity should be enabled.
	 * @param isFadingOnProgress
	 *            default false. This changes the behavior the opacity works. If
	 *            the progress increases then the images fades. When the
	 *            progress reaches 100, then the image disappears.
	 * @since 1.4.0
	 */
	public void setOpacity(boolean opacity, boolean isFadingOnProgress) {
		this.opacity = opacity;
		this.isFadingOnProgress = isFadingOnProgress;
		setProgress(bar.getProgress());
	}

	/**
	 * You can set the image to b/w with this method. Works fine with the
	 * opacity.
	 * 
	 * @param greyscale
	 *            true if the grayscale should be activated.
	 * @since 1.2.0
	 */
	public void setImageGrayscale(boolean greyscale) {
		this.greyscale = greyscale;
		if (greyscale) {
			ColorMatrix matrix = new ColorMatrix();
			matrix.setSaturation(0);
			imageView.setColorFilter(new ColorMatrixColorFilter(matrix));
		} else {
			imageView.setColorFilter(null);
		}
	}

	/**
	 * If opacity is enabled.
	 * 
	 * @return true if opacity is enabled.
	 */
	public boolean isOpacity() {
		return opacity;
	}

	/**
	 * If greyscale is enabled.
	 * 
	 * @return true if greyscale is enabled.
	 */
	public boolean isGreyscale() {
		return greyscale;
	}

	/**
	 * Draws an outline of the progressbar. Looks quite cool in some situations.
	 * 
	 * @param drawOutline
	 *            true if it should or not.
	 * @since 1.3.0
	 */
	public void drawOutline(boolean drawOutline) {
		bar.setOutline(drawOutline);
	}

	/**
	 * If outline is enabled or not.
	 * 
	 * @return true if outline is enabled.
	 */
	public boolean isOutline() {
		return bar.isOutline();
	}

	/**
	 * Draws the startline. this is the line where the progressbar starts the
	 * drawing around the image.
	 * 
	 * @param drawStartline
	 *            true if it should or not.
	 * @since 1.3.0
	 */
	public void drawStartline(boolean drawStartline) {
		bar.setStartline(drawStartline);
	}

	/**
	 * If the startline is enabled.
	 * 
	 * @return true if startline is enabled or not.
	 */
	public boolean isStartline() {
		return bar.isStartline();
	}

	/**
	 * Defines if the percent text should be shown or not. To modify the text
	 * checkout {@link #setPercentStyle(ch.halcyon.squareprogressbar.utils.PercentStyle)}.
	 * 
	 * @param showProgress
	 *            true if it should or not.
	 * @since 1.3.0
	 */
	public void showProgress(boolean showProgress) {
		bar.setShowProgress(showProgress);
	}

	/**
	 * If the progress text inside of the image is enabled.
	 * 
	 * @return true if it is or not.
	 */
	public boolean isShowProgress() {
		return bar.isShowProgress();
	}

	/**
	 * Sets a custom percent style to the text inside the image. Make sure you
	 * set {@link #showProgress(boolean)} to true. Otherwise it doesn't shows.
	 * The default settings are:
	 * Text align: CENTER
	 * Text size: 150 [dp]
	 * Display percentsign: true
	 * Custom text: %
	 * 
	 * @param percentStyle the percent style
	 */
	public void setPercentStyle(PercentStyle percentStyle) {
		bar.setPercentStyle(percentStyle);
	}

	/**
	 * Returns the {@link PercentStyle} of the percent text. Maybe returns the
	 * default value, check {@link #setPercentStyle(PercentStyle)} fo that.
	 * 
	 * @return the percent style of the moment.
	 */
	public PercentStyle getPercentStyle() {
		return bar.getPercentStyle();
	}

	/**
	 * If the progress hits 100% then the progressbar disappears if this flag is
	 * set to <code>true</code>. The default is set to false.
	 * 
	 * @param clearOnHundred
	 *            if it should disappear or not.
	 * @since 1.4.0
	 */
	public void setClearOnHundred(boolean clearOnHundred) {
		bar.setClearOnHundred(clearOnHundred);
	}
	
	/**
	 * If the progressbar disappears when the progress reaches 100%.
	 * 
	 * @since 1.4.0
	 *
	 * @return if "clearOnHundred" is enabled or not
	 */
	public boolean isClearOnHundred() {
		return bar.isClearOnHundred();
	}


    /**
     * Set an image resource directly to the ImageView.
     *
     * @param bitmap the {@link android.graphics.Bitmap} to set.
     */
    public void setImageBitmap(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }

    /**
     * Set the status of the indeterminate mode. The default is false. You can
     * still configure colour, width and so on.
     *
     * @param indeterminate true to enable the indeterminate mode (default true)
     * @since 1.6.0
     */
    public void setIndeterminate(boolean indeterminate) {
        bar.setIndeterminate(indeterminate);
    }

    /**
     * Returns the status of the indeterminate mode. The default status is false.
     *
     * @since 1.6.0
	 *
	 * @return if "indeterminate" is enabled or not
     */
    public boolean isIndeterminate() {
        return bar.isIndeterminate();
    }

    /**
     * Draws a line in the center of the way the progressbar has to go.
     *
     * @param drawCenterline
     *            true if it should or not.
     * @since 1.6.0
     */
    public void drawCenterline(boolean drawCenterline) {
        bar.setCenterline(drawCenterline);
    }

    /**
     * If the centerline is enabled or not.
     *
     * @return true if centerline is enabled.
     * @since 1.6.0
     */
    public boolean isCenterline() {
        return bar.isCenterline();
    }

	/**
	 * Returns the {@link ImageView} that the progress gets drawn around.
     *
     * @return the main ImageView
	 * @since 1.6.0
	 */
	public ImageView getImageView(){
		return imageView;
	}

}
