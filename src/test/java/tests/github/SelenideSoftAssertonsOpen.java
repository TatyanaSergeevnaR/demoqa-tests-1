package tests.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSoftAssertonsOpen {

    @BeforeAll
    static void beforeALL() {
        Configuration.browserSize = "1920x1080";
        //Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = Boolean.parseBoolean("true");
        Configuration.timeout = Long.parseLong("5000"); // default 4000
    }

    @Test
    void softAssertionsOpenAndHaveJUnit5(){

        // Открыть страницу Selenide в Github
        open("https://github.com/search?q=selenide&type=repositories");
        // Перейти в раздел Wiki проекта/
        $("[id=\":ra:--label\"]").shouldHave(text("More")).click();
        //$(byText("More")).click();
        $("[data-testid=\"nav-item-wikis\"]").shouldHave(text("Wikis")).click();
        //$(byText("Wikis")).click();
        //sleep(10000);
        // Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("[data-testid=\"results-list\"]").shouldHave(text("SoftAssertions"));
        // Открыть страницу SoftAssertions
        $(byText("SoftAssertions")).shouldBe(Condition.visible).click();
        sleep(10000);
        // Проверить что внутри есть пример кода для JUnit5
        switchTo().window(1);
        $(".markdown-body").shouldHave(text("""
                        @ExtendWith({SoftAssertsExtension.class})
                        class Tests {
                          @Test
                          void test() {
                            Configuration.assertionMode = SOFT;
                            open("page.html");
                        
                            $("#first").should(visible).click();
                            $("#second").should(visible).click();
                          }
                        }"""));


    }
}
