package tests;

import RetryAnalyzer.retry;
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



}
