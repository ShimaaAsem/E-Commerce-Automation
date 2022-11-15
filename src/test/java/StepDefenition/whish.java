package StepDefenition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.homePage;

public class whish {
    homePage home;
    WebDriver driver;
    private String[] productsName={"Apple MacBook Pro 13-inch","HTC One M8 Android L 5.0 Lollipop"};
    @Given("initialize wish list feature")
    public void init() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath );

        driver = new ChromeDriver();

        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        driver.manage().window().maximize();

        home = new homePage(Hook.driver);
    }
    @When("user select to add HTC phone to wish list")
    public void addProductToWishList() throws InterruptedException {
        //adding htc phone
        home.addProductToWishList(productsName[1]);


    }
    @Then("user should get a success message")
    public void checkOnAddToWishMessage(){
        SoftAssert soft= new SoftAssert();
        String actualMessageText= home.getAddToWishListMessageText();
        String actualMessageBackGroundColor = home.getAddToWishListMessageBackGroundColor();
        String expectedText="The product has been added to your wishlist";
        String expectedColor="rgba(75, 176, 122, 1)";
        soft.assertTrue(expectedText.equals(actualMessageText));
        soft.assertTrue(expectedColor.equals(actualMessageBackGroundColor));
        soft.assertAll();

    }
    @And("click on wish list")
    public void clickOnWishList() throws InterruptedException {
        Thread.sleep(6000);
        home.goToWishList();

    }
    @Then("user should find the product")
    public void checkOnProduct(){
        //Assert htc phone
        System.out.println(home.findProductQty(productsName[1]));
        Assert.assertTrue(home.findProductQty(productsName[1])>0);


    }
}
