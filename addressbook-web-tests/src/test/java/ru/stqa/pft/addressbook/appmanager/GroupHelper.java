package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  protected GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {

    changeFieldValue(By.name("group_name"), groupData.getName());
    changeFieldValue(By.name("group_header"), groupData.getHeader());
    changeFieldValue(By.name("group_footer"), groupData.getFooter());

  }
  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void returnToGroupPage() {

    click(By.linkText("group page"));
  }
  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}