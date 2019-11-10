package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.List;

public class ContactDeletionTests extends TestBase {
  @Test
  public void testDeleteSelectedContact() {

    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("deletefirstname", "deletemiddlename",
              "lastname",
              "nickname", "title",
              "company", "address",
              "homephone", "mobilephone",
              "workphone", "fax",
              "email", "homepage",
              "17", "March", "1985",
              "18", "April", "1987",
              "address2", "secondaryphone", "notes", "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deleteSelectedContacts();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()-1);
    before.remove(before.size ()-1);
    Assert.assertEquals(before, after);
    app.getNavigationHelper().gotoHomePage();

  }

}
