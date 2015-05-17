android-square-progressbar[ ![Download](https://api.bintray.com/packages/mrwonderman/maven/squareprogressbar/images/download.svg) ](https://bintray.com/mrwonderman/maven/squareprogressbar/_latestVersion)
==========================
![square image](https://oavhhw.bn1.livefilestore.com/y2mOYieeVxCoUj5JwuoeHt302BrP4iKC3qeFV1gUkWh7Xjm5ie5ZjANjekofpakTTMZb6-m3gwnx1SauhMo87D9VVh4MVEDW-0Tpq47-liKfLF-lpNNAoTTYCSVUJcjz4dB/header140.png?psid=1)
## First things first

This library is setup to work with the Android Studio and Gradle. If you're using the Eclipse environment then check out the legacy repository here: [android-square-progressbar-legacy](https://github.com/mrwonderman/android-square-progressbar-legacy). 

You can find my blog post about the newest version here: [halcyon.ch - android-square-progressbar v.1.5.0] (http://www.halcyon.ch/android-square-progressbar-v-1-5-0/), also check out the post about the previous major 1.4.0 version [here](http://www.halcyon.ch/android-square-progressbar-v-1-4-0/).

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

![three examples](https://mavhhw-bn1306.files.1drv.com/y2p8nsn055K0X1rf95rWCcCuhokX4QE5B19SPohltQ758atQ9HcV2iK3K_w802Weg6hyMpbLPwpWGEGob8_z_brVQSnLW-PfNCw2tUNa2g-Y0xk4By4LjJ1nVOtE9JzjW7S_bQqlH3yfhezy8GdjtMKqznX2HjtF8461cEe69KS-oQ/cover_github.png)

There are some further examples available here (with code) : [Examples](https://github.com/mrwonderman/android-square-progressbar/wiki/Examples)
### How to use it? / How to install? / How to contribute?
Check the wiki for more information about [how to use](https://github.com/mrwonderman/android-square-progressbar/wiki/Usage), [how to install](https://github.com/mrwonderman/android-square-progressbar/wiki/Use-with-an-Eclipse-Setup) or [how to contribute](https://github.com/mrwonderman/android-square-progressbar/wiki/How-To-Contribute).

If you have questions about the code or if you need some help, you can try the [Gitter-Group](https://gitter.im/mrwonderman/android-square-progressbar).

## Gradle
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
        compile 'ch.halcyon:squareprogressbar:1.5.2'
    }
