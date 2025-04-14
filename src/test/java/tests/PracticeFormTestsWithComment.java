package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

// page_url=https://demoqa.com/automation-practice-form

public class PracticeFormTestsWithComment {

    @BeforeAll
    static void beforeALL() {
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = Boolean.parseBoolean("true");
        Configuration.timeout = Long.parseLong("5000"); // default 4000
    }

    @Test
    void fillFormTest1() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("test@test.com");
//        $("#gender-radio-3").click(); // плохо
//       $("#gender-radio-3").parent().click(); // хорошо
//       $(byText("Other")).click(); // лучше не надо, сомнительно но окей
//       $("[for=\"gender-radio-3\"]").click(); // сама, хороший вариант
        $("#genterWrapper").$(byText("Other")).click(); // лучший вариант из разбора
        $("#userNumber").setValue("79999999999");
        $("#dateOfBirthInput").click();
//        $("[aria-label=\"Choose Wednesday, March 26th, 2025\"]").click(); // сама, так делать не надо сработает только в текущем месяце и годе
//        $(".react-datepicker__month-select").selectOptionByValue("2"); // тоже работает но менее читаемо
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("2007");
//        $("[aria-label=\"Choose Sunday, March 25th, 2007\"]").click(); // сама, так работает но почему-то сказали делать иначе
        $(".react-datepicker__day--025:not(.react-datepicker__day--outside-month)").click(); // тут мы выбираем селектор 25 числа текущего месяца и отменяем селектор 25 числа предыдущего месяца, т.к. на календаре число 25 повторяется 2 раза 25 февраля и 25 марта.
//        $("#subjectsInput").setValue("p"); // так работает но усложняет
//        $("#react-select-2-option-0").click(); // так работает но усложняет
        $("#subjectsInput").setValue("Physics").pressEnter(); // лучший вариант из разбора
//        $("[for=\"hobbies-checkbox-3\"]").click(); // сама, работает
        $("#hobbiesWrapper").$(byText("Music")).click(); // лучший вариант из разбора
        $("#uploadPicture").uploadFromClasspath("IMG/wr-750.webp");
        $("#currentAddress").setValue("Test street 1");
        $("#state").scrollIntoView(true).click();
//        $("#react-select-3-option-0").click(); сама , хорошо но менее читаемо
        $("#stateCity-wrapper").$(byText("NCR")).click(); // лучший вариант из разбора
        $("#city").click();
//        $("#react-select-4-option-1").click(); // сама , хорошо но менее читаемо
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear); // проверка на то что элемент появился
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name"), text("Ivan Ivanov"),
                text("Student Email"), text("test@test.com")); // потом покажет как работать с таблицей правильно

    }
}
