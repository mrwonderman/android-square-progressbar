package net.yscs.android.square_progressbar_example;

import net.yscs.android.square_progressbar.SquareProgressBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final SquareProgressBar subi = (SquareProgressBar) findViewById(R.id.subi1);
		subi.setImage(R.drawable.snape);
		subi.setProgress(50);

		final SquareProgressBar subi2 = (SquareProgressBar) findViewById(R.id.subi2);
		subi2.setImage(R.drawable.fam);
		subi2.setProgress(25);

		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText editText = (EditText) findViewById(R.id.editText1);
				subi.setProgress(Integer
						.parseInt(editText.getText().toString()));
				subi2.setProgress(Integer.parseInt(editText.getText()
						.toString()));
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
