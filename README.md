android-square-progressbar[ ![Download](https://api.bintray.com/packages/mrwonderman/maven/squareprogressbar/images/download.svg) ](https://bintray.com/mrwonderman/maven/squareprogressbar/_latestVersion)
==========================
![square image](https://vqbaiq-bn1306.files.1drv.com/y3mWYs9BuIe9N1T99aNPJ3OS0HEFXgJHCn96voCjTc0gUiysA7qbzPyLm0-2UiMdIkddCPIEX4uAXH7SHYa_pS8dm8M-S1Q0mkS_0wNhi3QPMb-A9d7-SzD_LIfdA5qyJdFX-9FrfjskYkkPf3jRUqg6MBmQnMRfOfaqY5i4bb6AZw?)
## First things first2

This library is setup to work with the Android Studio and Gradle. If you're using the Eclipse environment then check out the legacy repository here: [android-square-progressbar-legacy](https://github.com/mrwonderman/android-square-progressbar-legacy).

You can find my blog post about the newest version here: [halcyon.ch - android-square-progressbar v.1.6.0] (http://www.halcyon.ch/android-square-progressbar-v-1-6-0/), also check out the post about the previous major 1.5.0 version [here](http://www.halcyon.ch/android-square-progressbar-v-1-5-0/).

The example application is available at the play store:

<a href="https://play.google.com/store/apps/details?id=ch.halcyon.squareprogressbar.example">
  <img alt="Get it on Google Play"
       src="https://developer.android.com/images/brand/en_generic_rgb_wo_60.png" />
</a>

[![Join the chat at https://gitter.im/mrwonderman/android-square-progressbar](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/mrwonderman/android-square-progressbar?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

## General idea
Sometimes you don't have enough space in your layout to display a wide progressbar. So this library gives you a complete new possibility to display a progress. You can simply show a progressbar around an image. And this progressbar can be configured in a lot of different ways, like colour, outline, display of the percentage and so on.

### Examples
Here are some examples of how these progressbars could look like:

![three examples](https://mkvhhw-bn1306.files.1drv.com/y3mag8UNO58wTkAUn8chyoNMmTBwW2_Ztyl3IOVn2K6Dd0AEpd6Cxu2nhdWLv-IoK84cxSAf3UuwHjFhByCW8XgjqG_qui6wUv5G5D26r66e14Jf6gAQQ-X42L7pskGov4P_mDY7ZqztaZ4aVYwZ1sR_u8aIStkjMNen-14D7IKdK0?)

There are some further examples available here (with code) : [Examples](https://github.com/mrwonderman/android-square-progressbar/wiki/Examples)
### How to use it? / How to install? / How to contribute?
Check the wiki for more information about [how to use](https://github.com/mrwonderman/android-square-progressbar/wiki/Usage), [how to install](https://github.com/mrwonderman/android-square-progressbar/wiki/Use-with-an-Eclipse-Setup) or [how to contribute](https://github.com/mrwonderman/android-square-progressbar/wiki/How-To-Contribute).

If you have questions about the code or if you need some help, you can try the [Gitter-Group](https://gitter.im/mrwonderman/android-square-progressbar).

## Usage
### Gradle
This library now works with gradle and will soon be available on the central maven repository. For the moment its on jCenter at [Bintray](https://bintray.com/mrwonderman/maven/squareprogressbar/view). Just add the following repository to your root build.gradle:

    allprojects {
        repositories {
            jcenter()
            maven { url "https://jcenter.bintray.com" }
        }
    }

Then in your app build.gradle:

    dependencies {
        // other repos ...
        compile 'ch.halcyon:squareprogressbar:1.6.0'
    }

### Code
After adding the gradle depedency from above you can go to your xml layout and add the following code for a squareprogressbar:

    <ch.halcyon.squareprogressbar.SquareProgressBar
        android:id="@+id/sprogressbar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:paddingTop="20dp" >
    </ch.halcyon.squareprogressbar.SquareProgressBar>

To set some basic settings use the following java-code:

    SquareProgressBar squareProgressBar = (SquareProgressBar) rootView.findViewById(R.id.sprogressbar);
    squareProgressBar.setImage(R.drawable.example);
    squareProgressBar.setProgress(50.0);

Now you can make the squareprogressbar as fancy as you like. Check the [usage page](https://github.com/mrwonderman/android-square-progressbar/wiki/Usage) for all the different possiblities.
