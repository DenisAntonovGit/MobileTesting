package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.MobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static helpers.Attach.getSessionId;

public class MobileTestBase {
    public static String runSetUp = System.getProperty("runSetUp");

    @BeforeAll
    static void beforeAll() {
        if (runSetUp == null) {
            runSetUp = "local";
        }
        switch (runSetUp) {
            case "remote":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "local":
                Configuration.browser = MobileDriver.class.getName();
                break;
        }

        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 20000;
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = getSessionId();
        Attach.pageSource();
        closeWebDriver();
        if ("remote".equals(runSetUp)) {
            Attach.addVideo(sessionId);
        }
    }
}
