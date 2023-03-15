package tests.wikipedia;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.MobileTestBase;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

@Owner("AntonovDenis")
@Tag("android")
@Story("Навигация по меню")
@Feature("Навигационное меню")
public class WikipediaNavBarTests extends MobileTestBase {

    @BeforeEach
    void searchTest() {
        back();
        step("Набрать в поисковой строке Python", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Python");
        });
        step("Открыть первую статью из списка", () ->
                $(id("org.wikipedia.alpha:id/page_list_item_title")).click());
        step("Нажать кнопку 'More options' для отображения навигационного меню", () ->
                $(accessibilityId("More options")).click());
    }

    @Test
    void checkNavBarMenuShareButtonTest() {
        step("Нажать кнопку меню 'Share'", () ->
                $(id("org.wikipedia.alpha:id/page_share")).click());
        step("Проверка наличия опций меню 'Share'", () ->
        $(id("android:id/text1")).shouldHave(text("Nearby Share")));
    }

    @Test
    void checkNavBarMenuEditHistoryTest() {
        step("Нажать кнопку меню 'Edit history'", () ->
                $(id("org.wikipedia.alpha:id/page_view_edit_history")).click());
        step("Проверка текста в открывшемся окне", () ->
                $(id("org.wikipedia.alpha:id/editCountsView")).shouldHave(text("since 2004")));
    }

    @Test
    void checkNavBarMenuCategoriesSubmenuTest() {
        step("Нажать кнопку меню 'Categories'", () ->
                $(id("org.wikipedia.alpha:id/page_categories")).click());
        step("Проверка заголовка меню 'Categories'", () ->
                $(id("org.wikipedia.alpha:id/categories_dialog_title")).should(text("Categories")));
        step("Проверка элементов меню 'Categories'", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(texts("Disambiguation pages",
                        "Human name disambiguation pages", "Disambiguation pages with given-name-holder lists")));
    }

    @Test
    void checkNavBarMenuTalkPageElementTest() {
        step("Нажать кнопку меню 'Talk page'", () ->
                $(id("org.wikipedia.alpha:id/page_view_talk_page")).click());
        step("Проверка заголовка страницы", () ->
                $(id("org.wikipedia.alpha:id/toolbarTitle")).should(text("Talk: Python")));
    }
}
