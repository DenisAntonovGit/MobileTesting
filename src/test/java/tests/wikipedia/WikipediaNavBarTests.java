package tests.wikipedia;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.MobileTestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

@Owner("AntonovDenis")
public class WikipediaNavBarTests extends MobileTestBase {

    @Tag("android")
    @BeforeEach
    void searchTest() {
        back();
        step("Набрать в поисковой строке Python", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Python");
        });
        step("Открыть первую статью", () ->
                $(id("org.wikipedia.alpha:id/page_list_item_title")).click());
        step("Нажать кнопку 'More options' для отображения навигационного меню", () ->
                $(accessibilityId("More options")).click());
    }

    @Test
    void checkNavBarMenusShareButtonTest() {
        step("Tap NavBar menu button: Share", () ->
                $(id("org.wikipedia.alpha:id/page_share")).click());
        $$(id("android:id/text1")).shouldHave(texts("Nearby Share", "Android Beam",
                "Bluetooth", "Copy to clipboard", "Gmail", "Messages",
                "News Feed", "Save to Drive", "Your groups", "Your groups"));
    }

    @Test
    void checkNavBarMenusRevisionHistoryTest() {
        step("Tap NavBar menu button: Revision history", () ->
                $(id("org.wikipedia.alpha:id/page_view_edit_history")).click());
        step("Check Revision history pages Title", () ->
                $(id("org.wikipedia.alpha:id/articleTitleView")).should(text("Revision history: Python")));
    }

    @Test
    void checkNavBarMenusCategoriesSubmenuTest() {
        step("Tap NavBar menu button: Categories", () ->
                $(id("org.wikipedia.alpha:id/page_categories")).click());
        step("Check Categories меню Title", () ->
                $(id("org.wikipedia.alpha:id/categories_dialog_title")).should(text("Categories")));
        step("Check Categories menu elements", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(texts("Web development software",
                        "Load testing tools", "Unit testing frameworks","Graphical user interface testing")));
    }
}
