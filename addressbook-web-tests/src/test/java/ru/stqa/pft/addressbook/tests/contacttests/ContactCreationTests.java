package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreateNewContact() throws Exception {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstname("firstname1").withMiddlename("middlename1").withLastname("lastname1")
            .withNickname("nickname1").withTitle( "title1").withCompany("company1").withAddress("address1").withHomephone("homephone1")
            .withMobilephone("mobilephone1").withWorkphone("workphone1").withFax("fax").withEmail("email").withHomepage("homepage1")
            .withBday("17").withBmonth("March").withByear("1985").withAday("18").withAmonth("April").withAyear("1987").withAddress2("address2")
            .withNotes("notes1").withSecondaryphone("secondaryphone1").withGroupname("name2");
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

//    app.getSessionHelper().logout();
  }

}
