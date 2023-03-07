package config;

import org.aeonbits.owner.Config;

import java.net.URL;
@Config.Sources({
    "classpath:remote.properties"
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
}
