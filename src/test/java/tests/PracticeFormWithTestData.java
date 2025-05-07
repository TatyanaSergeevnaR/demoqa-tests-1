package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormWithTestData extends TestBase{

//    String firstName = "Ivan",
//            lastName = "Ivanov",
//            userEmail = "test@test.com";

//    public static final String firstName = "Ivan",
//            lastName = "Ivanov",
//            userEmail = "test@test.com";

//    static String
//            firstName,
//            lastName,
//            userEmail;

//    @BeforeEach
//    void prepareTestData() {
//            firstName = "Ivan";
//            lastName = "Ivanov";
//            userEmail = "test@test.com";
//    }

    @Test
    void fillFormTest() {
//        String firstName = "Ivan",
//                lastName = "Ivanov",
//                userEmail = "test@test.com";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("79999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("2007");
        $(".react-datepicker__day--025:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("IMG/wr-750.webp");
        $("#currentAddress").setValue("Test street 1");
        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name"), text(firstName), text(lastName),
                text("Student Email"), text(userEmail));

    }
}
