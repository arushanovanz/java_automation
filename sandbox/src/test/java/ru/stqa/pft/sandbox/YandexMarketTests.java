package ru.stqa.pft.sandbox;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import ru.stqa.pft.sandbox.catalog.MobilePhonesPage;

public class YandexMarketTests {

  private ElementsCollection mobilePhones;
  private String mobileSearchWindow;

  @Test
  public void addMobilePhoneToComparePageTest() throws InterruptedException {
    MobilePhonesPage mpp = new MobilePhonesPage();
    open("https://market.yandex.ru/");
    $("#header-search").setValue("Мобильные телефоны").pressEnter();
      mobileSearchWindow = getWebDriver().getWindowHandle();
   // $(By.className("n-filter-sorter i-bem n-filter-sorter_js_inited n-filter-sorter_state_select")).waitUntil(visible, 30000).click();
     $(byText("по новизне")).click();
     // mobilePhones = $$x("//h3[@class='n-snippet-cell2__title']");
      mobilePhones = $$x("//div[@class= 'n-product-toolbar__item link link_theme_minor hint n-user-lists_type_compare i-bem n-user-lists_type_compare_in-list_no n-user-lists_type_compare_js_inited']");
      SelenideElement firstMobilePhone =  mobilePhones.first();
      mpp.addMobilePhoneToCompareList(firstMobilePhone);
    //  switchTo().window(mobileSearchWindow);
      SelenideElement secondMobilePhone = mobilePhones.last();
      mpp.addMobilePhoneToCompareList(secondMobilePhone);
      Configuration.holdBrowserOpen= true;

    }

}

