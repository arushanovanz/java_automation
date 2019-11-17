package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.tests.TestBase;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreateNewContact() throws Exception {
    app.goTo().homePage();
    Contacts before =  app.contact().all();
    ContactData contact = new ContactData().withFirstname("firstname1").withMiddlename("middlename1").withLastname("lastname1")
            .withNickname("nickname1").withTitle( "title1").withCompany("company1").withAddress("address1").withHomephone("homephone1")
            .withMobilephone("mobilephone1").withWorkphone("workphone1").withFax("fax").withEmail("email").withHomepage("homepage1")
            .withBday("17").withBmonth("March").withByear("1985").withAday("18").withAmonth("April").withAyear("1987").withAddress2("address2")
            .withNotes("notes1").withSecondaryphone("secondaryphone1").withGroupname("name2");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() + 1);

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));

  }

}
