package StepDefenition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.registerPage;


public class RegSD {

    registerPage register ;
    WebDriver driver=null;


    /*@Given("User open browser and go to register page")

    public void open() throws InterruptedException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath );


        driver = new ChromeDriver();

        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //driver.close();
        register = new registerPage(driver);


    }


    @When("user press register icon")
    public void pressRegisterIcon() throws InterruptedException {
        register.goToRegisterPage();
        Thread.sleep(3000);
    }
    @And("^user selects \"(.*)\" and enters \"(.*)\" as first name, \"(.*)\" as last name, \"(.*)\" as email, \"(.*)\" as company, \"(.*)\" as password and \"(.*)\" as confirm password$")
    public void enterRegisterData(String gender,String firstName, String lastName, String email, String company, String password, String confirmPassword) throws InterruptedException {

        register.selectGender(gender);
        register.enterFirstName().sendKeys(firstName);
        register.enterLastName().sendKeys(lastName);
        register.enterEmail().sendKeys(email);
        register.enterCompany().sendKeys(company);
        register.enterPassword().sendKeys(password);
        register.enterConfirmPassword().sendKeys(confirmPassword);
        Thread.sleep(3000);

    }
    @And("^user set his birthday as follow \"(.*)\" Day \"(.*)\" Month \"(.*)\" Year$")
    public void clickOnBirthDay(String day, String month, String year){
        register.setBirthday(day, month, year);
    }

    @And("user clicks on register button")
    public void pressRegisterButton() throws InterruptedException {
        register.pressRegisterButton();
        Thread.sleep(3000);
    }

    @Then("successful registration message appears")
    public void checkOnRegistrationMessageCompilation(){
        String expectedResult="Your registration completed";
        String actualResult=register.getRegistrationMessageCompilation().getText();
        String expectedColor="rgba(76, 177, 124, 1)";
        String color= register.getRegistrationMessageCompilation().getCssValue("color");
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(expectedResult.contains(actualResult));
        soft.assertEquals(color,expectedColor);
        soft.assertAll();
    }*/

    @Given("User open browser and go to register page")
    public void user_open_browser_and_go_to_register_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath );


        driver = new ChromeDriver();

        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //driver.close();
        register = new registerPage(driver);




        //throw new io.cucumber.java.PendingException();
    }
    @When("user press register icon")
    public void user_press_register_icon() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        register.goToRegisterPage();
        Thread.sleep(3000);
        //throw new io.cucumber.java.PendingException();
    }
    @When("^user selects \"(.*)\" and enters \"(.*)\" as first name, \"(.*)\" as last name, \"(.*)\" as email, \"(.*)\" as company, \"(.*)\" as password and \"(.*)\" as confirm password$")
    public void user_selects_and_enters_as_first_name_as_last_name_as_email_as_company_as_password_and_as_confirm_password(String gender, String firstName, String lastName, String email, String company, String password, String confirmPassword) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        register.selectGender(gender);
        register.enterFirstName().sendKeys(firstName);
        register.enterLastName().sendKeys(lastName);
        register.enterEmail().sendKeys(email);
        register.enterCompany().sendKeys(company);
        register.enterPassword().sendKeys(password);
        register.enterConfirmPassword().sendKeys(confirmPassword);
        Thread.sleep(3000);
        //throw new io.cucumber.java.PendingException();
    }
    @When("user set his birthday as follow {string} Day {string} Month {string} Year")
    public void user_set_his_birthday_as_follow_day_month_year(String day, String month, String year) {
        // Write code here that turns the phrase above into concrete actions
        register.setBirthday(day, month, year);

        //throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on register button")
    public void user_clicks_on_register_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        register.pressRegisterButton();
        Thread.sleep(3000);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("successful registration message appears")
    public void successful_registration_message_appears() {
        // Write code here that turns the phrase above into concrete actions
         String expectedResult="Your registration completed";
        String actualResult=driver.findElement(By.cssSelector("div[class=\"result\"]")).getText();
        String expectedColor="rgba(76, 177, 124, 1)";
        String color= driver.findElement(By.cssSelector("div[class=\"result\"]")).getCssValue("color");
        //SoftAssert soft = new SoftAssert();
        Assert.assertTrue(expectedResult.contains(actualResult));
        Assert.assertEquals(color,expectedColor);
       // soft.assertAll();
        //throw new io.cucumber.java.PendingException();
    }


}
