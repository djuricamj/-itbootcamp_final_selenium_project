package tests;

import RetryAnalyzer.retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{


    @Test(priority = 1, retryAnalyzer = retry.class)
    public void visitTheLoginPage (){
        navPage.clickOnLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnEnglishButton();

        navPage.clickOnLoginButton();

        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");

    }

//    Test #2: Checks input types
//    Koraci:
//    Klik na login dugme iz navigacije
//    Verifikovati da polje za unos emaila za atribut type ima vrednost email
//    Verifikovati da polje za unos lozinke za atribut type ima vrednost password
   @Test(priority = 2, retryAnalyzer = retry.class)
    public void ChecksInputTypes (){
        navPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getEmailInputBoxAttributeValue(), "email",
                "Email input box for attribute should have 'email'.");
        Assert.assertEquals(loginPage.getPasswordInputBoxAttributeValue(), "password",
                "Password input box for attribute should have 'password'.");


    }



}
