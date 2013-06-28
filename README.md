android-square-progressbar
==========================
![square image](https://googledrive.com/host/0BwESwPCuXtw7eExwSFVLQkR2TTg/IMG_20130628_185136.jpg)
## First things first
Here you can find my blogpost about the library: http://www.signer.pro/android-square-progressbar/

Example application: https://play.google.com/store/apps/details?id=net.yscs.android.square_progressbar_example

<a href="https://play.google.com/store/apps/details?id=net.yscs.android.square_progressbar_example">
  <img alt="Get it on Google Play"
       src="https://developer.android.com/images/brand/en_generic_rgb_wo_60.png" />
</a>

## General idea
The idea came when I needed a way to display a progressbar in a clever way in my quiz app. There I have a square image and some text below it. But no more space for a progressbar. So the best way would be a progressbar around the image.

### Examples
Some examples:

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
