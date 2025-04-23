package tests.github;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Selenide.*;
//import static java.nio.channels.SocketChannel.open;




public class SelenideRepositorySearch {


    @Test
    void shouldFindSelenideRepositoryAtTheTop() {

        // открыть главную страницу
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденных
        sleep(5000);
        $$("div.search-title").first().click();
        //$$("[data-testid='results-list']").first().click(); не рабочее
        // проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        sleep(10000);
    }

    // структура теста
    // ARRANGE подготовить
    // ACT действия
    // ACT
    // ASSERT промежуточная проверка
    // ACT
    // ASSERT проверка

    //private void open(String url) {

    //}
}
