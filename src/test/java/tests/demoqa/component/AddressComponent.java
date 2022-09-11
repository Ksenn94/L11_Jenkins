package tests.demoqa.component;

import static com.codeborne.selenide.Selenide.$;

public class AddressComponent {
    public AddressComponent setCity(String state, String city) {
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();

        return this;
    }
}


