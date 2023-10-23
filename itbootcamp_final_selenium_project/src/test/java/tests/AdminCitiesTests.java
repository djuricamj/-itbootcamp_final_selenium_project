package tests;

import RetryAnalyzer.retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{

    @Test(priority = 1)
    public void visitsTheAdminCitiesPageAndListCities () throws InterruptedException {
        String adminEmail = "admin@admin.com";
        String adminPassword = "12345";

        navPage.clickOnLoginButton();
        loginPage.getEmailInputBox().clear();
        loginPage.getEmailInputBox().sendKeys(adminEmail);
        loginPage.getEmailInputBox().clear();
        loginPage.getPasswordInputBox().sendKeys(adminPassword);
        loginPage.clickOnLoginButton();
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();
        navPage.waitUntilCurrentUrlContainsAadminCities();
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/admin/cities",
                "Current url should be " + baseUrl + "/admin/cities");


    }



}
