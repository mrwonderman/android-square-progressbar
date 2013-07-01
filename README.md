android-square-progressbar
==========================
![square image](https://googledrive.com/host/0BwESwPCuXtw7eExwSFVLQkR2TTg/IMG_20130628_185136.jpg)
## First things first
My post about the update 1.1.0 : http://www.signer.pro/android-square-progressbar-v-1-1-0/

My post about the initial version 1.0 : http://www.signer.pro/android-square-progressbar/

Example application: https://play.google.com/store/apps/details?id=net.yscs.android.square_progressbar_example

<a href="https://play.google.com/store/apps/details?id=net.yscs.android.square_progressbar_example">
  <img alt="Get it on Google Play"
       src="https://developer.android.com/images/brand/en_generic_rgb_wo_60.png" />
</a>

## General idea
Sometimes you dont have enough space in your layout to display a progressBar. So this library gives you a new approach. You can simply display a progressbar in a colour/color you want around an image.

This library is in an early state, but with your feedback it only can get better. So feel free to submit new feature request and report bugs.
### Examples
Here are some examples how these progressBars could look like:

![rectangular image](https://googledrive.com/host/0BwESwPCuXtw7eExwSFVLQkR2TTg/newscreen1.png)
![rectangular image](https://googledrive.com/host/0BwESwPCuXtw7eExwSFVLQkR2TTg/newscreen2.png)

### How to use it?
    SquareProgressBar squareProgressBar = (SquareProgressBar) findViewById(R.id.squareprogressbar);
    squareProgressBar.setImage(R.drawable.city);
    squareProgressBar.setColor("#C9C9C9");
    squareProgressBar.setProgress(32);
    squareProgressBar.setWidth(8);

## Colour / Color
(http://en.wikipedia.org/wiki/American_and_British_English_spelling_differences#-our.2C_-or)

There are 3 possibilities to set the colour of the progressbar:

    squareProgressBar.setColor("#C9C9C9");
    
  	squareProgressBar.setColorRGB(112, 13, 119);
    
    squareProgressBar.setHoloColor(color.holo_blue_dark);
