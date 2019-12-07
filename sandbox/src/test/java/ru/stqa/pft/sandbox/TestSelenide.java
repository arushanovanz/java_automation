package ru.stqa.pft.sandbox;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestSelenide {

  @Test
  public void firstSelenideTest(){
    open("/localhost/addressbook");
    $("#submit").click();
//    $(".message").shouldHave(text("Привет"));
  }

}
