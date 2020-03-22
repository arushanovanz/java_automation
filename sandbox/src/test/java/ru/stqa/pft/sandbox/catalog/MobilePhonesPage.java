package ru.stqa.pft.sandbox.catalog;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.$;

public class MobilePhonesPage {

  public void addMobilePhoneToCompareList(SelenideElement locator) {
    $(locator).click();
  }
}
