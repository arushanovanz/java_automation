package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  protected SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    changeFieldValue(By.name("user"), username);
    changeFieldValue(By.name("pass"), password);
    click(By.xpath("//input[@value='Login']"));
  }

  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }
}
