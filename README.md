
# react-native-vk-bugly

## 安装

`yarn add react-native-vk-bugly`

`react-native link react-native-vk-bugly`


## 使用
```javascript
import Bugly from 'react-native-vk-bugly';

// 设置AppID
let buglyAppId = Platform.select({
  ios: "745756234534241",
  android: "34861783241672534"
});

// 配置参数
let buglyConfig = {
    
    /** SDK Debug信息开关, 默认关闭*/
        debugMode: false,
    
        /** 设置自定义渠道标识*/
        channel: 'react-native',
    
        /** 设置自定义版本号*/
        version: '1.0.0',
    
        /** 设置自定义设备唯一标识*/
        deviceIdentifier: 'abcdefg',
    
        /** 卡顿监控开关，默认关闭*/
        blockMonitorEnable: false,
    
        /** 卡顿监控判断间隔，单位为秒*/
        blockMonitorTimeout: 1,
    
        /** 控制台日志上报开关，默认开启*/
        consolelogEnable: false
    
};

// 初始化Bugly
Bugly.startWithAppId(buglyAppId, buglyConfig);

// 设置用户标识
Bugly.setUserIdentifier("userId");

// 更新版本信息
Bugly.updateAppVersion("1.0.0");

// 上传自定义信息
Bugly.setUserValue("value", "key");

// 设置标签
Bugly.setTag(123);

```
