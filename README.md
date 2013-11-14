GifAnimationDrawable
==============

GifAnimationDrawable is a simple library (consisting of 2 classes) that makes it easy to display animated GIFs on the Android platform by converting the animated GIF file into an AnimationDrawable. This allows animated gifs to be used anywhere a Drawable is accepted, including backgrounds, standard ImageViews and anywhere else. For more detail, see http://engineering.hipmob.com/2013/12/03/GifAnimationDrawable-for-Android/

Animated GIFs are a simple way to make animations and are supported on Android using the Movie class: unfortunately the Movie class isn't quite as easy to use in many places as one might like. GifAnimationDrawable makes it trivial to use an animated gif as a standard Android Drawable, for backgrounds on buttons or views or as the main image in an ImageView. Solutions (such as [this][1]) require build-time processing, which isn't usable with downloaded images.

Enter [http://droid-blog.net/2011/10/15/tutorial-how-to-play-animated-gifs-in-android-%E2%80%93-part-2/][2]: this provides the key bit, the GifDecoder class that pulls out the individual frames. All that was missing was the final step, wrapping this in an AnimationDrawable instance.

And...we're done. See how to use it below.

How
===
Simply pass the image File or InputStream into the appropriate constructor:

```java
AnimationDrawable drawable = new GifAnimationDrawable(File source);
```

or

```java
AnimationDrawable drawable = new GifAnimationDrawable(InputStream source);
```

By default a <code>Thread</code> will be created to process the GIF frames (making the default operation safe to use on the main Android app thread): you can call the <code>isDecoded</code> method to be informed when the processing is complete. If you're loading this in an existing AsyncTask or other background thread, you can pass in a parameter to tell it to process the frames without spawning a new thread:

```java
AnimationDrawable drawable = new GifAnimationDrawable(File source, true);
```

or

```java
AnimationDrawable drawable = new GifAnimationDrawable(InputStream source, true);
```

Build
=====
The library build uses **ant**: you will need to have the ANDROID_SDK environment variable setup (or edit the ***build.xml*** file to point to the right place).

Open a shell in the ***library*** directory and run **ant**. The JAR file produced (***gifanimationdrawable.jar***) will contain the required files: add it to your Android app's **libs** folder, and then import the <code>com.hipmob.gifanimationdrawable.GifAnimationDrawable</code> class.

Notes
=====
* We stood on the shoulders of giants here: the GifDecoder we use is based on the original source at http://code.google.com/p/animated-gifs-in-android/. We added code to defer processing of all frames other than the first till a later time (so we could run that in a separate thread). 
* Our sample animations (used in the sample app) come from http://www.animationfactory.com/en/samples.html.

Author
======
Developed by Femi Omojola (femi@hipmob.com) for Orthogonal Labs, Inc. (https://hipmob.com).

[1]: http://commonsware.com/blog/2013/10/01/converting-animated-gifs-animationdrawables.html
[2]: http://droid-blog.net/2011/10/15/tutorial-how-to-play-animated-gifs-in-android-%E2%80%93-part-2/