package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
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
