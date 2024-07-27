package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepDef.Hooks.driver;

public class login {
    public login()
    {
        PageFactory.initElements(driver, this );// apply driver on this page
    }
    @FindBy( css="input[id=\"user-name\"]")// locator for the name
    public WebElement UserName;
    @FindBy ( css="input[id=\"password\"]")// locator for the passwrod
    public WebElement Passwrord;
    @FindBy(id="login-button") // locator for login botttom
    public WebElement loginButton ;
    @FindBy(className = "app_logo")
    public  WebElement confirmMessage;
    @FindBy(css = "  h3[ data-test=\"error\"]")
    public WebElement ErrorMessage;

}
