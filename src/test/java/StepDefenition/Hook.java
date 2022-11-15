package StepDefenition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.loginBage;

public class Hook {


     public static WebDriver driver ;
    loginBage login;
    @BeforeTest
    public void openB() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath );


        //WebDriver driver= new ChromeDriver();
        driver = new ChromeDriver();

        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //driver.close();
        login = new loginBage(driver);

    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {

        Thread.sleep(3000);

        driver.quit();


    }



}
