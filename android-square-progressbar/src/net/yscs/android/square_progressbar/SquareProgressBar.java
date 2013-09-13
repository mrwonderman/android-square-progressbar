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
 * The basic SquareProgressBar(default color of Color.BLUE). This class includes
 * all the methods you need to modify the {@link SquareProgressBar}.
 * 
 * @author ysigner
 * @since 1.0
 */
public class SquareProgressBar extends ViewGroup {

    private ImageView mImage;
    private boolean mGreyscale;
    private int mThickness;
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
        int maxProgress = 100, progress = 0, thickness = 0, progressColor = Color.BLUE;
        Drawable image;
        try {
            clearAtEnd = ta.getBoolean(
                    R.styleable.SquareProgressBar_clearAtEnd, false);
            maxProgress = ta.getInt(R.styleable.SquareProgressBar_max, 100);
            progress = ta.getInt(R.styleable.SquareProgressBar_progress, 0);

            greyscale = ta.getBoolean(R.styleable.SquareProgressBar_greyscale,
                    false);
            thickness = ta.getInt(R.styleable.SquareProgressBar_thickness, 0);
            progressColor = ta.getColor(R.styleable.SquareProgressBar_color,
                    Color.BLUE);
            image = ta.getDrawable(R.styleable.SquareProgressBar_image);
        } finally {
            ta.recycle();
        }
        mClearAtEnd = clearAtEnd;
        mRender.setToClear(mClearAtEnd);
        mMaxProgress = maxProgress;
        mRender.setMax(mMaxProgress);
        mCurProgress = progress;
        mRender.setProgress(mCurProgress);
        mGreyscale = greyscale;
        setImageGrayscale(mGreyscale);
        mThickness = thickness;
        mRender.setThickness(mThickness);
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
     * is required, a negative value will translate in a progress of 0. If the
     * progress is greater than getMax() then the progress will be limited to
     * the maximum value.
     * 
     * @param progress
     *            the progress
     * @since 1.0
     */
    public void setProgress(int progress) {
        mCurProgress = progress < 0 ? 0
                : (progress >= mMaxProgress ? mMaxProgress : progress);
        mRender.setProgress(mCurProgress);
        invalidate();
    }

    /**
     * Sets the maximum progress. A negative value will translate to a maximum
     * progress of 0. If the set maximum progress is smaller then the current
     * progress will revert to this maximum value.
     * 
     * @param max
     *            the value representing the maximum progress.
     */
    public void setMax(int max) {
        if (max < 0) {
            max = 0;
            setProgress(0);
        } else if (max < mCurProgress) {
            setProgress(max);
        }
        mMaxProgress = max;
        mRender.setMax(mMaxProgress);
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
     *            blue¨
     * @since 1.1
     */
    public void setColorRGB(int r, int g, int b) {
        mCurColor = Color.rgb(r, g, b);
        mRender.changeColor(mCurColor);
        invalidate();
    }

    /**
     * Sets the thickness of the {@link SquareProgressBar}. Can't be bigger then
     * half of the current width/height of the SquareProgressBar.
     * 
     * @param thickness
     *            the new value for the thickness
     * @since 1.1
     */
    public void setThickness(int thickness) {
        mThickness = thickness;
        mRender.setThickness(thickness);
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
            setThickness(mThickness);
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
        mImage.layout(mThickness, mThickness, getMeasuredWidth() - mThickness,
                getMeasuredHeight() - mThickness);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        // first measure the ImageView with the current values(without the
        // current mWidthSize) and see how bit it wants to be
        mImage.measure(MeasureSpec.makeMeasureSpec(widthSize - 2 * mThickness,
                widthMode), MeasureSpec.makeMeasureSpec(heightSize - 2
                * mThickness, heightMode));
        widthSize = Math.min(widthSize, mImage.getMeasuredWidth() + 2
                * mThickness);
        heightSize = Math.min(heightSize, mImage.getMeasuredHeight() + 2
                * mThickness);
        setMeasuredDimension(widthSize, heightSize);
        mRender.setupValues(getMeasuredWidth(), getMeasuredHeight(),
                mThickness, mMaxProgress);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRender.draw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRender.setupValues(getMeasuredWidth(), getMeasuredHeight(),
                mThickness, mMaxProgress);
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
