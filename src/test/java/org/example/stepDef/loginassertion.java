package org.example.stepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import static org.example.stepDef.Hooks.driver;

public class loginassertion {
     login login = new login();

     @Given("user go to login page")
    public void UserGoToLoginPage() {

     }

    @And("user enter invalid email{string} and  invalid password in login page{string}")
    public void userEnterInvalidEmailAndInvalidPasswordInLoginPage(String arg0, String arg1) {
        Faker faker = new Faker();
        arg0= String.valueOf(faker.name());
        login.UserName.sendKeys(arg0);
        arg1= String.valueOf(faker.name());
        login.Passwrord.sendKeys(arg1);
    }

    @And("user enter valid email{string} and password in login page{string}")
    public void userEnterValidEmailAndPasswordInLoginPage(String arg0, String arg1) {
         login.UserName.sendKeys("standard_user");
         login.Passwrord.sendKeys("secret_sauce");

    }

    @And("user click on loginBtn")
    public void userClickOnLoginBtn() {
         login.loginButton.click();
    }
    @Then("error message appears")
    public void errorMessageAppears() {
        SoftAssert soft = new SoftAssert();
        String Actualurl = driver.getCurrentUrl(); // to se the url changed
        soft.assertTrue(Actualurl.contains("https://www.saucedemo.com/"),  "https://www.saucedemo.com/");
        String ActualMsg=  login.ErrorMessage.getText();
        soft.assertTrue(ActualMsg.contains("Epic sadface: Username and password do not match any user in this service"),"Epic sadface: Username and password do not match any user in this service");
        //soft.assertTrue(condition, message)
        // condition = actualMsg.contains("Your registration completed")     >> boolean
        // message in case of failure  =  "actualMsg : " + actualMsg + "  " + "expected Msg : "+"Your registration completed"
        String actualColorRGPA =login.ErrorMessage.getCssValue("color");
        String actualColorHex= Color.fromString(actualColorRGPA).asHex();
        soft.assertEquals(actualColorHex,"#ffffff");
        soft.assertAll();
    }

    @Then("welcome message appears")
    public void welcomeMessageAppears() {
        SoftAssert soft = new SoftAssert();
        String Actualurl = driver.getCurrentUrl(); // to se the url changed
        soft.assertTrue(Actualurl.contains("https://www.saucedemo.com/inventory.html"),  "https://www.saucedemo.com/inventory.html");
        String ActualMsg=  login.confirmMessage.getText();
        soft.assertTrue(ActualMsg.contains("Swag Labs"),"Swag Labs");
        //soft.assertTrue(condition, message)
        // condition = actualMsg.contains("Your registration completed")     >> boolean
        // message in case of failure  =  "actualMsg : " + actualMsg + "  " + "expected Msg : "+"Your registration completed"
        String actualColorRGPA =login.confirmMessage.getCssValue("color");
        String actualColorHex= Color.fromString(actualColorRGPA).asHex();
        soft.assertEquals(actualColorHex,"#132322");
        soft.assertAll();

    }


}
