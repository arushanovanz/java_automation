package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;


public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePrecontions(){
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("modifyfirstname").withMiddlename("modifymiddlename").withLastname("lastname")
              .withNickname("nickname").withTitle("title").withCompany("company").withAddress("address").withHomephone("homephone")
              .withMobilephone("mobilephone").withWorkphone("workphone").withFax("fax").withEmail("email").withHomepage("homepage")
              .withBday("17").withBmonth("March").withByear("1985").withAday("18").withAmonth("April").withAyear("1987").withAddress2("address2")
              .withNotes("notes").withSecondaryphone("secondaryphone").withGroupname("test1"));
    }
  }

  @Test
  public void testContactModification() {


    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().initContactModification(index);
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstname("modifyfirstname").withMiddlename("modifymiddlename").withLastname("lastname")
            .withNickname("nickname").withTitle("title").withCompany("company").withAddress("address").withHomephone("homephone")
            .withMobilephone("mobilephone").withWorkphone("workphone").withFax("fax").withEmail("email").withHomepage("homepage")
            .withBday("17").withBmonth("March").withByear("1985").withAday("18").withAmonth("April").withAyear("1987").withAddress2("address2")
            .withNotes("notes").withSecondaryphone("secondaryphone").withGroupname("test1");
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
