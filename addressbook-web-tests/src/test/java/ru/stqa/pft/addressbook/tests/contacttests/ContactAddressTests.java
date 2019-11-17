package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withFirstname("firstname").withMiddlename("middlename").withLastname("lastname")
              .withNickname("nickname").withTitle( "title").withCompany("company").withAddress("address").withHomephone("homephone")
              .withMobilephone("mobilephone").withWorkphone("workphone").withFax("fax").withEmail("email").withHomepage("homepage")
              .withBday("17").withBmonth("March").withByear("1985").withAday("18").withAmonth("April").withAyear("1987").withAddress2("address2")
              .withNotes("notes").withSecondaryPhone("secondaryphone").withGroupname("test2"));
    }
  }
  @Test
  public void testContactAddresses() {

    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(cleaned(contact.getAddress()), equalTo(cleaned(contactInfoFromEditForm.getAddress())));
  }

  public static  String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
