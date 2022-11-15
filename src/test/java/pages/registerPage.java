package pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class registerPage {

     WebDriver driver;

    public registerPage(WebDriver driver) {
        this.driver = driver;
    }
    public void selectGender(@NotNull String gender){
        if((gender.equals("female")) || (gender.equals("Female"))){
            driver.findElement(By.cssSelector("input[id=\"gender-female\"]")).click();
        }
        else if ((gender.equals("male")) || (gender.equals("Male"))){
            driver.findElement(By.cssSelector("input[id=\"gender-male\"]")).click();
        }
        else {
            //do nothing
        }

    }

    public void goToRegisterPage(){
        driver.findElement(By.cssSelector("a[class=\"ico-register\"]")).click();
    }
    public WebElement enterFirstName(){
        driver.findElement(By.cssSelector("input[id=\"FirstName\"]")).clear();
        return driver.findElement(By.cssSelector("input[id=\"FirstName\"]"));
    }
    public WebElement enterLastName(){
        driver.findElement(By.cssSelector("input[id=\"LastName\"]")).clear();
        return driver.findElement(By.cssSelector("input[id=\"LastName\"]"));
    }
    public WebElement enterEmail(){
        driver.findElement(By.cssSelector("input[id=\"Email\"]")).clear();
        return driver.findElement(By.cssSelector("input[id=\"Email\"]"));
    }
    public WebElement enterCompany(){
        driver.findElement(By.cssSelector("input[id=\"Company\"]")).clear();
        return driver.findElement(By.cssSelector("input[id=\"Company\"]"));
    }
    public WebElement enterPassword(){
        driver.findElement(By.cssSelector("input[id=\"Password\"]")).clear();
        return driver.findElement(By.cssSelector("input[id=\"Password\"]"));
    }
    public WebElement enterConfirmPassword(){
        driver.findElement(By.cssSelector("input[id=\"ConfirmPassword\"]")).clear();
        return driver.findElement(By.cssSelector("input[id=\"ConfirmPassword\"]"));
    }

    public void pressRegisterButton(){
        driver.findElement(By.cssSelector("button[id=\"register-button\"]")).click();
    }
    public WebElement getEmailExistMessage(){
        return driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
    }
    public WebElement getRegistrationMessageCompilation(){
        return driver.findElement(By.cssSelector("div[class=\"result\"]"));
    }
    public void setBirthday(String day, String month, String year){
        Select select=new Select(driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]")));
        select.selectByIndex(Integer.parseInt(day));
        select=new Select( driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]")));
        select.selectByValue(month);
        select= new Select( driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]")));
        select.selectByVisibleText(year);

    }

}
