package StepDefenition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;
import pages.homePage;
import pages.loginBage;

public class LoginSD {
loginBage login;
    homePage home_page;
    WebDriver driver=null;


    @Given("open login page")
    public void navigatesToLoginPage() throws InterruptedException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath );

        driver = new ChromeDriver();

        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //driver.close();
        login = new loginBage(driver);

        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");



    }

    @When("^enter email \"(.*)\" and password \"(.*)\"$")
    public void validData(String email , String Password) throws InterruptedException {


        login.setEmail().sendKeys(email);

        login.setPass().sendKeys(Password);
        Thread.sleep(1000);

    }

    @And("user press login")
    public void pressLogin(){
        login.pressLoginButton();
    }

    @Then("user go to home page")
    public void checkOnLogin() throws InterruptedException {

        driver.navigate().to("https://demo.nopcommerce.com/");

        Thread.sleep(3000);

        driver.quit();


    }

    }


