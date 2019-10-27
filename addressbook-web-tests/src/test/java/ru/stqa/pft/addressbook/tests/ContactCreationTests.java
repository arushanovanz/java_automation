package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {
  @Test
  public void testCreateNewContact() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("firstname", "middlename",
            "lastname",
            "nickname", "title",
            "company", "address",
            "homephone", "mobilephone",
            "workphone", "fax",
            "email", "homepage",
            "17", "March", "1985",
            "18", "April", "1987",
            "address2", "secondaryphone", "notes","name2"),true);
    app.getContactHelper().submitContactCreation();
    app.getSessionHelper().logout();
  }

}
