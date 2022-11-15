package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginBage {

    WebDriver driver ;
    public loginBage( WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    public WebElement setEmail()  {
        driver.findElement(By.cssSelector("input[id=\"Email\"]")).clear();
        return driver.findElement(By.cssSelector("input[id=\"Email\"]"));


    }

    public WebElement setPass(){
        driver.findElement(By.cssSelector("input[id=\"Password\"]")).clear();
        return driver.findElement(By.cssSelector("input[id=\"Password\"]"));
    }
    public void pressLoginButton(){
        driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]")).click();
    }

}
