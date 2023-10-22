package tests;

import RetryAnalyzer.retry;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

   @Test(priority = 2, retryAnalyzer = retry.class)
    public void ChecksInputTypes (){

        navPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getEmailInputBoxAttributeValue(), "email",
                "Email input box for attribute should have 'email'.");
        Assert.assertEquals(loginPage.getPasswordInputBoxAttributeValue(), "password",
                "Password input box for attribute should have 'password'.");

    }


    @Test(priority = 3, retryAnalyzer = retry.class)
    public void DisplaysErrorsWhenUserDoesNotExist (){

        String invalidEmail = "non-existing-user@gmal.com";
        String invalidPassword = "password123";

        navPage.clickOnLoginButton();
        loginPage.getEmailInputBox().clear();
        loginPage.getEmailInputBox().sendKeys(invalidEmail);
        loginPage.getPasswordInputBox().clear();
        loginPage.getPasswordInputBox().sendKeys(invalidPassword);
        loginPage.clickOnLoginButton();
        messagePopUpPage.waitUntilErrorPopUpMessageIsVisible();
        Assert.assertEquals(messagePopUpPage.getErrorMessage(),
                "User does not exists");
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");
    }


    @Test(priority = 4, retryAnalyzer = retry.class)
    public void displaysErrorsWhenPasswordIsWrong (){
        String email = "admin@admin.com";
        String wrongPassword = "password123";

        navPage.clickOnLoginButton();
        loginPage.getEmailInputBox().clear();
        loginPage.getEmailInputBox().sendKeys(email);
        loginPage.getPasswordInputBox().clear();
        loginPage.getPasswordInputBox().sendKeys(wrongPassword);
        loginPage.clickOnLoginButton();
        messagePopUpPage.waitUntilErrorPopUpMessageIsVisible();
        Assert.assertEquals(messagePopUpPage.getErrorMessage(),
                "Wrong password");
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");

    }
//    Test #5: Login
//Podaci:
//email: admin@admin.com
//password: 12345
//Koraci:
//Klik na login dugme iz navigacije
//Popuniti login formu podacima za logovanje
//Verifikovati da se u url-u stranice javlja /home ruta
    @Test (priority = 5, retryAnalyzer = retry.class)
    public void login (){
     String email = "admin@admin.com";
     String password = "12345";

     navPage.clickOnLoginButton();
     navPage.waitUntilCurrentUrlContainsLogin();
     loginPage.getEmailInputBox().sendKeys(email);
     loginPage.getPasswordInputBox().sendKeys(password);
     loginPage.clickOnLoginButton();
     navPage.waitUntilCurrentUrlContainsHome();






    }






}
