package Pages.Locators;

import Pages.base.Base_PO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import utils.Global_Vars;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;


public class Form extends Base_PO {

    private @FindBy(id = "firstName")
    WebElement firtsName_field;

    private @FindBy(id = "lastName")
    WebElement lastName_field;

    private @FindBy(id = "userEmail")
    WebElement email_field;

    private @FindBy(xpath = "//label[text()='Male']")
    WebElement radio_button1;

    private @FindBy(id = "userNumber")
    WebElement mobile_number;

    private @FindBy(xpath = "//div[contains(@Class,'subjects-auto-complete__value-container')]")
    WebElement subjects_field;

    private @FindBy(xpath = "//label[text()='Music']")
    WebElement radio_button2;

    private @FindBy(xpath = "//label[text() ='Select picture']")
    WebElement uploadFile_button;

    private @FindBy(id = "currentAddress")
    WebElement address_field;

    private @FindBy(id = "state")
    WebElement state_field;

    private @FindBy(id = "city")
    WebElement city_field;

    private @FindBy(id = "submit")
    WebElement submit_button;


    public Form(){
        super();
    }

    public void navigateTo_Form_Page(){
        navigateTo_URL(Global_Vars.WEBDRIVER_FORM_PAGE_URL);
    }

    public void setName(String name){
        sendKeys(firtsName_field, name);
    }

    public void setLastName(String lastName){
        sendKeys(lastName_field, lastName);
    }

    public void setEmail(String email){
        sendKeys(email_field, email);
    }

    public void radioButtonGender(){
        javaScritpEjecutor();
        waitForWebElementandClick(radio_button1);
    }

    public void setMobileNumber(String number){
        sendKeys(mobile_number, number);
    }

    public void setBirthDay(){
        javaScritpEjecutor();
        Actions act = new Actions(getDriver());
        act.moveToElement(getDriver().findElement(By.id("dateOfBirthInput"))).click().build().perform();

        Select month = new Select(getDriver().findElement(By.xpath("//select[contains(@class, 'react-datepicker__month-select')]")));
        month.selectByValue("3");

        Select year = new Select(getDriver().findElement(By.xpath("//select[contains(@class, 'react-datepicker__year-select')]")));
        year.selectByValue("1995");

        getDriver().findElement(By.cssSelector("div[aria-label='Choose Sunday, April 9th, 1995']")).click();
    }


    public void radioButtonHobbies(){
        waitForWebElementandClick(radio_button2);
    }

    public void uploadFile() throws AWTException {
      // uploadFile_button.click();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", uploadFile_button);

        Robot rb = new Robot();
        rb.delay(2000);

        StringSelection ss = new StringSelection("C:\\Users\\carevalo\\Documents\\Cristian\\Test - QA Automator.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(2000);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(2000);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }


    public void setAddress(){
        address_field.click();
        address_field.sendKeys("Carrera 20 - 50 Apt 201 int 3 Los Ocobos");
    }

    public void setState(){
        javaScritpEjecutor();
        waitForWebElementandClick(state_field);
        getDriver().findElement(By.id("react-select-3-option-0")).click();
    }

    public void setCity(){
        waitForWebElementandClick(city_field);
        Actions act = new Actions(getDriver());
        act.moveToElement(getDriver().findElement(By.id("react-select-4-option-1"))).sendKeys(Keys.ENTER).build().perform();
       // getDriver().findElement(By.id("react-select-4-option-0")).click();
    }

    public void setButton(){
        Actions act = new Actions(getDriver());
        act.moveToElement(getDriver().findElement(By.xpath("//button[text() = 'Submit']"))).sendKeys(Keys.ENTER).build().perform();
    }

    public void setText(){
        String text = "Thanks for submitting the form";
        String textoLocator = getDriver().findElement(By.xpath("//div[text() = 'Thanks for submitting the form'] ")).getText();
        System.out.println(textoLocator);
        Assert.assertEquals(text, textoLocator);

    }


}
