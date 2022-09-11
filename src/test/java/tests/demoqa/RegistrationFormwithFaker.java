package tests.demoqa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationFormwithFaker extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData2 testdata2 = new TestData2();

    @BeforeEach
    void setup(){
        testdata2.prepareTestData();
    }

    @Test
    void fillregistrationformtest() {
        step("Open registrations form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill the registration form", () -> {
                registrationFormPage.setFirstName(testdata2.firstName)
                .setLastName(testdata2.lastName)
                .setEmail(testdata2.userEmail)
                .setGender(testdata2.gender)
                .setNumber(testdata2.userNumber)
                .setBirthdate(testdata2.day, testdata2.month, testdata2.year)
                .uploadPic(testdata2.userPic)
                .setSubject(testdata2.subject)
                .setHobby(testdata2.hobby)
                .setAddress(testdata2.userAddress)
                .setCityState(testdata2.city, testdata2.state)
                .submit();
        });

        step("Check results", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", testdata2.firstName + " " + testdata2.lastName)
                    .checkResult("Student Email", testdata2.userEmail)
                    .checkResult("Date of Birth", testdata2.day + " " + testdata2.month + "," + testdata2.year)
                    .checkResult("Gender", testdata2.gender)
                    .checkResult("Mobile", testdata2.userNumber)
                    .checkResult("Subjects", testdata2.subject)
                    .checkResult("Hobbies", testdata2.hobby)
                    .checkResult("Picture", testdata2.userPic)
                    .checkResult("Address", testdata2.userAddress)
                    .checkResult("State and City", testdata2.city + " " + testdata2.state);
        });
    }
}