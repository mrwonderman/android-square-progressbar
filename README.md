android-square-progressbar
==========================
![square image](https://oavhhw.bn1.livefilestore.com/y2mOYieeVxCoUj5JwuoeHt302BrP4iKC3qeFV1gUkWh7Xjm5ie5ZjANjekofpakTTMZb6-m3gwnx1SauhMo87D9VVh4MVEDW-0Tpq47-liKfLF-lpNNAoTTYCSVUJcjz4dB/header140.png?psid=1)
## First things first

You can find my blog post about the newest version here : [signer.pro - android-square-progressbar v. 1.4.0] (http://www.signer.pro/android-square-progressbar-v-1-4-0/)

The example application is available at the play store.

<a href="https://play.google.com/store/apps/details?id=net.yscs.android.square_progressbar_example">
  <img alt="Get it on Google Play"
       src="https://developer.android.com/images/brand/en_generic_rgb_wo_60.png" />
</a>

## General idea
Sometimes you dont have enough space in your layout to display a wide progressbar. So this library gives you a complete new possibility to display a progress. You can simply show a progressbar around an image. An this progressbar can be configured in a lot of different ways, like colour, an outline, display the percentage and so on.

### Examples
Here are some examples how these progressbars could look like:

![three examples](https://mkvhhw.bn1.livefilestore.com/y2mmRAmVz8BzkLSYLSqV0yM6HCLh9uMMrQ4VqVJ0ocJTR5pUtc-b5ruBF6-XFOWzdKkxv1WbeVj15fefu0g0NEB60KUvbm6xwOEnBkbR_YwkmYF-Z808sqpgtGH4nhRs6ru/squareprogressbarexample_140.png?psid=1)

### How to use it?

After you included the library as a library project to your project, add the following xml code to your layout:

    <net.yscs.android.square_progressbar.SquareProgressBar
        android:id="@+id/subi"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:paddingTop="20dp" >
    </net.yscs.android.square_progressbar.SquareProgressBar>
    
Then you use the following code to set some inital settings:

    SquareProgressBar squareProgressBar = (SquareProgressBar) findViewById(R.id.subi);
    squareProgressBar.setImage(R.drawable.city);
    squareProgressBar.setColor("#C9C9C9");
    squareProgressBar.setProgress(32);
    squareProgressBar.setWidth(8);
    

## Gradle
A big thank you to [@elodieferrais](https://github.com/elodieferrais) who made it possible that this library is accessible for gradle builds. See her [fork](https://github.com/elodieferrais/android-square-progressbar) for more information. Also check out her repository about [useful dependancies](https://github.com/elodieferrais/wonder-libraries).
