package net.yscs.android.square_progressbar;

import java.net.URI;

import android.content.Context;
import android.content.res.TypedArray;
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
        init(context, attrs, defStyle);
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
        init(context, attrs, 0);
    }

    /**
     * New SquareProgressBar.
     * 
     * @param context
     * @since 1.0
     */
    public SquareProgressBar(Context context) {
        super(context);
        init(context, null, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        mImage = new ImageView(context);
        addView(mImage);
        setWillNotDraw(false);
        mRender = new BarRender(mCurColor);
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.SquareProgressBar);
        boolean clearAtEnd = false, greyscale = false;
        int maxProgress = 100, progress = 0, progressWidth = 0, progressColor = Color.BLUE;
        Drawable image;
        try {
            clearAtEnd = ta.getBoolean(
                    R.styleable.SquareProgressBar_clearAtEnd, false);
            maxProgress = ta.getInt(R.styleable.SquareProgressBar_max, 100);
            progress = ta.getInt(R.styleable.SquareProgressBar_progress, 0);

            greyscale = ta.getBoolean(R.styleable.SquareProgressBar_greyscale,
                    false);
            progressWidth = ta.getInt(
                    R.styleable.SquareProgressBar_progressWidth, 0);
            progressColor = ta.getColor(
                    R.styleable.SquareProgressBar_progressColor, Color.BLUE);
            image = ta.getDrawable(R.styleable.SquareProgressBar_image);
        } finally {
            ta.recycle();
        }
        mClearAtEnd = clearAtEnd;
        mRender.setToClear(mClearAtEnd);
        mMaxProgress = maxProgress;
        mRender.setMaxProgress(mMaxProgress);
        mCurProgress = progress;
        mRender.setProgress(mCurProgress);
        mGreyscale = greyscale;
        mCurWidth = progressWidth;
        mRender.setWidth(mCurWidth);
        mCurColor = progressColor;
        mRender.changeColor(mCurColor);
        setImage(image);        
    }

    /**
     * Sets the image of the {@link SquareProgressBar}. Must be a valid
     * resourceId.
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
     * (Note: the Bitmap will be decoded on the main UI thread, if you don't
     * want this then use setImage(Drawable)).
     * 
     * @param image
     *            the URI pointing to the image as a ressourceId.
     * @since 2.0
     */
    public void setImage(Uri imageUri) {
        mImage.setImageURI(imageUri);
    }

    /**
     * Sets the {@link Bitmap} of the {@link SquareProgressBar}.
     * 
     * @param image
     *            the image as a ressourceId
     * @since 2.0
     */
    public void setImage(Bitmap image) {
        mImage.setImageBitmap(image);
    }

    /**
     * Sets the {@link Drawable} of the {@link SquareProgressBar}.
     * 
     * @param image
     *            the image as a ressourceId
     * @since 2.0
     */
    public void setImage(Drawable image) {
        mImage.setImageDrawable(image);
    }

    /**
     * Sets the progress of the {@link SquareProgressBar}. 0 or a positive value
     * is required a negative value will be reverted to 0.
     * 
     * @param progress
     *            the progress
     * @since 1.0
     */
    public void setProgress(int progress) {
        mCurProgress = progress < 0 ? 0 : progress;
        mRender.setProgress(progress);
        invalidate();
    }

    /**
     * Sets the maximum progress.
     * 
     * @param maximumProgress
     *            the value representing the maximum progress.
     */
    public void setMaximumProgress(int maximumProgress) {
        mMaxProgress = maximumProgress;
        mRender.setMaxProgress(mMaxProgress);
    }

    /**
     * Sets the color of the {@link SquareProgressBar}. You can give it a
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
     * Sets the color of the {@link SquareProgressBar}.
     * 
     * @param the
     *            new color
     * @since 2.0
     */
    public void setColor(int color) {
        mCurColor = color;
        mRender.changeColor(mCurColor);
        invalidate();
    }

    /**
     * This sets the color of the {@link SquareProgressBar} with a RGB colour.
     * 
     * @param r
     *            red
     * @param g
     *            green
     * @param b
     *            blue�
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

    /**
     * Set how should the progress bar be handled when the maximum progress is
     * achieved.
     * 
     * @param clear
     *            true if the progress bar should be hidden, false otherwise.
     */
    public void clearProgressAtEnd(boolean clear) {
        mClearAtEnd = clear;
        mRender.setToClear(mClearAtEnd);
        if (mClearAtEnd && mCurProgress == mMaxProgress) {
            setWidth(mCurWidth);
        }
    }

    /**
     * Check if the widget will hide it's progress bar when the maximum progress
     * is achieved.
     * 
     * @return true if the progress will disappear when the maximum progress is
     *         achieved, false otherwise.
     */
    public boolean isClearingAtEnd() {
        return mClearAtEnd;
    }

    /**
     * Check if currently the greyscale is set for the image.
     * 
     * @return true if the greyscale is set for the image, false otherwise.
     */
    public boolean isGreyscaleSet() {
        return mGreyscale;
    }

    /**
     * Get the current level of progress. Return 0 when the progress bar is in
     * indeterminate mode.
     * 
     * @return the current progress, between 0 and getMax()
     */
    public int getProgress() {
        return mCurProgress;
    }

    /**
     * Returns the maximum progress.
     * 
     * @return the value representing the maximum progress value.
     */
    public int getMax() {
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

    /**
     * Not implemented at this moment. You could simply use the setWidth()
     * method with a Color.TRANSPARENT.
     */
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        // TODO to implement!!!
    }

    /**
     * Not implemented at this moment. You could simply use the setWidth()
     * method with a Color.TRANSPARENT.
     */
    @Override
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        // TODO to implement!!!
    }

}
