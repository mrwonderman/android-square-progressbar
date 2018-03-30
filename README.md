android-square-progressbar[ ![Download](https://api.bintray.com/packages/mrwonderman/maven/squareprogressbar/images/download.svg) ](https://bintray.com/mrwonderman/maven/squareprogressbar/_latestVersion)
==========================
![square image](https://vqbaiq-bn1306.files.1drv.com/y3mWYs9BuIe9N1T99aNPJ3OS0HEFXgJHCn96voCjTc0gUiysA7qbzPyLm0-2UiMdIkddCPIEX4uAXH7SHYa_pS8dm8M-S1Q0mkS_0wNhi3QPMb-A9d7-SzD_LIfdA5qyJdFX-9FrfjskYkkPf3jRUqg6MBmQnMRfOfaqY5i4bb6AZw?)
## First things first

This library is setup to work with the Android Studio and Gradle. If you're using the Eclipse environment then check out the legacy repository here: [android-square-progressbar-legacy](https://github.com/mrwonderman/android-square-progressbar-legacy).

You can find my blog post about the newest version here: [halcyon.ch - android-square-progressbar v.1.6.0](http://www.halcyon.ch/android-square-progressbar-v-1-6-0/), also check out the post about the previous major 1.5.0 version [here](http://www.halcyon.ch/android-square-progressbar-v-1-5-0/).

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

| normal / default       | rounded corners           | show percent  | indeterminate|
| ------------- | ------------- | ----- | ----- |
|![](https://whxvpq.bn1303.livefilestore.com/y4mbpv6GEOuDrqEaDIkV_bo7t49qpQcERn5YXsEHf9owXaomI--3m5Zx0E5go4ZZIhpz32hnPNne4J7N55qK4sNbCaBY71aVgJ7aaXJYR6pZU-P5iFhLHukKQYgfJKJZacUNUvBcehqVWrnZzQza2V287yPOvxKbflYn3pt4NOFmiQ3ktvT0Z0i_EYWvofzyWwM8xhYPrxeEvNXYANpUmbu3Q?width=200&height=128&cropmode=none)| ![](https://v3xvpq.bn1303.livefilestore.com/y4m4_lOK4OqKikGze8eqQSvlGsSmkKY96VaJWSVnmnkB-QE_oXIYiO4g1GsvojMJa6Cps6CzwocZpuBmCrKkdZiG7HfZ5xOJWZT94NJY8-2uZUmGI9Vehjmd3daTEFeN3rFVF8loYR0MZS5NfcdYH3pTKs2NXtmJq5jftOYVcHLFTnxvPKbsGW1V1gB_yqI7BNDqCYSpQmQOt-dOkcR1SnSrQ?width=200&height=128&cropmode=none)| ![](https://wnxvpq.bn1303.livefilestore.com/y4mY2mdqL2fEDeHd6-qmZVC2P8CXIFETcT_1nXw8ZCTLCJjoNwjFW6_ToAruJ22d_jto0P4LuHL0DIa152e9rJ0Q_SXqmJrqq9oghuYSBwEPEQIWDBHBahX2i0tH5NgW3bE--WKnzq5gtIFuje4_9Fzu4dtyCE9ni7Nnf4UO10pC3WrftTfjWkGFsl0Irp4cARQ1f-I6ET1FinisByPKodMCg?width=200&height=128&cropmode=none)| ![](https://wxxvpq.bn1303.livefilestore.com/y4mbhN1r2hpo6TSZYGMMvTrlDz2Xua214WHLAVkJJwEYGhpeMZ4JzPUrZnnbn3wBUSNSIzw6BP5Z2pvYbtTkK3Sm-pesy-C4pOiSO4EQvbLtG8bhGVUej7CcgIw10p6XGiAw4r5nWQApzuZZ4xkcVWLI0ku4pJijdu2eE74i5rKmyXI5Uei_e_dvW4rsaYjZs8zqc5QoScOTDQhSN2dXbly6g?width=200&height=128&cropmode=none)
 |        | `setRoundedCorners(true)`          | `showProgress(true)` |  `drawOutline(true)`    |     
|        |           | `setOpacity(true)` |  `setIndeterminate(true)`    |

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
        implementation 'ch.halcyon:squareprogressbar:1.6.4'
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

    SquareProgressBar squareProgressBar = findViewById(R.id.sprogressbar);
    squareProgressBar.setImage(R.drawable.example);
    squareProgressBar.setProgress(50.0);

Now you can make the squareprogressbar as fancy as you like. Check the [usage page](https://github.com/mrwonderman/android-square-progressbar/wiki/Usage) for all the different possiblities.
