package tests.demoqa;


import com.codeborne.selenide.SelenideElement;
import tests.demoqa.component.AddressComponent;
import tests.demoqa.component.CalendarComponent;
import tests.demoqa.component.ResultTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    //Components
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();

    private AddressComponent addressComponent = new AddressComponent();
    //Elements

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");

    //Actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthdate(String day, String month, String year) {
        $("#dateOfBirthInput").scrollIntoView(true).click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage uploadPic(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationFormPage setCityState(String state, String city) {
        addressComponent.setCity(state, city);

        return this;
    }

    public RegistrationFormPage submit() {
        $("#submit").scrollTo().pressEnter();

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultTableComponent.isVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);

        return this;
    }

}