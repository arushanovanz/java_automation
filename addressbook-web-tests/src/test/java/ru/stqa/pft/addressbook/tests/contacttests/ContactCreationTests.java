package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.tests.TestBase;


import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreateNewContact() throws Exception {
    app.goTo().homePage();
    File photo = new File("src/test/resources/example.png");
    Contacts before =  app.contact().all();
    ContactData contact = new ContactData().withFirstname("firstname1").withMiddlename("middlename1").withLastname("lastname1")
            .withNickname("nickname1").withTitle( "title1").withCompany("company1").withAddress("address1").withHomephone("+7(1111)")
            .withMobilephone("333-3333").withWorkphone("33 333").withFax("fax").withEmail("email").withHomepage("homepage1")
            .withBday("17").withBmonth("March").withByear("1985").withAday("18").withAmonth("April").withAyear("1987").withAddress2("address2")
            .withNotes("notes1").withSecondaryPhone("").withGroupname("name2").withPhoto(photo);
    app.contact().create(contact);
    app.goTo().homePage();
    Contacts after = app.contact().all();
    assertThat(after.size(),  equalTo( before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));

  }
}
