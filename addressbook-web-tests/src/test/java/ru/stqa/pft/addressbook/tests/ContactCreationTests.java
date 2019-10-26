package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {
  @Test
  public void testCreateNewContact() throws Exception {

    app.initContactCreation();
    app.fillContactForm(new ContactData("firstname", "middlename",
            "lastname",
            "nickname", "title",
            "company", "address",
            "homephone", "mobilephone",
            "workphone", "fax",
            "email", "homepage",
            "17", "March", "1985",
            "18", "April", "1987",
            "address2", "secondaryphone", "notes"));
    app.submitContactCreation();
    app.logout();
  }

}
