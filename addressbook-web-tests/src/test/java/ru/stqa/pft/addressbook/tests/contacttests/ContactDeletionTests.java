package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("deletefirstname").withMiddlename("deletemiddlename").withLastname("lastname")
              .withNickname("nickname").withTitle("title").withCompany("company").withAddress("address").withHomephone("homephone")
              .withMobilephone("mobilephone").withWorkphone("workphone").withFax("fax").withEmail("email").withHomepage("homepage")
              .withBday("17").withBmonth("March").withByear("1985").withAday("18").withAmonth("April").withAyear("1987").withAddress2("address2")
              .withNotes("notes").withSecondaryPhone("secondaryphone").withGroupname("test1"));
    }
  }

  @Test
  public void testDeleteSelectedContact() {

    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    ;
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size() - 1));

    before.remove(deletedContact);
    assertThat(after, equalTo(before.without(deletedContact)));
    app.goTo().homePage();

  }
}
