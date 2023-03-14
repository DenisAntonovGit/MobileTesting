package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"
})
public interface DeviceConfig extends Config {

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();

    @Key("appURL")
    String getAppUrl();

    @Key("baseURL")
    URL getBaseUrl();

    @Key("deviceName")
    String getDeviceName();

    @Key("osVersion")
    String getDeviceVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();

    @Key("mobilePlatformName")
    String getMobilePlatformName();

    @Key("mobile.url")
    String mobileUrl();

}
