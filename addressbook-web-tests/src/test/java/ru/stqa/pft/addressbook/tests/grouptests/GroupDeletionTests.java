package ru.stqa.pft.addressbook.tests.grouptests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class GroupDeletionTests extends TestBase {
  @Test
  public void testDeleteSelectedGroup() throws Exception{
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (!app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData("name3","header3","footer3"));
    }
    app.getGroupHelper().selectGroup(before-1);
    app.getGroupHelper().deleteSelectedGroups();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before-1);
    app.getGroupHelper().returnToGroupPage();

  }
}
