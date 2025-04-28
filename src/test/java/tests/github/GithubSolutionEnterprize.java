package tests.github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSolutionEnterprize {

    @Test
    void githubSolutionEnterprize() {

        // открыть гитхаб
        open("https://github.com");
        // на главной странице выбрать меню Solutions (с помощью команды hover для Solutions)
        $("div.HeaderMenu-wrapper").$(byText("Solutions")).hover();
        // перейти на Enterprize
        $(withTagAndText("a", "Enterprise")).click();
        // убедиться что загрузилась нужная страница (например, что заголовок: "The AI-powered developer platform.")
        $("#hero-section-brand-heading").shouldHave(text("he AI-powered developer platform"));

    }
}
