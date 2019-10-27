package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("modifyfirstname", "modifymiddlename",
              "lastname",
              "nickname", "title",
              "company", "address",
              "homephone", "mobilephone",
              "workphone", "fax",
              "email", "homepage",
              "17", "March", "1985",
              "18", "April", "1987",
              "address2", "secondaryphone", "notes", "name2"));
    }

    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("firstname1", "middlename1",
            "lastname1",
            "nickname1", "title1",
            "company1", "address1",
            "homephone1", "mobilephone1",
            "workphone1", "fax1",
            "email1", "homepage1",
            "27", "February", "1945",
            "28", "December", "1977",
            "address22", "secondaryphone22", "notes22",null),false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }

}
