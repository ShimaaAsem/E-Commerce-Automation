package StepDefenition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.homePage;

import java.util.List;

public class euro {

    homePage home_page;
WebDriver driver=null;



    @Given("initialize Currencies feature")
    public void setHome_page()  {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath );

        driver = new ChromeDriver();

        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        driver.manage().window().maximize();




        home_page = new homePage(Hook.driver);
    }


    @When("user press on currencies")
    public void userPressCurrencies() throws InterruptedException {
        driver.findElement(By.cssSelector("select[id=\"customerCurrency\"]")).click();
        Thread.sleep(1000);

    }
    @And("^user chooses \"(.*)\"$")
    public void userChooseEuro(String currency)  {
        Select select= new Select(driver.findElement(By.cssSelector("select[id=\"customerCurrency\"]")));
        if((currency.equals("euro"))||(currency.equals("Euro"))){
            select.selectByVisibleText("Euro");
        }
        else {
            select.selectByVisibleText("US Dollar");
        }

    }
    @Then("^the product currency changes to \"(.*)\"$")
    public void checkOnCurrency(String currency){
        List<WebElement> prices =driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
        if((currency.equals("euro"))||(currency.equals("Euro"))){
            String expectedCurrency="€";
            for(int x=0; x<4 ; x++){
                Assert.assertTrue(prices.get(x).getText().contains(expectedCurrency));
            }
        }
        else {
            String expectedCurrency="$";
            for(int x=0; x<4 ; x++){
                Assert.assertTrue(prices.get(x).getText().contains(expectedCurrency));
            }
        }

    }


}


