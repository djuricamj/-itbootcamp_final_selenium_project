package tests;

import RetryAnalyzer.retry;
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



}
