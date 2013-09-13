/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.yscs.android.square_progressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;

/**
 * This class will handle the drawing of the progress bar for the
 * SquareProgressBar.
 * 
 * @author Luksprog
 * 
 * @since 2.0
 */
class BarRender {

    private int mContainerWidth = 0;
    private int mContainerHeight = 0;
    private int mHalfWidth = 0;
    private int mWidthSpace = 0;
    private int mMaxProgress;
    private int mCurProgress;
    private Paint mPaint = new Paint();
    private Rect mTempRect = new Rect();
    private boolean mClear;
    private double mScale = 1.0;

    BarRender(int color) {
        changeColor(color);
        mPaint.setStyle(Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true);
    }

    /**
     * Called when the container changes in such a way that the renderer must
     * recalculate its own values(like changes in size, the size of the maximum
     * progress etc)
     * 
     * @param width
     *            the new width of the SquareProgressBar
     * @param height
     *            the new height of the SquareProgressBar
     * @param space
     *            the new width for the progress bar
     * @param maxProgress
     *            the new maximum progress
     */
    void setupValues(int width, int height, int space, int maxProgress) {
        this.mContainerWidth = width;
        this.mContainerHeight = height;
        this.mWidthSpace = space;
        mHalfWidth = mContainerWidth / 2;
        mScale = (double) calculateEntireRange(width, height) / mMaxProgress;
    }

    void changeColor(int color) {
        mPaint.setColor(color);
    }

    void setToClear(boolean clear) {
        mClear = clear;
    }

    /**
     * Do the actual drawing!
     * 
     * @param canvas
     *            the Canvas obtained from the SquareProgressBar
     */
    void draw(Canvas canvas) {
        if (mClear && mCurProgress == mMaxProgress) {
            return;
        }
        final Rect r = mTempRect;
        int totalPixelProgress = (int) Math.round(mCurProgress * mScale - 0.5);
        int leftOver = totalPixelProgress - mHalfWidth;
        if (leftOver <= 0) {
            makeRectBar(r, mHalfWidth, 0, mHalfWidth + totalPixelProgress,
                    mWidthSpace);
            canvas.drawRect(r, mPaint);
            return;
        } else {
            makeRectBar(r, mHalfWidth, 0, mContainerWidth, mWidthSpace);
            canvas.drawRect(r, mPaint);
        }
        totalPixelProgress = leftOver;
        leftOver = totalPixelProgress - (mContainerHeight - mWidthSpace);
        if (leftOver <= 0) {
            makeRectBar(r, mContainerWidth - mWidthSpace, mWidthSpace,
                    mContainerWidth, mWidthSpace + totalPixelProgress);
            canvas.drawRect(r, mPaint);
            return;
        } else {
            makeRectBar(r, mContainerWidth - mWidthSpace, mWidthSpace,
                    mContainerWidth, mContainerHeight);
            canvas.drawRect(r, mPaint);
        }
        totalPixelProgress = leftOver;
        leftOver = totalPixelProgress - (mContainerWidth - mWidthSpace);
        if (leftOver <= 0) {
            makeRectBar(r, mContainerWidth - totalPixelProgress - mWidthSpace,
                    mContainerHeight - mWidthSpace, mContainerWidth
                            - mWidthSpace, mContainerHeight);
            canvas.drawRect(r, mPaint);
            return;
        } else {
            makeRectBar(r, 0, mContainerHeight - mWidthSpace, mContainerWidth
                    - mWidthSpace, mContainerHeight);
            canvas.drawRect(r, mPaint);
        }
        totalPixelProgress = leftOver;
        leftOver = totalPixelProgress - (mContainerHeight - mWidthSpace);
        if (leftOver <= 0) {
            makeRectBar(r, 0, mContainerHeight - totalPixelProgress
                    - mWidthSpace, mWidthSpace, mContainerHeight - mWidthSpace);
            canvas.drawRect(r, mPaint);
            return;
        } else {
            makeRectBar(r, 0, 0, mWidthSpace, mContainerHeight - mWidthSpace);
            canvas.drawRect(r, mPaint);
        }
        totalPixelProgress = leftOver;
        if (mCurProgress == mMaxProgress) {
            makeRectBar(r, mWidthSpace, 0, mHalfWidth, mWidthSpace);
            canvas.drawRect(r, mPaint);
        } else {
            makeRectBar(r, mWidthSpace, 0, mWidthSpace + totalPixelProgress,
                    mWidthSpace);
            canvas.drawRect(r, mPaint);
        }
    }

    void setProgress(int progress) {
        mCurProgress = progress;
    }

    void setMaxProgress(int max) {
        mMaxProgress = max;

        mScale = calculateEntireRange(mContainerWidth, mContainerHeight)
                / mMaxProgress;
    }

    void setWidth(int newWidth) {
        mWidthSpace = newWidth;
    }

    /**
     * Helper method to update our work Rect with the proper values.
     */
    private void makeRectBar(Rect r, int left, int top, int right, int bottom) {
        r.left = left;
        r.top = top;
        r.right = right;
        r.bottom = bottom;
    }

    /**
     * Calculates the full range which the progress will fill.
     * 
     * @param width
     *            the width of the SquareProgressbar
     * @param height
     *            the height of the SquareProgressBar
     * @return the size of the range which the progress bar will fill.
     */
    private double calculateEntireRange(int width, int height) {
        int result = 2 * width + 2 * (height - 2 * mWidthSpace);
        return result < 0 ? 0 : result;
    }

}
