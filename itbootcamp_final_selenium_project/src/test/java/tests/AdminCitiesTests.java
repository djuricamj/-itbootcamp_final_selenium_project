package tests;

import RetryAnalyzer.retry;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = retry.class)
    public void visitsTheAdminCitiesPageAndListCities () throws InterruptedException {

        navPage.clickOnLoginButton();
        loginPage.loginAsAdmin();
        loginPage.clickOnLoginButton();
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();
        navPage.waitUntilCurrentUrlContainsAadminCities();
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/admin/cities",
                "Current url should be " + baseUrl + "/admin/cities");


    }

    @Test(priority = 2,retryAnalyzer = retry.class)
    public void checksInutTypesForCreateAndEditNewCity (){

        navPage.clickOnLoginButton();
        loginPage.loginAsAdmin();
        loginPage.clickOnLoginButton();
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();
        navPage.waitUntilCurrentUrlContainsAadminCities();
        citiesPage.clickOnNewItemButton();
        citiesPage.waitUntilGetNewDialogPopupIsVisible();
        Assert.assertEquals(citiesPage.getNameInputBoxAttributeValue(), "text",
                "Name input box for attribute should have 'text'.");

    }



    @Test(priority = 3, retryAnalyzer = retry.class)
    public void createNewCity (){
        String city = "Marijana Djurica's city";

        this.checksInutTypesForCreateAndEditNewCity();

        citiesPage.getNameInputBox().clear();
        citiesPage.getNameInputBox().sendKeys(city);
        citiesPage.waitUntilSaveButtonIsClickable();
        citiesPage.clickOnSaveButton();
        messagePopUpPage.waitUntilSuccessfulAddOrEditCityMessageIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextForSuccessfulAddOrEditCityMessage()
                , "Popup message for successful add/edit citi should contains 'Saved successfully'");

    }

    @Test(priority = 4, retryAnalyzer = retry.class)
    public void editCity () throws InterruptedException {
        String oldCityName = "Marijana Djurica's city";
        String newCityName = "Marijana Djurica's city Edited";

      navPage.clickOnLoginButton();
      loginPage.loginAsAdmin();
      loginPage.clickOnLoginButton();
      navPage.clickOnAdminButton();
      navPage.clickOnCitiesButton();
      navPage.waitUntilCurrentUrlContainsAadminCities();
      citiesPage.getSearchInputBox().sendKeys(oldCityName);
      citiesPage.waitUntilNumberOfRowsOfCitiesInSearchIsOne();
      citiesPage.clickOnEditCityButton();
      citiesPage.getNameInputBox().sendKeys(Keys.CONTROL,"a",Keys.DELETE);
      Thread.sleep(4000);
      citiesPage.getNameInputBox().sendKeys(newCityName);
      Thread.sleep(2300);
      citiesPage.clickOnSaveButton();
      messagePopUpPage.waitUntilSuccessfulAddOrEditCityMessageIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextForSuccessfulAddOrEditCityMessage()
                , "Popup message for successful add/edit citi should contains 'Saved successfully'");

    }
    @Test(priority = 5, retryAnalyzer = retry.class)
    public void searchCity (){
        String cityName = "Marijana Djurica's city Edited";
        navPage.clickOnLoginButton();
        loginPage.loginAsAdmin();
        loginPage.clickOnLoginButton();
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();
        navPage.waitUntilCurrentUrlContainsAadminCities();
        citiesPage.getSearchInputBox().sendKeys(cityName);
        citiesPage.waitUntilNumberOfRowsOfCitiesInSearchIsOne();

        Assert.assertEquals(citiesPage.getTextForCityName(), cityName,
                "City name should be" + cityName);


    }
    @Test(priority = 5,retryAnalyzer = retry.class)
    public void deleteCity (){
        String cityName = "Marijana Djurica's city Edited";

        navPage.clickOnLoginButton();
        loginPage.loginAsAdmin();
        loginPage.clickOnLoginButton();
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();
        navPage.waitUntilCurrentUrlContainsAadminCities();
        citiesPage.getSearchInputBox().sendKeys(cityName);
        citiesPage.clickOnDeleteButton();
        citiesPage.waitUntilPopUpMessageForDeleteCityIsVisible();
        citiesPage.clickOnDeleteButtonFromPopUpMenuForDeleteCity();
        messagePopUpPage.waitUntilPopUpMessageForSuccessfulDeleteCityIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromPopUpMessageForSuccessfulDeleteCity(),
                "Message should contains 'Deleted successfully'");
    }



}
