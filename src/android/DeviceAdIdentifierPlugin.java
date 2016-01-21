package com.DeviceAdIdentifier;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public class DeviceAdIdentifierPlugin extends CordovaPlugin {
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
        if (action.equals("getUserInfo")) {
            this.getUserInfo(callbackContext);
            return true;
        }
        return false;
    }
    
    private void getUserInfo(CallbackContext callbackContext) {
        
        try {
            // https://developers.google.com/android/reference/com/google/android/gms/ads/identifier/package-summary
            
            AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(this.cordova.getActivity());
            
            JSONObject data = new JSONObject();
            PluginResult result = null;
            
            if (info != null) {
                
                try {
                    data.put("adId", info.getId());
                    data.put("optedOut", info.isLimitAdTrackingEnabled());
                    //data.put("osVersion", android.os.Build.VERSION.RELEASE);
                    
                    result = new PluginResult(PluginResult.Status.OK, data);
                    
                } catch (JSONException e) {
                    
                    result = new PluginResult(PluginResult.Status.ERROR);
                }
            }
            else {
                
                result = new PluginResult(PluginResult.Status.ERROR);
            }
            
            result.setKeepCallback(true);
            callbackContext.sendPluginResult(result);
            
        }
        catch(final Exception e) {
            callbackContext.error("Error in DeviceAdIdentifier getUserInfo.");
        }
    }
}

