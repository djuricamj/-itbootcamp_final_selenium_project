package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage{

    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton (){
        return driver.findElement(By.cssSelector(".btnNewItem"));
    }
    public void clickOnNewItemButton (){
        getNewItemButton().click();
    }

    public WebElement getNewDialogPopup() {
        return driver.findElement(By.cssSelector(".dlgNewEditItem"));
    }

    public void waitUntilGetNewDialogPopupIsVisible() {
        wait
                .withMessage("Pop-up dialog for add/edit city should be visible.")
                .until(ExpectedConditions.visibilityOf(getNewDialogPopup()));
    }

    public WebElement getNameInputBox (){
        return driver.findElement(By.id("name"));
    }

    public String getNameInputBoxAttributeValue (){
        return getNameInputBox().getAttribute("type");
    }

    public WebElement getSaveButton (){
        return driver.findElement(By.className("btnSave"));
    }
    public void waitUntilSaveButtonIsClickable (){
        wait
                .withMessage("Save button is not clickable")
                .until(ExpectedConditions.elementToBeClickable(getSaveButton()));
    }

    public void clickOnSaveButton (){
        getSaveButton().click();
    }


}
