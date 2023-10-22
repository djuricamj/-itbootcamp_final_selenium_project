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



}
