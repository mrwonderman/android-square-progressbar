package net.yscs.android.square_progressbar_example;

import net.yscs.android.square_progressbar.SquareProgressBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	boolean darth = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final SquareProgressBar squareProgressBar = (SquareProgressBar) findViewById(R.id.subi2);
		squareProgressBar.setImage(R.drawable.house);
		squareProgressBar.setColor(getApplicationContext().getResources()
				.getColor(android.R.color.holo_blue_dark));
		squareProgressBar.setProgress(25);
		squareProgressBar.setWidth(8);

		Button change = (Button) findViewById(R.id.button2);
		change.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (darth) {
					squareProgressBar.setImage(R.drawable.house);
					darth = false;
				} else {
					squareProgressBar.setImage(R.drawable.darth);
					darth = true;
				}
			}
		});

		SeekBar progressSeekBar = (SeekBar) findViewById(R.id.seekBar1);
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
					}
				});

		SeekBar widthSeekBar = (SeekBar) findViewById(R.id.seekBar2);
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
	}
}
