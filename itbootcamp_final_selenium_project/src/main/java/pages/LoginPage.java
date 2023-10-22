package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInputBox (){
        return driver.findElement(By.id("email"));
    }

    public String getEmailInputBoxAttributeValue (){
        return getEmailInputBox().getAttribute("type");
    }

    public WebElement getPasswordInputBox (){
        return driver.findElement(By.id("password"));
    }
    public String getPasswordInputBoxAttributeValue (){
        return getPasswordInputBox().getAttribute("type");
    }






}
