package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testCreateNewGroup() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "header1", "footer1"));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnToGroupPage();
    app.getSessionHelper().logout();
  }
}
