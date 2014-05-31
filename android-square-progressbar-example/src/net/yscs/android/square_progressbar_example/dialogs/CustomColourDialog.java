package net.yscs.android.square_progressbar_example.dialogs;

import net.yscs.android.square_progressbar_example.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/**
 * This gives the user the possibility to set a custom colour to the
 * SquareProgressBar by selecting a RGB-colour.
 * 
 * @author yansigner
 * @since 1.4.0
 */
public class CustomColourDialog extends Dialog {

	private final Button saveButton;
	private SeekBar rSeekBar;
	private SeekBar gSeekBar;
	private SeekBar bSeekBar;
	private int choosenRGB;

	public CustomColourDialog(final Context context) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.customcolourdialog);
		this.setCancelable(false);

		Button closeButton = (Button) this
				.findViewById(R.id.returnColourDialog);
		closeButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
		saveButton = (Button) this.findViewById(R.id.shareColourDialog);

		rSeekBar = (SeekBar) findViewById(R.id.rSeekBar);
		rSeekBar.setMax(255);
		rSeekBar.setProgress(111);
		rSeekBar.setOnSeekBarChangeListener(rgbOnSeekBarListener());

		gSeekBar = (SeekBar) findViewById(R.id.gSeekBar);
		gSeekBar.setMax(255);
		gSeekBar.setProgress(111);
		gSeekBar.setOnSeekBarChangeListener(rgbOnSeekBarListener());

		bSeekBar = (SeekBar) findViewById(R.id.bSeekBar);
		bSeekBar.setMax(255);
		bSeekBar.setProgress(111);
		bSeekBar.setOnSeekBarChangeListener(rgbOnSeekBarListener());

		calculateRGB();
		
	}

	private OnSeekBarChangeListener rgbOnSeekBarListener() {
		return new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// nothing to do =)
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// nothing to do =)

			}

			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				calculateRGB();
			}
		};
	}

	/**
	 * Returns the save button of the dialog.
	 * 
	 * @return the save {@link Button}.
	 */
	public Button getSaveButton() {
		return saveButton;
	}

	/**
	 * Calculates the current set RGB value according to the three
	 * {@link SeekBar}s. This also changes the background of the Dialog.
	 */
	private void calculateRGB() {
		int r = rSeekBar.getProgress();
		int g = gSeekBar.getProgress();
		int b = bSeekBar.getProgress();
		((TextView) findViewById(R.id.rgbText)).setText("(" + r + "," + g + ","
				+ b + ")");
		choosenRGB = Color.rgb(r, g, b);
		getWindow().setBackgroundDrawable(new ColorDrawable(choosenRGB));
	}

	/**
	 * Returns the Color which was chosen in the Dialog.
	 * 
	 * @return the chosen RGB-colour.
	 */
	public int getChoosenRGB() {
		return choosenRGB;
	}
}
