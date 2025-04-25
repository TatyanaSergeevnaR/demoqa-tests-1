package tests.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class dragAndDrop {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void dragAndDropAction(){
        // открыть страницу
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Перенести прямоугольник А на место В
        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();
        // Проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        // В Selenide есть команда $(element).dragAndDrop($(to-element)), проверить работает ли тест, если использовать её вместо actions()
    }

    @Test
    void dragAndDropSelenide(){
        // открыть страницу
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Перенести прямоугольник А на место В В Selenide есть команда $(element).dragAndDrop($(to-element)), проверить работает ли тест, если использовать её вместо actions()
        $("#column-a").dragAndDrop(to("#column-b"));
        // Проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}

