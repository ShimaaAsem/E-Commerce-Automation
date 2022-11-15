package pages;

import StepDefenition.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class homePage {
WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToWishList(String productName) {
        //get all web elements that have wish list button
        List<WebElement> products= Hook.driver.findElements(By.cssSelector("button[title=\"Add to wishlist\"]"));
        if(productName!=null) {
            switch (productName){
                //choose wish list icon of MacBook
                case "Apple MacBook Pro 13-inch":
                    products.get(1).click();
                    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
                    Hook.driver.findElement(By.cssSelector("button[id=\"add-to-wishlist-button-4\"]")).click();
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    Hook.driver.navigate().to("https://demo.nopcommerce.com/");
                    break;
                //choose wish list icon of htc phone
                case "HTC One M8 Android L 5.0 Lollipop":
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    products.get(2).click();
                    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                    break;
            }
        }
    }
    public String getAddToWishListMessageText(){
        return Hook.driver.findElement(By.cssSelector("p[class=\"content\"]")).getText();
    }
    public String getAddToWishListMessageBackGroundColor(){
        return Hook.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).getCssValue("background-color");
    }
    public void goToWishList(){
        Hook.driver.findElement(By.cssSelector("a[href=\"/wishlist\"]")).click();
    }

    //this function gets all web elements at wish list page then search at the required product and
    //return its qty and if the wish list is empty it returns -1
    public int findProductQty(String productName){
        List<WebElement> qty= Hook.driver.findElements(By.cssSelector("td[class=\"quantity\"]"));
        List<WebElement> products =Hook.driver.findElements(By.cssSelector("td[class=\"product\"]"));
        int index=0;
        if(!products.isEmpty()) {
            for (WebElement product : products) {
                if (product.findElement(By.className("product-name")).getText().equals(productName)) {
                    String numToString = qty.get(index).findElement(By.tagName("input")).getAttribute("value").toString();
                    int num = Integer.parseInt(numToString);
                    return num;
                }
                index++;
            }
        }
        else{
            return -1;
        }
        //the product is not in wish list
        return 0xff;
    }


}






