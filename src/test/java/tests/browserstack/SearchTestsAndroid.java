package tests.browserstack;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

public class SearchTestsAndroid extends AndroidTestBase {

//    @Tag("android")
//    @Test
//    void searchBrowserstackTest() {
//        step("Type search", () -> {
//            $(accessibilityId("Search Wikipedia")).click();
//            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
//        });
//        step("Verify content found", () ->
//                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
//                        .shouldHave(sizeGreaterThan(0)));
//    }

    @Tag("android")
    @Test
    void searchPythonTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Python");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}
