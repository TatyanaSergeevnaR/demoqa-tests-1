package Test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

// page_url=https://demoqa.com/automation-practice-form

public class PracticeFormTests {

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("test@test.com");
        $("#gender-radio-3").click();
        $("#userNumber").setValue("79999999999");
        $("#dateOfBirthInput").click();
        $("[aria-label=\"Choose Wednesday, March 26th, 2025\"]").click();
        $("#subjectsInput").setValue("p");
        $("#react-select-2-option-0").click();
        $("#hobbies-checkbox-3").click();
        $("#uploadPicture").uploadFromClasspath("src/test/resources/IMG/wr-750.webp");
        $("#currentAddress").setValue("Test street 1");
        $("#stateCity-label").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        $("[id=search]").shouldHave(text("https://selenide.org"));
    }
}
