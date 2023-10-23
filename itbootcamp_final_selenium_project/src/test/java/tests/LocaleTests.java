package tests;

import org.testng.Assert;

public class LocaleTests extends BasicTest{

    public void  SetLocaleToEs (){
        navPage.clickOnLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnSpanishLanguage();
        Assert.assertEquals(navPage.getHeaderText(), "Página de aterrizaje",
                "Text in header should be 'Página de aterrizaje'.");

    }

}
