package stepDefinition;

import Pages.Locators.Form;
import Pages.base.Base_PO;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class Form_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    private Form form;

    public Form_Steps(Form form){
        this.form = form;
    }

    @Given("I access the form page")
    public void i_access_the_form_page() {
        form.navigateTo_Form_Page();
    }
    @When("I enter a name {word}")
    public void i_enter_a_name(String name) {
        form.setName(name);
    }
    @When("I enter a last name {word}")
    public void i_enter_a_last_name(String lastname) {
        form.setLastName(lastname);
    }
    @When("I enter a email {word}")
    public void i_enter_a_email(String email) {
       form.setEmail(email);
    }
    @When("I select the gender")
    public void i_select_the_gender() {
       form.radioButtonGender();
    }
    @When("I enter a mobile number {string}")
    public void i_enter_a_mobile_number(String number) {
        form.setMobileNumber(number);
    }
    @When("I select the birth day")
    public void i_select_the_birth_day() {
      form.setBirthDay();
    }

    @When("I select a hobbies")
    public void i_select_a_hobbies() {
        form.radioButtonHobbies();
    }
    @When("I upload the picture")
    public void i_upload_the_picture() throws AWTException {
      form.uploadFile();
    }
    @When("I enter a current Address")
    public void i_enter_a_current_address() {
        form.setAddress();
    }
    @When("I select a state")
    public void i_select_a_state() {
       form.setState();
    }
    @When("I select a City")
    public void i_select_a_city() {
       form.setCity();
    }
    @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
       form.setButton();
    }
    @Then("Validate message to form")
    public void validate_message_to_form() {
       form.setText();
    }
}
