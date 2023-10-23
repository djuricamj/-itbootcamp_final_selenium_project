package pages;

import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage {
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //    Home link
//About link
//My profile link
//Admin dugme
//Cities link iz padajuceg Admin menija
//Users link iz padajuceg Admin menija
//Sign up dugme
//Login dugme
//Logout dugme
//Dugme za izbor jezika
//EN dugme iz padajuceg menija za izbor jezika
//ES dugme iz padajuceg menija za izbor jezika
//FR dugme iz padajuceg menija za izbor jezika
//CN dugme iz padajuceg menija za izbor jezika

    public WebElement getLanguageButton() {
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public void clickOnLanguageButton() {
        getLanguageButton().click();
    }

    public WebElement getLanguageList() {
        return driver.findElement(By.cssSelector(".menuable__content__active > div"));
    }

    public void waitUntilLanguageListIsVisible() {
        wait
                .withMessage("Language list should be visible.")
                .until(ExpectedConditions.visibilityOf(getLanguageList()));
    }

    public WebElement getEnglishButton() {
        return driver.findElement(By.cssSelector("span.f-gb"));
    }

    public void clickOnEnglishButton() {
        getEnglishButton().click();

    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector(".v-toolbar__items>a:nth-child(3)"));
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitUntilCurrentUrlContainsLogin() {

        wait
                .withMessage("Current url should contain '/login'.")
                .until(ExpectedConditions.urlContains("/login"));
    }

    public void waitUntilCurrentUrlContainsHome() {
        wait
                .withMessage("Current url should contain '/home'.")
                .until(ExpectedConditions.urlContains("/home"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.className("btnLogout"));
    }

    public void clickOnLogoutButton() {
        getLogoutButton().click();
    }

    public WebElement getSignUpButton() {
        return driver.findElement(By.cssSelector(".v-toolbar__items>a:nth-child(4)"));

    }

    public void clickOnSignUpButton() {
        getSignUpButton().click();
    }

    public void waitUntilCurrentUrlContainsSignup() {

        wait
                .withMessage("Current url should contain '/signup'.")
                .until(ExpectedConditions.urlContains("/signup"));
    }

    public WebElement getAdminButton (){
        return driver.findElement(By.className("btnAdmin"));
    }
    public void clickOnAdminButton (){
        getAdminButton().click();
    }

    public WebElement getCitiesButton(){
        return driver.findElement(By.cssSelector(".btnAdminCities"));
    }
    public void clickOnCitiesButton (){
        getCitiesButton().click();
    }
    public void waitUntilCurrentUrlContainsAadminCities() {

        wait
                .withMessage("Current url should contain '/admin/cities'.")
                .until(ExpectedConditions.urlContains("/admin/cities"));
    }

    public WebElement getSpanishLanguage () {
        return driver.findElement(By.cssSelector("span.f-es"));
    }
    public void clickOnSpanishLanguage () {
        getSpanishLanguage().click();
    }
    public WebElement getHeader () {
        return driver.findElement(By.cssSelector("h1.display-2"));
    }
    public String getHeaderText () {
        return getHeader().getText();
    }
    public  WebElement getChineseLanguage() {
        return driver.findElement(By.cssSelector("span.f-cn"));
    }
    public void clickOnChineseLanguage () {
        getChineseLanguage().click();
    }
    public WebElement getFrenchLanguage () {
        return driver.findElement(By.cssSelector("span.f-fr"));
    }
    public void clickOnFrenchLanguage () {
        getFrenchLanguage().click();
    }



}

