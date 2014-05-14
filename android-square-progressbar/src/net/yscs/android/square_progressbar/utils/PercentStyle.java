package net.yscs.android.square_progressbar.utils;

import android.graphics.Paint;
import android.graphics.Paint.Align;

public class PercentStyle {
	private Paint.Align align;
	private float textSize;
	private boolean percentSign;
	private String customText = "%";

	public PercentStyle() {
		// do nothing
	}

	public PercentStyle(Align align, float textSize, boolean percentSign) {
		super();
		this.align = align;
		this.textSize = textSize;
		this.percentSign = percentSign;
	}

	public Paint.Align getAlign() {
		return align;
	}

	public void setAlign(Paint.Align align) {
		this.align = align;
	}

	public float getTextSize() {
		return textSize;
	}

	public void setTextSize(float textSize) {
		this.textSize = textSize;
	}

	public boolean isPercentSign() {
		return percentSign;
	}

	public void setPercentSign(boolean percentSign) {
		this.percentSign = percentSign;
	}

	public String getCustomText() {
		return customText;
	}

	public void setCustomText(String customText) {
		this.customText = customText;
	}

}