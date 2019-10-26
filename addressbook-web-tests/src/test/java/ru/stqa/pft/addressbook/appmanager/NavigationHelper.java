package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
  WebDriver wd;

  protected NavigationHelper(WebDriver wd) {
    this.wd =wd;
  }

  public void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void gotoGroupPage() { wd.findElement(By.linkText("groups")).click();
  }
}
