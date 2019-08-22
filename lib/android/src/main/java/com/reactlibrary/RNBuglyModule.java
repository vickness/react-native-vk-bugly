
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.tencent.bugly.crashreport.CrashReport;

public class RNBuglyModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNBuglyModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNBugly";
  }

  @ReactMethod
  public void startWithAppId(final String appId, final ReadableMap bugConfig) {
    if (bugConfig != null) {
      CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getReactApplicationContext());
      if (bugConfig.hasKey("channel")) strategy.setAppChannel(bugConfig.getString("channel"));
      if (bugConfig.hasKey("version")) strategy.setAppVersion(bugConfig.getString("version"));
      if (bugConfig.hasKey("deviceIdentifier")) strategy.setDeviceID(bugConfig.getString("deviceIdentifier"));
      if (bugConfig.hasKey("consolelogEnable")) strategy.setBuglyLogUpload(bugConfig.getBoolean("consolelogEnable"));
      CrashReport.initCrashReport(getReactApplicationContext(), appId, false, strategy);
    } else {
      CrashReport.initCrashReport(getReactApplicationContext(), appId, false);
    }
  }

  @ReactMethod
  public void setUserIdentifier(final String userId) {
    CrashReport.setUserId(userId);
  }

  @ReactMethod
  public void updateAppVersion(final String version) {
    CrashReport.setAppVersion(getReactApplicationContext(), version);
  }

  @ReactMethod
  public void setUserValue(final String value, final String key) {
    CrashReport.putUserData(getReactApplicationContext(), key, value);
  }

  @ReactMethod
  public void setTag(final Integer tag) {
    CrashReport.setUserSceneTag(getReactApplicationContext(), tag);
  }
}