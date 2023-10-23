package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage{


    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getErrorPopup (){
        return driver.findElement(By.cssSelector(".v-snack__content>ul>li"));
    }
    public void waitUntilErrorPopUpMessageIsVisible (){
        wait.withMessage("Pop up message for invalid login should be visible.")
                .until(ExpectedConditions.visibilityOf(getErrorPopup()));
    }

    public String getErrorMessage (){
        return getErrorPopup().getText();
    }

    public WebElement getMessageForAccountVerify () {
        return driver.findElement(By.className("v-card__title"));
    }
    public void waitUntilMessageForAccountVerifyIsVisible () {
        wait
                .withMessage("Pop-up message for account verify should be visible.")
                .until(ExpectedConditions.visibilityOf(getMessageForAccountVerify()));
    }
    public String getTextForMessageForAccountVerify () {
        return getMessageForAccountVerify().getText();
    }
    public WebElement getCloseButton () {
        return driver.findElement(By.cssSelector(".v-card__actions button"));
    }
    public void clickOnCloseButton () {
        getCloseButton().click();
    }

    public WebElement getSuccessfulAddOrEditCityMessage (){
        return driver.findElement(By.cssSelector(".success .v-snack__content"));
    }
    public void waitUntilSuccessfulAddOrEditCityMessageIsVisible (){
        wait
                .until(ExpectedConditions.visibilityOf(getSuccessfulAddOrEditCityMessage()));
    }
    public boolean getTextForSuccessfulAddOrEditCityMessage (){
        return getSuccessfulAddOrEditCityMessage().getText().contains("Saved successfully");
    }
    public WebElement getPopupMessageforSuccessfulDeleting (){
        return driver.findElement(By.cssSelector(".success .v-snack__content"));
    }
    public void waitUntilPopUpMessageForSuccessfulDeleteCityIsVisible () {
        wait
                .withMessage("Pop-up message for successful add/edit city should be visible.")
                .until(ExpectedConditions.visibilityOf(getPopupMessageforSuccessfulDeleting()));
    }
    public boolean getTextFromPopUpMessageForSuccessfulDeleteCity () {
        return getPopupMessageforSuccessfulDeleting().getText().contains("Deleted successfully");
    }
}
