package net.yscs.android.square_progressbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SquareProgressBar extends RelativeLayout {

	public SquareProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.progressbarview, this, true);
	}

	public SquareProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.progressbarview, this, true);
	}

	public SquareProgressBar(Context context) {
		super(context);
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.progressbarview, this, true);
	}

	public void setImage(int image) {
		ImageView imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setImageResource(image);
	}

	public void setProgress(int progress) {
		SquareProgressView bar = (SquareProgressView) findViewById(R.id.squareProgressBar1);
		bar.setProgress(progress);
	}

	public void setColor(int androidHoloColor) {
		SquareProgressView bar = (SquareProgressView) findViewById(R.id.squareProgressBar1);
		bar.setColor(androidHoloColor);
	}
}
