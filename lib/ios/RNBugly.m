
#import "RNBugly.h"
#import "Bugly.h"
#import "BuglyConfig.h"

@implementation RNBugly

RCT_EXPORT_MODULE()

/** 初始化*/
RCT_EXPORT_METHOD(startWithAppId:(NSString *)appId buglyConfig:(NSDictionary *)buglyConfig) {
    if (buglyConfig) {
        BuglyConfig *config = [BuglyConfig new];
        config.debugMode = buglyConfig[@"debugMode"];
        config.channel = buglyConfig[@"channel"];
        config.version = buglyConfig[@"version"];
        config.deviceIdentifier = buglyConfig[@"deviceIdentifier"];
        config.blockMonitorEnable = buglyConfig[@"blockMonitorEnable"];
        config.blockMonitorTimeout = [buglyConfig[@"blockMonitorTimeout"] doubleValue];
        config.consolelogEnable = buglyConfig[@"consolelogEnable"];
        [Bugly startWithAppId:appId config:config];
    } else {
        [Bugly startWithAppId:appId];
    }
}

/** 设置用户标识*/
RCT_EXPORT_METHOD(setUserIdentifier:(NSString *)userId) {
    [Bugly setUserIdentifier:userId];
}

/** 更新版本信息*/
RCT_EXPORT_METHOD(updateAppVersion:(NSString *)version) {
    [Bugly updateAppVersion:version];
}

/** 设置关键数据，随崩溃信息上报*/
RCT_EXPORT_METHOD(setUserValue:(NSString *)value forKey:(NSString *)key) {
    [Bugly setUserValue:value forKey:key];
}

/** 设置标签*/
RCT_EXPORT_METHOD(setTag:(NSUInteger)tag) {
    [Bugly setTag:tag];
}

@end
  
