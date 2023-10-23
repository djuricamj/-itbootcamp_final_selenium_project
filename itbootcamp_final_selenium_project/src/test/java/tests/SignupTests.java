package tests;

import RetryAnalyzer.retry;
import org.asynchttpclient.request.body.multipart.StringPart;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{


    @Test(priority = 1, retryAnalyzer = retry.class)
    public void visitTeSignUpPage (){

        navPage.clickOnSignUpButton();
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/signup",
                "Current url should be " + baseUrl + "/signup");

    }
    @Test(priority = 2, retryAnalyzer = retry.class)
    public void checksInputTypes (){

        navPage.clickOnSignUpButton();
        Assert.assertEquals(signupPage.getNameInputBoxAttributeValue(), "text",
                "Name input box for attribute should have 'text'.");
        Assert.assertEquals(signupPage.getEmailInputBoxAttributeValue(),"text",
                "Email input box for attribute should have 'email'.");
        Assert.assertEquals(signupPage.getPasswordInputBoxAttributeValue(), "password",
                "Password input box for attribute should have 'password'.");
        Assert. assertEquals(signupPage.getConfirmPasswordInputBoxAttributeValue(), "password",
                "Confirm Password input box for attribute should have 'password'.");
    }

    @Test(priority = 3, retryAnalyzer = retry.class)
    public void displaysErrorsWhenUserAlreadyExists (){
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.clickOnSignUpButton();
        navPage.waitUntilCurrentUrlContainsSignup();
        signupPage.getNameInputBox().clear();
        signupPage.getNameInputBox().sendKeys(name);
        signupPage.getEmailInpuBox().clear();
        signupPage.getEmailInpuBox().sendKeys(email);
        signupPage.getPasswordInputBox().clear();
        signupPage.getPasswordInputBox().sendKeys(password);
        signupPage.getConfirmPasswordInputBox().clear();
        signupPage.getConfirmPasswordInputBox().sendKeys(confirmPassword);
        signupPage.clickOnSignupButton();
        messagePopUpPage.waitUntilErrorPopUpMessageIsVisible();
        Assert.assertEquals(messagePopUpPage.getErrorMessage(),
                "E-mail already exists", "Error message should contains 'E-mail already exists'.");
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/signup",
                "Current url should be " + baseUrl + "/signup");

    }
    @Test(priority = 4, retryAnalyzer = retry.class)
    public void signup (){
        String name = "Marijana Djurica";
        String email = "marijana.djurica@itbootcamp.rs";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.clickOnSignUpButton();
        navPage.waitUntilCurrentUrlContainsSignup();
        signupPage.getNameInputBox().clear();
        signupPage.getNameInputBox().sendKeys(name);
        signupPage.getEmailInpuBox().clear();
        signupPage.getEmailInpuBox().sendKeys(email);
        signupPage.getPasswordInputBox().clear();
        signupPage.getPasswordInputBox().sendKeys(password);
        signupPage.getConfirmPasswordInputBox().clear();
        signupPage.getConfirmPasswordInputBox().sendKeys(confirmPassword);
        signupPage.clickOnSignupButton();
        navPage.waitUntilCurrentUrlContainsHome();
        Assert.assertEquals(messagePopUpPage.getTextForMessageForAccountVerify(), "IMPORTANT: Verify your account",
                "Error message should be 'IMPORTANT: Verify your account'.");
        messagePopUpPage.clickOnCloseButton();
        navPage.clickOnLogoutButton();


    }



}
