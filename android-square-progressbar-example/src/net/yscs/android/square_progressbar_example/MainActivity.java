package net.yscs.android.square_progressbar_example;

import net.yscs.android.square_progressbar.SquareProgressBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	boolean darth = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final SquareProgressBar squareProgressBar = (SquareProgressBar) findViewById(R.id.subi2);
		squareProgressBar.setImage(R.drawable.house);
		squareProgressBar.setProgress(3);
		squareProgressBar.setColor(getApplicationContext().getResources()
				.getColor(android.R.color.holo_blue_dark));

		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText editText = (EditText) findViewById(R.id.editText1);
				squareProgressBar.setProgress(Integer.parseInt(editText
						.getText().toString()));
			}
		});

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
	}

}
