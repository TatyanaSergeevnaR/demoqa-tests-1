package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

// page_url=https://demoqa.com/automation-practice-form

public class PracticeFormWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage
                .openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setUserEmail("test@test.com")
                .setGenter("Other")
                .setUserNumber("79999999999")
                .setDateOfBirth( "25", "March", "2007")
                .setSubjects("Physics")
                .setHobbies("Music")
                .setPicture("IMG/wr-750.webp")
                .setAddress("Test street 1", "NCR", "Delhi")
                .clickButtonSubmit()

                .checkResultTitle("Thanks for submitting the form")
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "test@test.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "7999999999")
                .checkResult("Date of Birth", "25 March,2007")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "wr-750.webp")
                .checkResult("Address", "Test street 1")
                .checkResult("State and City", "NCR Delhi");

    }
}
