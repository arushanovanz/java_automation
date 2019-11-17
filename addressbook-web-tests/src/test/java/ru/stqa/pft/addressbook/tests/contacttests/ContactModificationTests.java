package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;


public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.goTo().homePage();
    if (app.contact().list().size()==0) {
      app.contact().create(new ContactData("modifyfirstname", "modifymiddlename",
              "lastname",
              "nickname", "title",
              "company", "address",
              "homephone", "mobilephone",
              "workphone", "fax",
              "email", "homepage",
              "17", "March", "1985",
              "18", "April", "1987",
              "address2", "secondaryphone", "notes", "1"));
    }

    List<ContactData> before = app.contact().list();
    int index =  before.size() - 1;
    app.contact().initContactModification(index);
    ContactData contact = new ContactData(before.get(index).getId(), "firstname1", "middlename1",
            "lastname1",
            "nickname1", "title1",
            "company1", "address1",
            "homephone1", "mobilephone1",
            "workphone1", "fax1",
            "email1", "homepage1",
            "27", "February", "1945",
            "28", "December", "1977",
            "address22", "secondaryphone22", "notes22", null);
    app.contact().modify(contact);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    app.goTo().homePage();
  }

  

}
