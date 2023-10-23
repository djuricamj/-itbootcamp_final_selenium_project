package tests;

import RetryAnalyzer.retry;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;

public class AuthRoutesTests extends BasicTest{

@Test(priority = 1, retryAnalyzer = retry.class)
public void ForbidsVisitsToHomeUrlIfNotAuthenticated() {

    driver.navigate().to(baseUrl + "/home");
    Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/login",
            "Current url should be " + baseUrl + "/login");
}

}
