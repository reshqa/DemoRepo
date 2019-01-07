package com.crm.resh.base;

import com.crm.resh.utils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
  public static WebDriver driver;
  public static Properties prop;


    public TestBase(){

        try {
             prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\user\\IdeaProjects\\FreeCRMResh\\src\\main" +
                    "\\java\\com\\crm\\resh\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void initialization(){
        String browser=prop.getProperty("browser");
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Reshma\\Chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Reshma\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(TestUtils.page_load_time, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(TestUtils.implicit_wait,TimeUnit.SECONDS);
    driver.get(prop.getProperty("url"));
    }

}



