package tests.github;

import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.module.Configuration.*;

public class BestContributorSelenide {

    @Test
    void andreiSolntsevShouldBeTheFirstContributor(){
        //browserSize="800x400"; селенид скролит сам вне зависимости от расшиения экрана но не в каждом браузере
        //browser="firefox"; можно поиграться но браузеры настраиваются потом в программе запуска автотестов а не в коде
        // открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");
        // подвести мышку к первому аватару из блока contributors
        $("div.Layout-sidebar").$(byText("Contributors"))
                .closest(".BorderGrid-cell").$$("ul li").first().hover();
                //.closest("h2").sibling(0).$$("li").first().hover(); вариант 2
        //sleep(10000);
        // проверка: во всплывающем окне есть текст Andrei Solntsev
        //$$(".Popover").findBy(visible).shouldHave(text("Andrei Solntsev")); так можно искать когда локатор не один а несколько и мы находим видимый(работает только в случае если один из локаторов видимый и он тот который нам нужен)
        $(".Popover").shouldHave(text("Andrei Solntsev"));

        //screenshot("ffsd"); так можно делать скриншот, требуется, например, если есть ошибка.
    }

}
