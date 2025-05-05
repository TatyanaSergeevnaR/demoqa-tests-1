package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AddressComponent {
    public void setAddress(String address, String state, String city){
        $("#currentAddress").setValue(address);
        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }

}
