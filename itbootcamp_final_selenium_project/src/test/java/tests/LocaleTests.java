package tests;

import RetryAnalyzer.retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = retry.class)
    public void  setLocaleToEs (){
        navPage.clickOnLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnSpanishLanguage();
        Assert.assertEquals(navPage.getHeaderText(), "Página de aterrizaje",
                "Text in header should be 'Página de aterrizaje'.");

    }

    @Test(priority = 2, retryAnalyzer = retry.class)
    public void  setLocaleToEn (){
        navPage.clickOnLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnEnglishButton();
        Assert.assertEquals(navPage.getHeaderText(), "Landing",
                "Text in header should be ' Landing'.");
    }

    @Test(priority = 3, retryAnalyzer = retry.class)
    public void setLocaleToCn (){
        navPage.clickOnLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnChineseLanguage();
        Assert.assertEquals(navPage.getHeaderText(), "首页",
                "Text in header should be '首页'.");

    }

    @Test(priority = 4,retryAnalyzer = retry.class)
    public void setLocaleToFr (){
        navPage.clickOnLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnFrenchLanguage();
        Assert.assertEquals(navPage.getHeaderText(), "Page d'atterrissage",
                "Text in header should be  Page d'atterrissage'.");
    }

}
