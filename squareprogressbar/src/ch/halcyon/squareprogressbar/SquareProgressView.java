package ch.halcyon.squareprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.text.DecimalFormat;

import ch.halcyon.squareprogressbar.utils.CalculationUtil;
import ch.halcyon.squareprogressbar.utils.PercentStyle;

public class SquareProgressView extends View {

    private double progress;
    private Paint progressBarPaint;
    private Paint outlinePaint;
    private Paint textPaint;

    private float widthInDp = 10;
    private float strokewidth = 0;
    private Canvas canvas;

    private boolean outline = false;
    private boolean startline = false;
    private boolean showProgress = false;
    private boolean centerline = false;

    private PercentStyle percentSettings = new PercentStyle(Align.CENTER, 150,
            true);
    private boolean clearOnHundred = false;
    private boolean isIndeterminate = false;
    private int indeterminate_count = 1;

    private float indeterminate_width = 20.0f;

    public SquareProgressView(Context context) {
        super(context);
        initializePaints(context);
    }

    public SquareProgressView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializePaints(context);
    }

    public SquareProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializePaints(context);
    }

    private void initializePaints(Context context) {
        progressBarPaint = new Paint();
        progressBarPaint.setColor(context.getResources().getColor(
                android.R.color.holo_green_dark));
        progressBarPaint.setStrokeWidth(CalculationUtil.convertDpToPx(
                widthInDp, getContext()));
        progressBarPaint.setAntiAlias(true);
        progressBarPaint.setStyle(Style.STROKE);

        outlinePaint = new Paint();
        outlinePaint.setColor(context.getResources().getColor(
                android.R.color.black));
        outlinePaint.setStrokeWidth(1);
        outlinePaint.setAntiAlias(true);
        outlinePaint.setStyle(Style.STROKE);

        textPaint = new Paint();
        textPaint.setColor(context.getResources().getColor(
                android.R.color.black));
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;
        super.onDraw(canvas);
        strokewidth = CalculationUtil.convertDpToPx(widthInDp, getContext());
        float scope = canvas.getWidth() + canvas.getHeight()
                + canvas.getHeight() + canvas.getWidth() - strokewidth;

        if (isOutline()) {
            drawOutline();
        }

        if (isStartline()) {
            drawStartline();
        }

        if (isShowProgress()) {
            drawPercent(percentSettings);
        }

        if (isCenterline()) {
            drawCenterline(strokewidth);
        }

        if ((isClearOnHundred() && progress == 100.0) || (progress <= 0.0)) {
            return;
        }

        if (isIndeterminate()) {
            Path path = new Path();
            DrawStop drawEnd = getDrawEnd((scope / 100) * Float.valueOf(String.valueOf(indeterminate_count)), canvas);

            if (drawEnd.place == Place.TOP) {
                path.moveTo(drawEnd.location - indeterminate_width - strokewidth, strokewidth / 2);
                path.lineTo(drawEnd.location, strokewidth / 2);
                canvas.drawPath(path, progressBarPaint);
            }

            if (drawEnd.place == Place.RIGHT) {
                path.moveTo(canvas.getWidth() - (strokewidth / 2), drawEnd.location - indeterminate_width);
                path.lineTo(canvas.getWidth() - (strokewidth / 2), strokewidth
                        + drawEnd.location);
                canvas.drawPath(path, progressBarPaint);
            }

            if (drawEnd.place == Place.BOTTOM) {
                path.moveTo(drawEnd.location - indeterminate_width - strokewidth,
                        canvas.getHeight() - (strokewidth / 2));
                path.lineTo(drawEnd.location, canvas.getHeight()
                        - (strokewidth / 2));
                canvas.drawPath(path, progressBarPaint);
            }

            if (drawEnd.place == Place.LEFT) {
                path.moveTo((strokewidth / 2), drawEnd.location - indeterminate_width
                        - strokewidth);
                path.lineTo((strokewidth / 2), drawEnd.location);
                canvas.drawPath(path, progressBarPaint);
            }

            indeterminate_count++;
            if (indeterminate_count > 100) {
                indeterminate_count = 0;
            }
            invalidate();
        } else {
            Path path = new Path();
            DrawStop drawEnd = getDrawEnd((scope / 100) * Float.valueOf(String.valueOf(progress)), canvas);

            if (drawEnd.place == Place.TOP) {
                if (drawEnd.location > (canvas.getWidth() / 2)) {
                    path.moveTo(canvas.getWidth() / 2, strokewidth / 2);
                    path.lineTo(drawEnd.location, strokewidth / 2);
                } else {
                    path.moveTo(canvas.getWidth() / 2, strokewidth / 2);
                    path.lineTo(canvas.getWidth() - (strokewidth / 2), strokewidth / 2);
                    path.lineTo(canvas.getWidth() - (strokewidth / 2), canvas.getHeight() - strokewidth / 2);
                    path.lineTo(strokewidth / 2, canvas.getHeight() - strokewidth / 2);
                    path.lineTo(strokewidth / 2, strokewidth / 2);
                    path.lineTo(drawEnd.location, strokewidth / 2);
                }
                canvas.drawPath(path, progressBarPaint);
            }

            if (drawEnd.place == Place.RIGHT) {
                path.moveTo(canvas.getWidth() / 2, strokewidth / 2);
                path.lineTo(canvas.getWidth() - (strokewidth / 2), strokewidth / 2);
                path.lineTo(canvas.getWidth() - (strokewidth / 2), strokewidth / 2
                        + drawEnd.location);
                canvas.drawPath(path, progressBarPaint);
            }

            if (drawEnd.place == Place.BOTTOM) {
                path.moveTo(canvas.getWidth() / 2, strokewidth / 2);
                path.lineTo(canvas.getWidth() - (strokewidth / 2), strokewidth / 2);
                path.lineTo(canvas.getWidth() - (strokewidth / 2), canvas.getHeight());
                path.moveTo(canvas.getWidth(), canvas.getHeight() - strokewidth / 2);
                path.lineTo(drawEnd.location, canvas.getHeight()
                        - (strokewidth / 2));
                canvas.drawPath(path, progressBarPaint);
            }

            if (drawEnd.place == Place.LEFT) {
                path.moveTo(canvas.getWidth() / 2, strokewidth / 2);
                path.lineTo(canvas.getWidth() - (strokewidth / 2), strokewidth / 2);
                path.lineTo(canvas.getWidth() - (strokewidth / 2), canvas.getHeight() - strokewidth / 2);
                path.lineTo(0, canvas.getHeight() - strokewidth / 2);
                path.moveTo(strokewidth / 2, canvas.getHeight() - strokewidth / 2);
                path.lineTo((strokewidth / 2), drawEnd.location);
                canvas.drawPath(path, progressBarPaint);
            }
        }
    }

    private void drawStartline() {
        Path outlinePath = new Path();
        outlinePath.moveTo(canvas.getWidth() / 2, 0);
        outlinePath.lineTo(canvas.getWidth() / 2, strokewidth);
        canvas.drawPath(outlinePath, outlinePaint);
    }

    private void drawOutline() {
        Path outlinePath = new Path();
        outlinePath.moveTo(0, 0);
        outlinePath.lineTo(canvas.getWidth(), 0);
        outlinePath.lineTo(canvas.getWidth(), canvas.getHeight());
        outlinePath.lineTo(0, canvas.getHeight());
        outlinePath.lineTo(0, 0);
        canvas.drawPath(outlinePath, outlinePaint);
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

    public void setWidthInDp(int width) {
        this.widthInDp = width;
        progressBarPaint.setStrokeWidth(CalculationUtil.convertDpToPx(
                widthInDp, getContext()));
        this.invalidate();
    }

    public boolean isOutline() {
        return outline;
    }

    public void setOutline(boolean outline) {
        this.outline = outline;
        this.invalidate();
    }

    public boolean isStartline() {
        return startline;
    }

    public void setStartline(boolean startline) {
        this.startline = startline;
        this.invalidate();
    }

    private void drawPercent(PercentStyle setting) {
        textPaint.setTextAlign(setting.getAlign());
        if (setting.getTextSize() == 0) {
            textPaint.setTextSize((canvas.getHeight() / 10) * 4);
        } else {
            textPaint.setTextSize(setting.getTextSize());
        }

        String percentString = new DecimalFormat("###").format(getProgress());
        if (setting.isPercentSign()) {
            percentString = percentString + percentSettings.getCustomText();
        }

        textPaint.setColor(percentSettings.getTextColor());

        canvas.drawText(
                percentString,
                canvas.getWidth() / 2,
                (int) ((canvas.getHeight() / 2) - ((textPaint.descent() + textPaint
                        .ascent()) / 2)), textPaint);
    }

    public boolean isShowProgress() {
        return showProgress;
    }

    public void setShowProgress(boolean showProgress) {
        this.showProgress = showProgress;
        this.invalidate();
    }

    public void setPercentStyle(PercentStyle percentSettings) {
        this.percentSettings = percentSettings;
        this.invalidate();
    }

    public PercentStyle getPercentStyle() {
        return percentSettings;
    }

    public void setClearOnHundred(boolean clearOnHundred) {
        this.clearOnHundred = clearOnHundred;
        this.invalidate();
    }

    public boolean isClearOnHundred() {
        return clearOnHundred;
    }

    private void drawCenterline(float strokewidth) {
        float centerOfStrokeWidth = strokewidth / 2;
        Path centerlinePath = new Path();
        centerlinePath.moveTo(centerOfStrokeWidth, centerOfStrokeWidth);
        centerlinePath.lineTo(canvas.getWidth() - centerOfStrokeWidth, centerOfStrokeWidth);
        centerlinePath.lineTo(canvas.getWidth() - centerOfStrokeWidth, canvas.getHeight() - centerOfStrokeWidth);
        centerlinePath.lineTo(centerOfStrokeWidth, canvas.getHeight() - centerOfStrokeWidth);
        centerlinePath.lineTo(centerOfStrokeWidth, centerOfStrokeWidth);
        canvas.drawPath(centerlinePath, outlinePaint);
    }

    public boolean isCenterline() {
        return centerline;
    }

    public void setCenterline(boolean centerline) {
        this.centerline = centerline;
        this.invalidate();
    }

    public boolean isIndeterminate() {
        return isIndeterminate;
    }

    public void setIndeterminate(boolean indeterminate) {
        isIndeterminate = indeterminate;
        this.invalidate();
    }

    public DrawStop getDrawEnd(float percent, Canvas canvas) {
        DrawStop drawStop = new DrawStop();
        strokewidth = CalculationUtil.convertDpToPx(widthInDp, getContext());
        float halfOfTheImage = canvas.getWidth() / 2;

        if (percent > halfOfTheImage) {
            float second = percent - halfOfTheImage;

            if (second > canvas.getHeight()) {
                float third = second - canvas.getHeight();

                if (third > canvas.getWidth()) {
                    float forth = third - canvas.getWidth();

                    if (forth > canvas.getHeight()) {
                        float fifth = forth - canvas.getHeight();

                        if (fifth == halfOfTheImage) {
                            drawStop.place = Place.TOP;
                            drawStop.location = halfOfTheImage;
                        } else {
                            drawStop.place = Place.TOP;
                            drawStop.location = strokewidth + fifth;
                        }
                    } else {
                        drawStop.place = Place.LEFT;
                        drawStop.location = canvas.getHeight() - forth;
                    }

                } else {
                    drawStop.place = Place.BOTTOM;
                    drawStop.location = canvas.getWidth() - third;
                }
            } else {
                drawStop.place = Place.RIGHT;
                drawStop.location = strokewidth + second;
            }

        } else {
            drawStop.place = Place.TOP;
            drawStop.location = halfOfTheImage + percent;
        }

        return drawStop;
    }

    private class DrawStop {

        private Place place;
        private float location;

        public DrawStop() {

        }
    }

    public enum Place {
        TOP, RIGHT, BOTTOM, LEFT
    }
}
