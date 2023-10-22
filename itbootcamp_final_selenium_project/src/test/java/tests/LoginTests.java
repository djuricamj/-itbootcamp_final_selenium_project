package tests;

import RetryAnalyzer.retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{

//    Test #1: Visits the login page
//Koraci:
//Postaviti EN jezik stranice
//Klik na login dugme iz navigacije
//Verifikovati da se u url-u stranice javlja ruta /login

    @Test(priority = 1, retryAnalyzer = retry.class)
    public void visitTheLoginPage (){
        navPage.clickOnLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnEnglishButton();

        navPage.clickOnLoginButton();

        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");




    }


}
