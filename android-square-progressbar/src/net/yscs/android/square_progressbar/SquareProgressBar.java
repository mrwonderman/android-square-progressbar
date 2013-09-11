package net.yscs.android.square_progressbar;

import java.net.URI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * The basic {@link SquareProgressBar}. This class includes all the methods you
 * need to modify your {@link SquareProgressBar}.
 * 
 * @author ysigner
 * @since 1.0
 */
public class SquareProgressBar extends ViewGroup {

    private ImageView mImage;
    private boolean mOpacity;
    private boolean mGreyscale;
    private int mCurWidth;
    private int mCurProgress;
    private int mMaxProgress;
    private BarRender mRender;
    private int mCurColor;
    private boolean mClearAtEnd = false;

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
        init(context);
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
        init(context);
    }

    /**
     * New SquareProgressBar.
     * 
     * @param context
     * @since 1.0
     */
    public SquareProgressBar(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        mImage = new ImageView(context);
        addView(mImage);
        setWillNotDraw(false);
        mCurColor = Color.BLUE;
        mRender = new BarRender(mCurColor);
        mMaxProgress = 100;
        mRender.setWidth(0);
        setMaximumProgress(mMaxProgress);
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
        mImage.setImageResource(image);
    }

    /**
     * Sets the {@link URI} as the image of the {@link SquareProgressBar}.
     * 
     * @param image
     *            the image as a ressourceId
     * @since 2.0
     */
    public void setImage(Uri imageUri) {
        mImage.setImageURI(imageUri);
    }

    /**
     * Sets the {@link Bitmap} of the {@link SquareProgressBar}. Must be a valid
     * ressourceId.
     * 
     * @param image
     *            the image as a ressourceId
     * @since 2.0
     */
    public void setImage(Bitmap image) {
        mImage.setImageBitmap(image);
    }

    /**
     * Sets the {@link Drawable} of the {@link SquareProgressBar}. Must be a
     * valid ressourceId.
     * 
     * @param image
     *            the image as a ressourceId
     * @since 2.0
     */
    public void setImage(Drawable image) {
        mImage.setImageDrawable(image);
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
    public void setProgress(int progress) {
        mCurProgress = progress;
        mRender.setProgress(progress);
        invalidate();
    }

    public void setMaximumProgress(int maximumProgress) {
        mMaxProgress = maximumProgress;
        mRender.setMaxProgress(mMaxProgress);
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
        mCurColor = getContext().getResources().getColor(androidHoloColor);
        mRender.changeColor(mCurColor);
        invalidate();
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
        mCurColor = Color.parseColor(colorString);
        mRender.changeColor(mCurColor);
        invalidate();
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
        mCurColor = Color.rgb(r, g, b);
        mRender.changeColor(mCurColor);
        invalidate();
    }

    /**
     * This sets the width of the {@link SquareProgressBar}.
     * 
     * @param width
     *            in Dp
     * @since 1.1
     */
    public void setWidth(int newWidth) {
        mCurWidth = newWidth;
        mRender.setWidth(newWidth);
        requestLayout();
        invalidate();
    }

    /**
     * You can set the image to b/w with this method. Works fine with the
     * opacity.
     * 
     * @param greyscale
     *            true if the grayscale should be activated.
     */
    public void setImageGrayscale(boolean greyscale) {
        this.mGreyscale = greyscale;
        if (greyscale) {
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(0);
            mImage.setColorFilter(new ColorMatrixColorFilter(matrix));
        } else {
            mImage.setColorFilter(null);
        }
    }

    public void clearProgressAtEnd(boolean clear) {
        mClearAtEnd = clear;
        mRender.setToClear(mClearAtEnd);
    }

    public boolean isClearingAtEnd() {
        return mClearAtEnd;
    }

    public boolean isOpacitySet() {
        return mOpacity;
    }

    public boolean isGreyscaleSet() {
        return mGreyscale;
    }

    public int getProgress() {
        return mCurProgress;
    }

    public int getMaxProgress() {
        return mMaxProgress;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mImage.layout(mCurWidth, mCurWidth, getMeasuredWidth() - mCurWidth,
                getMeasuredHeight() - mCurWidth);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        // first measure the ImageView with the current values(without the
        // current mWidthSize) and see how bit it wants to be
        mImage.measure(MeasureSpec.makeMeasureSpec(widthSize - 2 * mCurWidth,
                widthMode), MeasureSpec.makeMeasureSpec(heightSize - 2
                * mCurWidth, heightMode));
        widthSize = Math.min(widthSize, mImage.getMeasuredWidth() + 2
                * mCurWidth);
        heightSize = Math.min(heightSize, mImage.getMeasuredHeight() + 2
                * mCurWidth);
        setMeasuredDimension(widthSize, heightSize);
        mRender.setupValues(getMeasuredWidth(), getMeasuredHeight(), mCurWidth,
                mMaxProgress);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRender.draw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRender.setupValues(getMeasuredWidth(), getMeasuredHeight(), mCurWidth,
                mMaxProgress);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        // TODO to implement!!!
    }

    @Override
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        // TODO to implement!!!
    }

}
