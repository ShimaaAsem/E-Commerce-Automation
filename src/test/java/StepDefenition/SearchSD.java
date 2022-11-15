package StepDefenition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.homePage;


import java.util.List;

public class SearchSD {
     homePage home;
     searchPage search;
     WebDriver driver;
    @Given("initialize Search feature")
    public void init() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath );

        driver = new ChromeDriver();

        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        home=new homePage(Hook.driver);
        search = new searchPage(Hook.driver);
    }
    @When("^user types \"(.*)\"$")
    public void enterProductName(String productName){
        driver.findElement(By.cssSelector("input[id=\"small-searchterms\"]")).sendKeys(productName);
    }



    @And("clicks on search")
    public void clickOnSearch() throws InterruptedException {
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        Thread.sleep(1000);
    }
    @Then("^user should find the \"(.*)\"$")
    public void checkSearchResult(String productName){
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
        int i=0;
        List<WebElement> actualResults =  driver.findElements(By.cssSelector("h2[class=\"product-title\"]"));
        System.out.println("Number of search results: "+actualResults.size());
        for (WebElement actualResult : actualResults){
            System.out.println(actualResults.get(i).getText().toLowerCase());
            soft.assertTrue(actualResults.get(i).getText().toLowerCase().contains(productName));
            i++;
        }
        soft.assertAll();
    }


    }
