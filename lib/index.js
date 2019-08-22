
import { NativeModules } from 'react-native';

const { RNBugly } = NativeModules;


class BuglyConfig {

    /** SDK Debug信息开关, 默认关闭*/
    debugMode;

    /** 设置自定义渠道标识*/
    channel;

    /** 设置自定义版本号*/
    version;

    /** 设置自定义设备唯一标识*/
    deviceIdentifier;

    /** 卡顿监控开关，默认关闭*/
    blockMonitorEnable;

    /** 卡顿监控判断间隔，单位为秒*/
    blockMonitorTimeout;

    /** 控制台日志上报开关，默认开启*/
    consolelogEnable;
}


export default class Bugly {

    /**
     *  初始化Bugly,使用默认BuglyConfig
     *  @param appId 注册Bugly分配的应用唯一标识
     *  @param config 传入配置的 BuglyConfig
     */
    static startWithAppId(appId, config) {
        return RNBugly.startWithAppId(appId, config);
    }


    /**
     *  设置用户标识
     *  @param userId 用户标识
     */
    static setUserIdentifier(userId) {
        return RNBugly.setUserIdentifier(userId);
    }


    /**
     *  更新版本信息
     *  @param version 应用版本信息
     */
    static updateAppVersion(version) {
        return RNBugly.updateAppVersion(version);
    }


    /**
     * 设置关键数据，随崩溃信息上报
     * @param value
     * @param key
     */
    static setUserValue(value, key) {
        return RNBugly.setUserValue(value, key);
    }


    /**
     *  设置标签
     *  @param tag 标签ID，可在网站生成
     */
    static setTag(tag) {
        return RNBugly.setTag(tag);
    }
};
