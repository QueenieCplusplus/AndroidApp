# PlayStoreConsole
upload app

https://support.google.com/googleplay/android-developer/answer/113469?hl=en

# Pack app in apk File

Before you submit your application to either app store, you need to "package" it appropriately.The Android Google Play store will ask you for a .apk ("Android Application Package") file.

When you create an apk file, you're essentially creating a bundle of all of the necessary information that App store needs in order to process and run your application.

Note that these will take anywhere from 10-20 minutes to build, so you'll need to be patient. Eventually after building that will give you a URL where you can go to download either your .apk files.

# apk

APK files are a type of archive file, specifically in zip format-type packages, based on the JAR file format, with .apk as the filename extension. 

The MIME type associated with APK files is application/vnd.android.package-archive.

APK files can be installed on Android-powered devices just like installing software on a PC. 

When a user downloads an Android app using an android device, from an official source (such as the Google Play Store), it is automatically installed. 

# side-loading

The APK files can also be downloaded from the Google Play Store without installation, using a non-android device either through a Chrome or Firefox extension or directly from unofficial sites Several Android apps can be used for the process of moving APK files between different devices is known also called APK sideloading. 

Such apps include android file manager apps, app orientation apps, ... The installation of APK files outside of Google Play is disabled by default. Users can install unknown APK files by enabling "Unknown sources" from "Accounts and Security" in Settings.

# adb, android debug bridge communication

A user or developer can also install an APK file directly to a device (that is, not via download from the network) from a desktop computer, using a communication program such as adb.

# Contents

      AndroidManifest.xml
      Meta-info
          Manifest.mf
          Cert.rsa
          Cert.sf
      classes.dex (binary)
      libs
      res (uncompiled resources)
      assets (retrieved by AssetManager)
      resources.arsc (binary xml)

