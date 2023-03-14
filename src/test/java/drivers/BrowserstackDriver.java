package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.DeviceConfig;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;

public class BrowserstackDriver implements WebDriverProvider {

    static DeviceConfig config = ConfigFactory.create(DeviceConfig.class);

    @SneakyThrows
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user", config.getLogin());
        mutableCapabilities.setCapability("browserstack.key", config.getPassword());
        mutableCapabilities.setCapability("app", config.getAppUrl());
        mutableCapabilities.setCapability("device", config.getDeviceName());
        mutableCapabilities.setCapability("os_version", config.getDeviceVersion());
        mutableCapabilities.setCapability("project", config.projectName());
        mutableCapabilities.setCapability("build", config.buildName());
        mutableCapabilities.setCapability("name", config.testName());
        return new RemoteWebDriver(config.getBaseUrl(), mutableCapabilities);
    }
}