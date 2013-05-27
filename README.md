android-square-progressbar
==========================
![square image](https://googledrive.com/host/0BwESwPCuXtw7eExwSFVLQkR2TTg/IMG_3462.JPG)
## First things first
Here you can find my blogpost about the library: http://www.signer.pro/android-square-progressbar/

Library: http://pub.signer.pro/android-square-progressbar-1.0.1.jar

Example application: https://play.google.com/store/apps/details?id=net.yscs.android.square_progressbar_example

<a href="https://play.google.com/store/apps/details?id=net.yscs.android.square_progressbar_example">
  <img alt="Get it on Google Play"
       src="https://developer.android.com/images/brand/en_generic_rgb_wo_60.png" />
</a>

## General idea
The idea came when I needed a way to display a progressbar in a clever way in my quiz app. There I have a square image and some text below it. But no more space for a progressbar. So the best way would be a progressbar around the image.

### Examples
Some examples:

![rectangular image](https://googledrive.com/host/0BwESwPCuXtw7eExwSFVLQkR2TTg/one.png)
![rectangular image](https://googledrive.com/host/0BwESwPCuXtw7eExwSFVLQkR2TTg/two.png)

### How to use it?
    final SquareProgressBar sProgressBar = (SquareProgressBar) findViewById(R.id.squareprogressbar);
    sProgressBar.setImage(R.drawable.house);
    sProgressBar.setProgress(25);
    sProgressBar.setColor(getApplicationContext().getResources().getColor(android.R.color.holo_blue_dark));

## Roadmap
![roadmap](https://googledrive.com/host/0BwESwPCuXtw7eExwSFVLQkR2TTg/roadmap.png)
