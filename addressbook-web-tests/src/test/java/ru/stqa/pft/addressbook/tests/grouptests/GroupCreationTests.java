package ru.stqa.pft.addressbook.tests.grouptests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  public void testCreateNewGroup() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2").withFooter("footer1");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));

  }
}
