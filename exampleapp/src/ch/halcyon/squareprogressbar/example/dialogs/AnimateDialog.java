package ch.halcyon.squareprogressbar.example.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint.Align;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

import ch.halcyon.squareprogressbar.example.PreviewView;
import ch.halcyon.squareprogressbar.example.R;
import ch.halcyon.squareprogressbar.utils.PercentStyle;

/**
 * The dialog to set some attributes to the animation.
 *
 * @author ysigner
 * @since 1.6.2
 */
public class AnimateDialog extends Dialog {

	private final Button saveButton;
	private final SeekBar bar;
    private int duration;
    final TextView progress;

    /**
	 * The {@link AnimateDialog} to set custom settings for the animation.
	 *
	 * @param context
	 *            the context.
	 */
	public AnimateDialog(final Context context) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.animatedialog);
		this.setCancelable(false);

		Button closeButton = (Button) this.findViewById(R.id.returnAnimateDialog);
		closeButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dismiss();

			}
		});
		saveButton = (Button) this.findViewById(R.id.saveAnimateDialog);

        progress = (TextView) findViewById(R.id.durationTextView);

        bar = (SeekBar) findViewById(R.id.animationDuration);
		bar.setMax(1000);
		bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

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
				duration = arg1;
				progress.setText(arg1 + " ms");
			}
		});
	}

    /**
     * Returns the duration from the SeekBar.
     *
     * @return the duration.
     */
	public int getDuration() {
		return duration;
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
     * Sets the duration for the dialog.
     *
     * @param duration in ms
     */
    public void setDuration(int duration) {
        this.duration = duration;
        bar.setProgress(duration);
        progress.setText(duration + " ms");
    }
}
