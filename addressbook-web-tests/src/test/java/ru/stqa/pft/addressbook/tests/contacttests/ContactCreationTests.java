package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactCreationTests extends TestBase {
  @Test
  public void testCreateNewContact() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createContact(new ContactData("firstname", "middlename",
            "lastname",
            "nickname", "title",
            "company", "address",
            "homephone", "mobilephone",
            "workphone", "fax",
            "email", "homepage",
            "17", "March", "1985",
            "18", "April", "1987",
            "address2", "secondaryphone", "notes","test1"));

    app.getSessionHelper().logout();
  }

}
