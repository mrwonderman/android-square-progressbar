package ch.halcyon.squareprogressbar.example;

import ch.halcyon.squareprogressbar.SquareProgressBar;

import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import java.util.Random;

public class SquareFragment extends Fragment {
	public SquareProgressBar squareProgressBar;
    private boolean animate = false;
    private ObjectAnimator anim;
    private SeekBar progressSeekBar, widthSeekBar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(ch.halcyon.squareprogressbar.example.R.layout.square_layout, container, false);

        final TextView progressView = (TextView) view
                .findViewById(ch.halcyon.squareprogressbar.example.R.id.progressDisplay);
        progressView.setText("32%");

        squareProgressBar = (SquareProgressBar) view.findViewById(ch.halcyon.squareprogressbar.example.R.id.subi2);
		squareProgressBar.setImage(ch.halcyon.squareprogressbar.example.R.drawable.blenheim_palace);
		squareProgressBar.setColor("#C9C9C9");
		squareProgressBar.setProgress(32);
		squareProgressBar.setWidth(8);
        squareProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();

                // random width
                int randWidth = random.nextInt(17) + 4;
                widthSeekBar.setProgress(randWidth);
                squareProgressBar.setWidth(randWidth);

                // random colour
                squareProgressBar.setColorRGB(random.nextInt(256), random.nextInt(256), random.nextInt(256));

                // animate to a random amount
                boolean oldState = animate;
                animate = true;
                setProgressBarProgress(random.nextInt(100), progressView);
                animate = oldState;
            }
        });

        progressSeekBar = (SeekBar) view
				.findViewById(ch.halcyon.squareprogressbar.example.R.id.progressSeekBar);
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
                        setProgressBarProgress(progress, progressView);
					}
				});

		widthSeekBar = (SeekBar) view.findViewById(ch.halcyon.squareprogressbar.example.R.id.widthSeekBar);
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
		return view;
	}

    private void setProgressBarProgress(int progress, TextView progressView) {
        if (isAnimated()) {
            anim = ObjectAnimator.ofInt(squareProgressBar, "Progress", (int) squareProgressBar.getProgress(), progress);
            anim.setDuration(500);
            anim.start();
        } else {
            squareProgressBar.setProgress(progress);
        }
        progressView.setText(progress + "%");
        progressSeekBar.setProgress(progress);
    }

    public void setAnimate(boolean animate) {
        this.animate = animate;
    }

    public boolean isAnimated() {
        return animate;
    }

}
