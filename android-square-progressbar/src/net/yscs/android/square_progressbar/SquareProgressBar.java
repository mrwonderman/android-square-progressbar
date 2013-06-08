package net.yscs.android.square_progressbar;

import net.yscs.android.square_progressbar.utils.CalculationUtil;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SquareProgressBar extends RelativeLayout {

	private ImageView imageView;
	private final SquareProgressView bar;

	public SquareProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.progressbarview, this, true);
		bar = (SquareProgressView) findViewById(R.id.squareProgressBar1);
	}

	public SquareProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.progressbarview, this, true);
		bar = (SquareProgressView) findViewById(R.id.squareProgressBar1);
	}

	public SquareProgressBar(Context context) {
		super(context);
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.progressbarview, this, true);
		bar = (SquareProgressView) findViewById(R.id.squareProgressBar1);
	}

	public void setImage(int image) {
		imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setImageResource(image);
	}

	public void setProgress(int progress) {
		bar.setProgress(progress);
	}

	public void setHoloColor(int androidHoloColor) {
		bar.setColor(getContext().getResources().getColor(androidHoloColor));
	}

	public void setColor(String colorString) {
		bar.setColor(Color.parseColor(colorString));
	}

	public void setColorRGB(int r, int g, int b) {
		bar.setColor(Color.rgb(r, g, b));
	}

	public void setWidth(int width) {
		int padding = CalculationUtil.convertDpToPx(width, getContext());
		imageView.setPadding(padding, padding, padding, padding);
		bar.setWidthInDp(width);
	}
}
