package tests;

import RetryAnalyzer.retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = retry.class)
    public void  SetLocaleToEs (){
        navPage.clickOnLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnSpanishLanguage();
        Assert.assertEquals(navPage.getHeaderText(), "Página de aterrizaje",
                "Text in header should be 'Página de aterrizaje'.");

    }

    @Test(priority = 2, retryAnalyzer = retry.class)
    public void  SetLocaleToEn (){
        navPage.clickOnLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnEnglishButton();
        Assert.assertEquals(navPage.getHeaderText(), " Landing",
                "Text in header should be ' Landing'.");
    }

}
