package net.yscs.android.square_progressbar_example;

import java.util.ArrayList;

import net.yscs.android.square_progressbar.SquareProgressBar;
import net.yscs.android.square_progressbar.utils.CalculationUtil;
import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	boolean darth = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final SquareProgressBar squareProgressBar = (SquareProgressBar) findViewById(R.id.subi2);
		squareProgressBar.setImage(R.drawable.city);
		squareProgressBar.setColor("#C9C9C9");
		squareProgressBar.setProgress(32);
		squareProgressBar.setWidth(8);
		squareProgressBar.setOpacity(false);

		final TextView progressView = (TextView) findViewById(R.id.progressDisplay);
		progressView.setText("32%");

		Button change = (Button) findViewById(R.id.changeButton);
		change.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (darth) {
					squareProgressBar.setImage(R.drawable.city);
					darth = false;
				} else {
					squareProgressBar.setImage(R.drawable.millennium_stadium);
					darth = true;
				}
			}
		});

		SeekBar progressSeekBar = (SeekBar) findViewById(R.id.progressSeekBar);
		progressSeekBar
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						// nothing to do
					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						// nothing to do
					}

					@Override
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						squareProgressBar.setProgress(progress);
						progressView.setText(progress + "%");
					}
				});

		SeekBar widthSeekBar = (SeekBar) findViewById(R.id.widthSeekBar);
		widthSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// nothing to do
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// nothing to do
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				squareProgressBar.setWidth(progress);
			}
		});

		// all holo colours
		ArrayList<Integer> colourArray = new ArrayList<Integer>();
		colourArray.add(color.holo_blue_bright);
		colourArray.add(color.holo_blue_dark);
		colourArray.add(color.holo_blue_light);
		colourArray.add(color.holo_green_dark);
		colourArray.add(color.holo_green_light);
		colourArray.add(color.holo_orange_dark);
		colourArray.add(color.holo_orange_light);
		colourArray.add(color.holo_purple);
		colourArray.add(color.holo_red_dark);
		colourArray.add(color.holo_red_light);

		LinearLayout scrollViewLayout = (LinearLayout) findViewById(R.id.colourway);

		for (final Integer resId : colourArray) {
			Context context = getApplicationContext();
			View colourView = new View(context);
			int conValue = CalculationUtil.convertDpToPx(50, context);
			colourView.setLayoutParams(new LayoutParams(conValue, conValue));
			colourView.setBackgroundColor(context.getResources()
					.getColor(resId));
			colourView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					squareProgressBar.setHoloColor(resId);
				}
			});
			scrollViewLayout.addView(colourView);
		}

		CheckBox opacity = (CheckBox) findViewById(R.id.checkBox1);
		opacity.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				squareProgressBar.setOpacity(isChecked);
			}
		});

		CheckBox greyscale = (CheckBox) findViewById(R.id.checkBox2);
		greyscale.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				squareProgressBar.setImageGrayscale(isChecked);
			}
		});
	}
}
