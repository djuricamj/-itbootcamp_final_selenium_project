package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getNameInputBox (){
        return driver.findElement(By.id("name"));
    }
    public String getNameInputBoxAttributeValue (){
        return getNameInputBox().getAttribute("type");
    }

    public WebElement getEmailInpuBox (){
        return driver.findElement(By.id("email"));
    }
    public String getEmailInputBoxAttributeValue (){
        return getNameInputBox().getAttribute("type");
    }

    public WebElement getPasswordInputBox (){
        return driver.findElement(By.id("password"));
    }
    public String getPasswordInputBoxAttributeValue (){
        return getPasswordInputBox().getAttribute("type");
    }

    public WebElement getConfirmPasswordInputBox (){
        return driver.findElement(By.id("confirmPassword"));
    }
    public String getConfirmPasswordInputBoxAttributeValue (){
        return getConfirmPasswordInputBox().getAttribute("type");
    }





}
