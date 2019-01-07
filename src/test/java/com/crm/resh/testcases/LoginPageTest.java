package com.crm.resh.testcases;

import com.crm.resh.base.TestBase;
import com.crm.resh.pages.HomePage;
import com.crm.resh.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage lpage;
    HomePage homepage;
   public LoginPageTest(){         // creating constructor
       super();                   //using super keyword  accessing TestBase properties. then it comes to the @beforemethod
                                  //then initialization() will work then logonpage object will create
   }
   @BeforeMethod
    public void setup(){
       initialization();
       lpage=new LoginPage();
   }
   @Test(priority = 1)
   public void LoginPageTitleTest(){
       String title=lpage.ValidateLoginPageTitle();
       Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service");
   }
    @Test(priority = 2)
    public void LoginTest(){
    homepage= lpage.Login(prop.getProperty("username"),prop.getProperty("password"));
        }

        @AfterMethod
    public void teardown(){
       driver.quit();
    }

}
