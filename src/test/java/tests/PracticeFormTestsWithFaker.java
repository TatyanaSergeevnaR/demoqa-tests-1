package tests;

import com.github.javafaker.Faker;
import datainput.TestDataFaker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static datainput.TestData.firstName;


public class PracticeFormTestsWithFaker extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();
    TestDataFaker testDataFaker = new TestDataFaker();

    @Test
    void fillFormTestFull() {
        registrationPage
                .openPage()
                .setFirstName(testDataFaker.firstName)
                .setLastName(testDataFaker.lastName)
                .setUserEmail(testDataFaker.userEmail)
                .setGenter(testDataFaker.genter)
                .setUserNumber(testDataFaker.userNumber)
                .setDateOfBirth(testDataFaker.dayOfBirth, testDataFaker.monthOfBirth, testDataFaker.yearOfBirth)
                .setSubjects(testDataFaker.subject)
                .setHobbies(testDataFaker.hobbies)
                .setPicture("IMG/wr-750.webp")
                .setAddress(testDataFaker.streetAddress, testDataFaker.state, testDataFaker.city)
                .clickButtonSubmit()

                .checkResultTitle("Thanks for submitting the form")
                .checkResult("Student Name", testDataFaker.firstName + " " + testDataFaker.lastName)
                .checkResult("Student Email", testDataFaker.userEmail)
                .checkResult("Gender", testDataFaker.genter)
                .checkResult("Mobile", testDataFaker.userNumber)
                .checkResult("Date of Birth", testDataFaker.dayOfBirth + " " + testDataFaker.monthOfBirth + ","  + testDataFaker.yearOfBirth)
                .checkResult("Subjects", testDataFaker.subject)
                .checkResult("Hobbies", testDataFaker.hobbies)
                .checkResult("Picture", "wr-750.webp")
                .checkResult("Address", testDataFaker.streetAddress)
                .checkResult("State and City", testDataFaker.state + " " + testDataFaker.city);

    }

}