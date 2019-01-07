package com.crm.resh.pages;

import com.crm.resh.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase {
    //page Factory or Object Repository
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

   @FindBy(xpath="//input[@value='Login']")
   WebElement loginBtn;

    @FindBy(xpath = "//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;

    //initializing the pageobject
public LoginPage(){
    PageFactory.initElements(driver,this);//this means LoginPage.class and driver is coming from baseclass
}

    public String ValidateLoginPageTitle(){
       return driver.getTitle();
    }

    public boolean ValidateCRMImage(){
      return crmLogo.isDisplayed();
    }

   public HomePage Login(String uname,String pwd){
    username.sendKeys("uname");
    password.sendKeys("pwd");
    loginBtn.click();
   // loginBtn.sendKeys(Keys.ENTER);
    return new HomePage();
    }

}
