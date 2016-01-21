# cordova-plugin-device-ad-identifier
This is a simple Cordova plugin retrieve a device's Ad Identifier.  Supports: Android & iOS




## Install ##

You can add the plugin to your Cordova project from this repository:

	cordova plugin add https://github.com/kurtisf/cordova-plugin-ad-identifier


## Setup ##

None!  Just add the plugin and that’s it!

## Usage ##

Example use:

```
deviceAdIdentifier.getUserInfo((data: any) => {
    var id = data.adId;
    var optedOut = data.optedOut;
});
```
