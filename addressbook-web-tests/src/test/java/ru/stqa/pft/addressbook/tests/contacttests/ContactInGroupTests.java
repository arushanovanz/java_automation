package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePrecontions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("name3").withHeader("header3").withFooter("footer3"));
    }
    if (app.db().contacts().size() == 0) {
      File photo = new File("src/test/resources/example.png");
      app.contact().create(new ContactData().withFirstname("firstname").withMiddlename("middlename").withLastname("lastname")
              .withNickname("nickname").withTitle("title").withCompany("company").withAddress("address").withHomephone("homephone")
              .withMobilephone("mobilephone").withWorkphone("workphone").withFax("fax").withEmail("email").withHomepage("homepage")
              .withBday("17").withBmonth("March").withByear("1985").withAday("18").withAmonth("April").withAyear("1987").withAddress2("address2")
              .withNotes("notes").withSecondaryPhone("secondaryphone").withPhoto(photo));
    }
  }

  @Test
  public void testAddContactInGroup() {

    Groups groupsBefore = app.db().groups();
    ContactData contact = app.db().contacts().iterator().next();
    GroupData group = app.db().groups().iterator().next();
    int idGroup = group.getId();
    int idContact = contact.getId();
    app.goTo().homePage();
    app.contact().addContactToGroup(contact.getId(), group.getId());
    Groups groupsAfter = app.db().groups().withAdded(group);
    assertThat(groupsAfter, equalTo(groupsBefore.withAdded(group)));

  }

  @Test
  public void testRemoveContactFromGroup() {
    Groups groupsBefore = app.db().groups();
    ContactData contact = app.db().contacts().iterator().next();
    GroupData group = app.db().groups().iterator().next();
    if (!contact.getGroups().contains(group)) {
      app.contact().addContactToGroup(contact.getId(), group.getId());
    }
    app.goTo().homePage();
    app.contact().deleteContactFromGroup(contact.getId(), group.getId());
    ;
    Groups groupsAfter = app.db().groups().without(group);
    assertThat(groupsAfter, equalTo(groupsBefore.without(group)));
  }

}
