#import "CDVDeviceAdIdentifier.h"
#import <Cordova/CDV.h>
#import <AdSupport/AdSupport.h>

@implementation CDVDeviceAdIdentifierPlugin

- (void)getUserInfo:(CDVInvokedUrlCommand*)command
{

    [self.commandDelegate runInBackground:^{

        NSString *IDFA;
        bool optedOut = NO;

        if ([[ASIdentifierManager sharedManager] isAdvertisingTrackingEnabled])
        {
           IDFA = [[[ASIdentifierManager sharedManager] advertisingIdentifier] UUIDString];
        }
        else 
        {
           optedOut = YES;
        }

        NSMutableDictionary *resultDictionary = [NSMutableDictionary dictionary];
        [resultDictionary setObject:IDFA forKey:@"adId"];
        [resultDictionary setObject:[NSNumber numberWithBool:optedOut] forKey:@"optedOut"];
        
        CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK
                                                      messageAsDictionary:resultDictionary];
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }];
}

@end


