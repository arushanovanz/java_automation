package ru.stqa.pft.addressbook.tests.grouptests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class GroupCreationTests extends TestBase {

  @Test
  public void testCreateNewGroup() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("test1", null, "footer1"));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before+1);
    app.getSessionHelper().logout();
  }
}
