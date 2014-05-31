package net.yscs.android.square_progressbar_example.dialogs;

import net.yscs.android.square_progressbar.utils.PercentStyle;
import net.yscs.android.square_progressbar_example.PreviewView;
import net.yscs.android.square_progressbar_example.R;
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

/**
 * THe dialog to set some example values for the percent text.
 * 
 * @author ysigner
 * @since 1.3.0
 */
public class PercentDialog extends Dialog {

	private final Spinner spinner;
	private final CheckBox box;
	private final Button saveButton;
	private final SeekBar bar;
	private int size;
	private final PreviewView previewView;

	/**
	 * The {@link PercentDialog} to set custom settings for the style of the
	 * percent text.
	 * 
	 * @param context
	 *            the context.
	 */
	public PercentDialog(final Context context) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.percentdialog);
		this.setCancelable(false);
		spinner = (Spinner) this.findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				context, R.array.alignstyle,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		previewView = (PreviewView) findViewById(R.id.previewView1);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				redrawPreview();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// nothing to do =)
			}
		});

		Button closeButton = (Button) this.findViewById(R.id.returnDialog);
		closeButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dismiss();

			}
		});
		saveButton = (Button) this.findViewById(R.id.shareDialog);

		final TextView progress = (TextView) findViewById(R.id.textView3);

		bar = (SeekBar) findViewById(R.id.textSize);
		bar.setMax(400);
		bar.setProgress(125);
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
				size = arg1;
				progress.setText(arg1 + " dp");
				redrawPreview();
			}
		});

		box = (CheckBox) this.findViewById(R.id.checkBox1);
		box.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				redrawPreview();
			}
		});

	}

	/**
	 * Returns the {@link PercentStyle} of the current settings.
	 * 
	 * @return a new {@link PercentStyle}.
	 */
	public PercentStyle getSettings() {
		return new PercentStyle(Align.valueOf((String) spinner
				.getSelectedItem()), Float.valueOf(bar.getProgress()),
				box.isChecked());
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
	 * Returns the {@link Align} according to the position in the dropdown.
	 * 
	 * @param position
	 *            the position in the dropdown.
	 * @return the according {@link Align}.
	 */
	private Align returnAlign(int position) {
		switch (position) {
		case 0:
			return Align.CENTER;
		case 1:
			return Align.RIGHT;
		case 2:
			return Align.LEFT;
		default:
			return Align.CENTER;
		}
	}

	/**
	 * Redraws the preview canvas.
	 */
	private void redrawPreview() {
		previewView
				.drawText(size, returnAlign(spinner.getSelectedItemPosition()),
						box.isChecked());
	}

	/**
	 * Sets the {@link PercentStyle} to the settings in the dialog.
	 * 
	 * @param settings
	 *            The {@link PercentStyle}, this is most likely the default
	 *            settings.
	 */
	public void setPercentStyle(PercentStyle settings) {
		switch (settings.getAlign()) {
		case CENTER:
			spinner.setSelection(0);
			break;
		case RIGHT:
			spinner.setSelection(1);
			break;
		case LEFT:
			spinner.setSelection(2);
			break;
		default:
			spinner.setSelection(0);
			break;
		}

		bar.setProgress(Math.round(settings.getTextSize()));
		box.setChecked(settings.isPercentSign());
	}
}
