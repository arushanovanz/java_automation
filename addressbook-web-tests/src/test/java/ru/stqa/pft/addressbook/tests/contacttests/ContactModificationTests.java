package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePrecontions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("modifyfirstname").withMiddlename("modifymiddlename").withLastname("lastname")
              .withNickname("nickname").withTitle("title").withCompany("company").withAddress("address").withHomephone("homephone")
              .withMobilephone("mobilephone").withWorkphone("workphone").withFax("fax").withEmail("email").withHomepage("homepage")
              .withBday("17").withBmonth("March").withByear("1985").withAday("18").withAmonth("April").withAyear("1987").withAddress2("address2")
              .withNotes("notes").withSecondaryPhone("secondaryphone").withGroupname("test1"));
    }
  }

  @Test
  public void testContactModification() {

    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    app.contact().initContactModificationById(modifiedContact.getId());
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("modifyfirstname").withMiddlename("modifymiddlename").withLastname("lastname")
            .withNickname("nickname").withTitle("title").withCompany("company").withAddress("address").withHomephone("homephone")
            .withMobilephone("mobilephone").withWorkphone("workphone").withFax("fax").withEmail("email").withHomepage("homepage")
            .withBday("17").withBmonth("March").withByear("1985").withAday("18").withAmonth("April").withAyear("1987").withAddress2("address2")
            .withNotes("notes").withSecondaryPhone("secondaryphone").withGroupname("test 2");
    app.contact().modify(contact);
    app.goTo().homePage();

    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    ;
    app.goTo().homePage();

  }

}
